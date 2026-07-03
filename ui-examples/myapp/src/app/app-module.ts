import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { UserItem } from './user-item/user-item';
import { FormsModule } from '@angular/forms';
import { IdGenPipe } from './id-gen-pipe';
import { Parent } from './parent/parent';
import { Child } from './child/child';

@NgModule({
  declarations: [App, UserItem, IdGenPipe, Parent, Child],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App],
})
export class AppModule {}
