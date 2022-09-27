import { FuelType } from "./fuelType";
import { Quantity } from "./quantity";

export class Dispatch {

    orderID!: string;
    stationId!: string;
    fuelType!: FuelType;
    quantity!: Quantity;

    allocated!: boolean; 
    allocatedTime!: string;
    scheduled!: boolean;
    scheduledTime!: string;
    dispatched!: boolean; 
    dispatchedTime!: string;
    delivered!: boolean; 
    deliveredTime!: string;
   
  }