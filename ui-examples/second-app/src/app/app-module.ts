import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { TemplateLogin } from './template-login/template-login';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReactiveLogin } from './reactive-login/reactive-login';
import { provideHttpClient } from '@angular/common/http';
import { UsersList } from './users-list/users-list';
import { UserForm } from './user-form/user-form';

@NgModule({
  declarations: [App, TemplateLogin, ReactiveLogin, UsersList, UserForm],
  imports: [BrowserModule, AppRoutingModule, FormsModule, ReactiveFormsModule],
  providers: [provideBrowserGlobalErrorListeners(), provideHttpClient()],
  bootstrap: [App],
})
export class AppModule {}
