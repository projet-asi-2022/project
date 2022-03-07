import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, Subject, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root',
})
export class ArticlesService {
  apiUrl: string = environment.api+'articles';

  articlesSubject = new Subject<any[]>();

  private articles = [{}];
  constructor(private httpClient: HttpClient) {}

  emitArticlesSubject() {
    this.articlesSubject.next(this.articles.slice());
  }

  async getAllArticlesFromServer() {
    this.httpClient.get<any[]>(this.apiUrl).subscribe((reponse) => {
      this.articles = reponse;
      this.emitArticlesSubject();
      console.log(reponse);
    });
  }
}
