import { Injectable } from '@nestjs/common';
import { DispatchModel } from '../model/DispatchCreateDto';
import { DispatchRepository } from '../repository/dispatch.repository';
import { Dispatch } from '../schemas/dispatch.schema';

@Injectable()
export class DispatchService {


   async create(dispatchCreateDto: DispatchModel) {


        const dispatch = new Dispatch();

        dispatch.orderId = dispatchCreateDto.orderId;
        dispatch.station = dispatchCreateDto.StationId;

       
        dispatch.octane92 = dispatchCreateDto.octane92;
        dispatch.quantityOctane92 = dispatchCreateDto.quantityOctane92;
    
        dispatch.octane95 = dispatchCreateDto.octane95;
        dispatch.quantityOctane95 = dispatchCreateDto.quantityOctane95;
    
        dispatch.autoDiesel = dispatchCreateDto.autoDiesel;
        dispatch.quantityAutoDiesel = dispatchCreateDto.quantityAutoDiesel;
    
        dispatch.superDiesel = dispatchCreateDto.superDiesel;
        dispatch.quantitySuperDiesel = dispatchCreateDto.quantitySuperDiesel;
    





    }
    setDateValues(scheduledDate: any): any {
        throw new Error('Method not implemented.');
    }
}
