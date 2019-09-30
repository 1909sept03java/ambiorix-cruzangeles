import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PalindromeComponent } from './palindrome/palindrome.component';

import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

@NgModule({
  declarations: [
    AppComponent,
    PalindromeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
