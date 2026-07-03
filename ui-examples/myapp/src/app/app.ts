import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css',
})
export class App {
  //*ngIf and *ngFor
  message1 = undefined;
  message2 = 'Registered Successfully';

  products = [
    { id: 21, name: 'Mobile', price: 15000, rating: 4.2 },
    { id: 31, name: 'TV', price: 75000, rating: 4.5 },
    { id: 41, name: 'Pullup Bar', price: 2000, rating: 4.3 },
    { id: 51, name: 'Guitar', price: 8000, rating: 4.6 }
  ];

  // simple type
  name = 'Kishor';
  phone = 93293293123;
  // object - complex type
  service = { id: 500, name: 'Photography', price: 5000.0, rating: 4.5 };

  isDisabled = true;

  toggle() {
    this.isDisabled = !this.isDisabled;
  }
  userInput(value: string) {
    this.name = value;
  }
}
