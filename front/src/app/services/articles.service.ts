import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Observable, Subject, throwError } from 'rxjs';
import { Article } from '../models/articles.model';
import { Categorie } from '../models/categories.model';
import { environment } from 'src/environments/environment';

@Injectable()
export class ArticlesService {
  apiUrl: string = environment.api+'articles';
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  articlesSubject = new Subject<any[]>();

  private articles = [{}];
  constructor(private httpClient: HttpClient) {}

  emitArticlesSubject() {
    this.articlesSubject.next(this.articles.slice());
  }

  getAllArticlesFromServer() {
    this.httpClient.get<any[]>(this.apiUrl).subscribe((reponse) => {
      this.articles = reponse;
    });
  }
}
