import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ArticlesService } from 'src/app/services/articles/articles.service';
import { PanierService } from 'src/app/services/panier/panier.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class UserDetailsComponent implements OnInit {
  currentArticle: any;
  message = '';
  apiUrl: string = environment.api + 'articles';
  article: any;

  constructor(
    private httpClient: HttpClient,
    private route: ActivatedRoute,
    private articleService: ArticlesService,
    private panierService: PanierService
  ) {}

  ngOnInit(): void {
    this.httpClient
      .get<any[]>(this.apiUrl + '/' + this.route.snapshot.paramMap.get('id'))
      .subscribe((reponse) => {
        this.article = reponse;
        console.log(reponse);
      });
  }

  delete(id: number) {
    this.articleService.deleteArticle(id);
  }

  addToPanier() {
    this.panierService.addInPanier(this.article);
  }
}
