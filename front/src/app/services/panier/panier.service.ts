import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PanierService {
  apiUrl: string = 'http://localhost:8080/boutique/rest/paniers';
  apiUrl2: string = 'http://localhost:8080/boutique/rest/articles';
  panierSubject = new Subject<any>();

  private panier: any;
  constructor(private httpClient: HttpClient) {}

  emitPanierSubject() {
    this.panierSubject.next(this.panier.slice());
  }

  getPanierForUser(id: number) {
    this.httpClient
      .get<any[]>(this.apiUrl2 + '/' + id + '/' + '/panier')
      .subscribe((reponse) => {
        this.panier = reponse;
        this.emitPanierSubject();
        console.log(reponse);
      });
  }

  addInPanier(article: any) {
    this.panier.articles.add(article);
    this.emitPanierSubject();
    this.httpClient
      .post(this.apiUrl + '/', this.panier)
      .subscribe((reponse) => {
        this.panier = reponse;
        this.emitPanierSubject();
        console.log(reponse);
      });
  }
}
