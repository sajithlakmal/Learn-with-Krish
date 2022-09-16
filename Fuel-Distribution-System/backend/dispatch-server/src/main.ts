import { NestFactory } from '@nestjs/core';
import { Transport } from '@nestjs/microservices';
import { AppModule } from './app.module';

const cors = require('cors');

async function bootstrap() {
  //kafka configs
  const kafkaHost = process.env.KAFKA_HOST || 'localhost';
  const kafkaPort = process.env.KAFKA_PORT || '9092';

  const app = await NestFactory.create(AppModule);
  app.connectMicroservice({
    transport: Transport.KAFKA,
    options: {
      client: {
        brokers: [`${kafkaHost}:${kafkaPort}`],
      },
      consumer: {
        groupId: 'allocation-group',
      },
    },
  });
  app.enableCors();
  app.use(cors({ origin: 'http://localhost:4200' }));
  await app.startAllMicroservices();
  await app.listen(8085, () => 'dispatch-service started...');
}
bootstrap();
