import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PalindromeComponent } from './palindrome/palindrome.component';

import { FormsModule } from '@angular/forms';
import { SortComponent } from './sort/sort.component'; // <-- NgModel lives here

@NgModule({
  declarations: [
    AppComponent,
    PalindromeComponent,
    SortComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
