import { Component, OnInit, OnDestroy, AfterContentInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles/articles.service';
import { LocationStrategy } from '@angular/common';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class UserListComponent implements OnInit, OnDestroy {
  articlesSub: Subscription;
  articles: any[];
  currentArticle: any;
  currentIndex = -1;
  searchTitle = '';
  categorie = '';
  constructor(
    private articlesService: ArticlesService,
    private url: LocationStrategy,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.articles = [];
    console.log(this.route.url);

    this.articlesSub = this.articlesService.articlesSubject.subscribe(
      (data) => {
        if (this.route.url === '/articles/PcBureau') {
          this.categorie = 'PcBureau';
          this.articles = data.filter((x) => x.categorie.nom == 'PcBureau');
        }
        if (this.route.url === '/articles/Accessoires') {
          this.categorie = 'Accessoires';
          this.articles = data.filter((x) => x.categorie.nom == 'Accessoires');
        }
        if (this.route.url === '/articles/PcPortable') {
          this.categorie = 'Pc Portables';
          this.articles = data.filter((x) => x.categorie.nom == 'PcPortable');
        }
      }
    );

    this.articlesService.getAllArticlesFromServer();
  }

  ngOnDestroy(): void {
    this.articlesSub.unsubscribe();
  }
}
