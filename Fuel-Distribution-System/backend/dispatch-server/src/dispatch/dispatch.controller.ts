import { Controller} from '@nestjs/common';
import { Client, ClientKafka, MessagePattern, Payload, Transport } from '@nestjs/microservices';
import { DispatchService } from './service/dispatch.service';

const kafkaHost = process.env.KAFKA_HOST || 'localhost';
const kafkaPort = process.env.KAFKA_PORT || '9092';

@Controller('dispatch')

export class DispatchController {

    constructor(private dispatchService: DispatchService) {}
  
  //kafka consumer
  @MessagePattern('allocation-topic') 
  scheduleListener(@Payload() message) {
    console.log("new message " +JSON.stringify(message))

    message.scheduledDate = this.dispatchService.setDateValues(
      message.scheduledDate,
    );

    console.log('Create a Dispatch for ' + JSON.stringify(message));
    return this.dispatchService.create(message);

  }
  
  @Client({
    transport: Transport.KAFKA,
    options: {
      client: {
        clientId: 'allocation-topic',
        brokers: [`${kafkaHost}:${kafkaPort}`],
      },
      consumer: {
        groupId: 'allocation-group',
      },
    },
  })

  client: ClientKafka;

  async onModuleInit() {
    this.client.subscribeToResponseOf('dispatch-topic');
    await this.client.connect();

  }
   


  async updateOrderStatus(id) {
    this.client.emit('dispatch-topic', id);
  }
}
