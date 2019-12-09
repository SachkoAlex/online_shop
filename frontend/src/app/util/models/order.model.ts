import {Cart} from './cart.model';

export class Order {
  cart: Cart;
  firstName: string;
  lastName: string;
  phoneNumber: string;
  email: string;
  address: string;
}
