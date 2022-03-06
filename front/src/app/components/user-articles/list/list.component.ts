import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles/articles.service';
import { LocationStrategy } from '@angular/common';

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
  categorie = '';
  constructor(
    private articlesService: ArticlesService,
    private url: LocationStrategy
  ) {}

  ngOnInit(): void {
    console.log(this.url.path());
    if (this.url.path() === '/articles/PcBureau') {
      this.categorie = 'PcBureau';
    }
    if (this.url.path() === '/articles/Accessoires') {
      this.categorie = 'Accessoires';
    }
    this.articlesService.getAllArticlesFromServer();
  }
}
