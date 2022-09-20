import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import { AppController } from './app.controller';
import { mongodbConnection } from './app.properties';
import { AppService } from './app.service';
import { DispatchController } from './dispatch/dispatch.controller';
import { DispatchModule } from './dispatch/dispatch.module';
import { DispatchRepository } from './dispatch/repository/dispatch.repository';
import { DispatchService } from './dispatch/service/dispatch.service';

@Module({
  imports: [ DispatchModule,MongooseModule.forRoot(mongodbConnection)],
  controllers: [],
  providers: [],
})
export class AppModule {}
