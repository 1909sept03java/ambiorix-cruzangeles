import { Component, OnInit } from '@angular/core';
import { Pali } from '../pali';
import { reverse } from 'dns';

@Component({
  selector: 'app-palindrome',
  templateUrl: './palindrome.component.html',
  styleUrls: ['./palindrome.component.css']
})
export class PalindromeComponent implements OnInit {

  /*
  pali: Pali = {
    inString: "inBlank",
    outString: "outBlank",
    isPali: false
  }
*/

  inString = "";
  outString = ""
  isPali = false;

  reverseString() {
    // Step 1. Use the split() method to return a new array
    var splitString = this.inString.split(""); 
    // Step 2. Use the reverse() method to reverse the new created array
    var reverseArray = splitString.reverse(); 
    // Step 3. Use the join() method to join all elements of the array into a string
    var joinArray = reverseArray.join(""); 
    this.outString = joinArray;
}

  isPalindrome() {
    if (this.inString == this.outString) {
      this.isPali = true;
    } else {
      this.isPali = false;
    }
  }

  constructor() { }

  ngOnInit() {
  }

}
