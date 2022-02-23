import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticlesService } from 'src/app/services/articles/articles.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class UserDetailsComponent implements OnInit {

currentArticle: any;
  message = '';

  constructor(
    private articlesService: ArticlesService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getArticle(this.route.snapshot.paramMap.get('id'));
  }

  getArticle(id: string | null): void {
    this.articlesService.getItem(id)
      .subscribe(
        (Article: null) => {
          this.currentArticle = Article;
          console.log(Article);
        },
        (error: any) => {
          console.log(error);
        });
  }

  setAvailableStatus(status: any): void {
    const data = {
      name: this.currentArticle.name,
      description: this.currentArticle.description,
      available: status
    };

    this.articlesService.update(this.currentArticle.id, data)
      .subscribe(
        response => {
          this.currentArticle.available = status;
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

  add2Panier(): void {
    
  }
}
