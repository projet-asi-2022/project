import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class UserListComponent implements OnInit {
  articles: any;
  currentArticle: any;
  currentIndex = -1;
  searchTitle = '';

  constructor(private articlesService: ArticlesService) {}

  ngOnInit(): void {
    this.getAllarticles();
  }

  // Get list
  getAllarticles(): void {
    this.articlesService.list().subscribe(
      (articles: any) => {
        this.articles = articles;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  // Search items
  searchByTitle(): void {
    this.articlesService.filterByTitle(this.searchTitle).subscribe(
      (articles) => {
        this.articles = articles;
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
