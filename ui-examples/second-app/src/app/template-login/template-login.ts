import { Component } from '@angular/core';

@Component({
  selector: 'app-template-login',
  standalone: false,
  templateUrl: './template-login.html',
  styleUrl: './template-login.css',
})
export class TemplateLogin {
  username: string = '';
  password: string = '';

  // prints the credentials entered
  handleLogin(login: any) {
    console.log(login);
  }
}
