import { FuelType } from "./fuelType";
import { Quantity } from "./quantity";

export class OrderModel {

  orderID!: string; 
  StationId!: string;
  fuelType!: FuelType;
  quantity!: Quantity;

  orderedTime!:string;

  allocated!: boolean; 
  allocatedTime!: string;

  scheduled!: boolean; 
  scheduledTime!: string;

  dispatched!: boolean; 
  dispatchedTime!: string;
  
  delivered!: boolean; 
  deliveredTime!: string;

}