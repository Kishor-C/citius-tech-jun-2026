import { Component, inject } from '@angular/core';
import { UserService } from '../user-service';

@Component({
  selector: 'app-users-list',
  standalone: false,
  templateUrl: './users-list.html',
  styleUrl: './users-list.css',
})
export class UsersList {
  service = inject(UserService);
  users: any = undefined;
  handleClick() {
    this.service.getUsers().subscribe({
      next: (value) => (this.users = value),
      error: (err) => alert('Something went wrong: ' + err),
    });
  }
}
