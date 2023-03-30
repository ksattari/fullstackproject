import { OrderItem } from './order-item';
export class Order {

    orderId: string;
    customerName: string;
    address: string;
    phoneNumber: string;
    orderItems: OrderItem[]; 
    orderTotal: string;
    orderDate: string;
    orderStatus: string;
}
