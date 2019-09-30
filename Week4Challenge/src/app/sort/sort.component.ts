import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sort',
  templateUrl: './sort.component.html',
  styleUrls: ['./sort.component.css']
})
export class SortComponent implements OnInit {

  inString = "";
  outString;

  sortString() {
    var splitString = this.inString.split(",");
    // var sortArray = splitString.sort; 
    // this.outString = sortArray;
  }

  constructor() { }

  ngOnInit() {
  }

}
