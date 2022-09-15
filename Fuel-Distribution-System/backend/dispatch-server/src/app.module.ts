import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { DispatchController } from './dispatch/dispatch.controller';
import { DispatchRepository } from './dispatch/repository/dispatch.repository';
import { DispatchService } from './dispatch/service/dispatch.service';

@Module({
  imports: [],
  controllers: [AppController, DispatchController],
  providers: [AppService,DispatchService,DispatchRepository],
})
export class AppModule {}
