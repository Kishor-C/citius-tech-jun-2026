import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../user-service';

@Component({
  selector: 'app-reactive-login',
  standalone: false,
  templateUrl: './reactive-login.html',
  styleUrl: './reactive-login.css',
})
export class ReactiveLogin {
  builder = inject(FormBuilder);
  loginForm = this.builder.group({
    username: ['', Validators.compose([Validators.required, Validators.minLength(5)])],
    password: [''],
  });
  message = '';
  service = inject(UserService);
  // it doesn't need to accept form data from the view
  // because loginForm in the component and form in the HTML both will be in sync
  handleLogin() {
    let login = this.loginForm;
    let status = this.service.authenticate(
      <string>login.controls['username'].value,
      <string>login.controls['password'].value,
    );
    if (status) {
      this.message = 'Authentication is success';
    } else {
      this.message = 'Authentication is failed';
    }
  }
}
