import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  standalone: false,
  templateUrl: './child.html',
  styleUrl: './child.css',
})
export class Child {
  @Input() // parent can pass data to user variable
  user: string = 'Guest';
  @Output()
  countEmitter = new EventEmitter<number>();
  counter = 0;
  addCounter() {
    let temp = this.counter++;
    // a $event is emitted which is the data
    this.countEmitter.emit(temp);
  }
}
