import { Component, OnInit, OnDestroy, AfterContentInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles/articles.service';
import { LocationStrategy } from '@angular/common';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { fakeAsync } from '@angular/core/testing';
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class UserListComponent implements OnInit, OnDestroy {
  articlesSub: Subscription;
  articles: any[];
  userSUb: Subscription;
  user: any;
  currentArticle: any;
  currentIndex = -1;
  searchTitle = '';
  categorie = '';
  
  constructor(
    private articlesService: ArticlesService,
    private url: LocationStrategy,
    private route: Router,
    private userService:AuthService
  ) {}

  ngOnInit(): void {
    this.articles = [];
    console.log(this.route.url);
    if (this.route.url === '/articles/PcBureau') {
      this.categorie = 'PcBureau';
    }
    if (this.route.url === '/articles/Accessoires') {
      this.categorie = 'Accessoires';
    }
    if (this.route.url === '/articles/PcPortable') {
      this.categorie = 'Pc Portables';
    }

    this.articlesSub = this.articlesService.articlesSubject.subscribe(
      (data) => {
        if (this.route.url === '/articles/PcBureau') {
          this.articles = data.filter((x) => x.categorie.nom == 'PcBureau');
        }
        if (this.route.url === '/articles/Accessoires') {
          this.articles = data.filter((x) => x.categorie.nom == 'Accessoires');
        }
        if (this.route.url === '/articles/PcPortable') {
          this.articles = data.filter((x) => x.categorie.nom == 'PcPortable');
        }
      }
    );

    this.articlesService.getAllArticlesFromServer();

     this.userSUb = this.userService.userSub.subscribe(
      (data) => {
         this.user = data;
      }
    );

    this.userService.emituser();
  }

  checkuser() {
    this.userService.emituser();
    console.log(this.user);
    console.log("test");
    if (this.user != null && this.user.role != null) {
      if (this.user.role == "Admin") {
        return true;
      }
      else {
        return false;
      }
      
    }
    return false;
  }

  test(id: number) {
    this.articlesService.deleteArticle(id);
  }
  ngOnDestroy(): void {
    this.articlesSub.unsubscribe();
  }
}
