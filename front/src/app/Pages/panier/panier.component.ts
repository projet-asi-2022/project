import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { PanierService } from 'src/app/services/panier/panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css'],
})
export class PanierComponent implements OnInit {
  panierSub: Subscription;
  articles: any[];
  id: number;
  constructor(
    private route: ActivatedRoute,
    private panierservice: PanierService
  ) {}

  ngOnInit(): void {
    this.panierSub = this.panierservice.panierSubject.subscribe((reponse) => {
      this.articles = reponse.articles;
    });
    this.panierservice.getPanierForUser(
      parseInt(this.route.snapshot.params['id'])
    );
  }
}
