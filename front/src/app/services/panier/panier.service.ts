import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PanierService {
  apiUrl: string = 'http://localhost:8080/boutique/rest/paniers';

  panierSubject = new Subject<any>();

  private panier: any;
  constructor(private httpClient: HttpClient) {}

  emitArticlesSubject() {
    this.panierSubject.next(this.panier.slice());
  }
}
