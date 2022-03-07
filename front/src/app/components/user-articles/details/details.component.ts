import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticlesService } from 'src/app/services/articles/articles.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class UserDetailsComponent implements OnInit {
  currentArticle: any;
  message = '';
  apiUrl: string = 'http://localhost:8080/boutique/rest/articles';
  article: any;
  constructor(
    private httpClient: HttpClient,
    private route: ActivatedRoute,
    private articleService: ArticlesService
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
    console.log('test');
    this.articleService.deleteArticle(id);
  }
}
