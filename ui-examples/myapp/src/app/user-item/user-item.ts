import { Component } from '@angular/core';

@Component({
  selector: 'app-user-item',
  standalone: false,
  templateUrl: './user-item.html',
  styleUrl: './user-item.css',
})
export class UserItem {
  username = 'Alex';
  gender = 'Male';
}
