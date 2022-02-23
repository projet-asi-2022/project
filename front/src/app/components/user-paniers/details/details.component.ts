import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  currentBook: any;
  message = '';

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {}
}
