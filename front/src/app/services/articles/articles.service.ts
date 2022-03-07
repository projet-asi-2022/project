import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, Subject, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class ArticlesService {
  apiUrl: string = 'http://localhost:8080/boutique/rest/articles';

  articlesSubject = new Subject<any[]>();

  private articles = [
    {
      id: null,
      libelle: null,
      marque: null,
      prix: 1500.0,
      categorie: {
        nom: null,
        id: null,
      },
      photo: {
        size: 0.0,
        url: null,
      },
    },
  ];
  constructor(private httpClient: HttpClient) {}

  emitArticlesSubject() {
    this.articlesSubject.next(this.articles.slice());
  }

  getAllArticlesFromServer() {
    this.httpClient.get<any[]>(this.apiUrl).subscribe((reponse) => {
      this.articles = reponse;
      this.emitArticlesSubject();
      console.log(reponse);
    });
  }
  deleteArticle(id: number) {
    console.log('test');
    this.httpClient.delete(this.apiUrl + '/' + id).subscribe((reponse) => {
      this.articles = this.articles.filter((x) => x.id !== id);
      this.emitArticlesSubject();
      console.log(this.articles);
    });
  }
}
