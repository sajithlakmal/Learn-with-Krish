import { Module } from "@nestjs/common";
import { MongooseModule } from "@nestjs/mongoose";
import { DispatchController } from "./dispatch.controller";
import { DispatchRepository } from "./repository/dispatch.repository";
import { Dispatch, DispatchSchema } from "./schemas/dispatch.schema";
import { DispatchService } from "./service/dispatch.service";

@Module({
    imports: [
      MongooseModule.forFeature([
        { name: Dispatch.name, schema: DispatchSchema },
      ]),
    ],
    controllers: [DispatchController],
    providers: [DispatchService, DispatchRepository],
  })
  export class DispatchModule {}