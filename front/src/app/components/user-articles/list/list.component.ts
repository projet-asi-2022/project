import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles/articles.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class UserListComponent implements OnInit {
  articles: any;
  currentArticle: any;
  currentIndex = -1;
  searchTitle = '';

  constructor(private articlesService: ArticlesService) {}

  ngOnInit(): void {
    this.articlesService.getAllArticlesFromServer();
  }
}
