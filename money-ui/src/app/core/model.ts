export class Category {
  id: number;
  name: string;
}

export class Addres {
  street: string;
  city: string;
  state: string;
  stateFull: string;
  zipcode: string;
  phoneNumber: string;
  mobileNumber: string;
}

export class Person {
  constructor(enabled: boolean){
    this.enabled = enabled;
  }
  id: number;
  name: string;
  enabled: boolean;
  address: Addres = new Addres();
}

export class Expense {
  id: number;
  description: string;
  invoiceExpirationDate: Date;
  payableDate: Date;
  amount: number;
  observation?: any;
  type: string;
  category: Category = new Category();
  person: Person = new Person(true);
}
