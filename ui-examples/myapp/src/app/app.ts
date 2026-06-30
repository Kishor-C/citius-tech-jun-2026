import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css',
})
export class App {
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
