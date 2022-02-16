import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  article = {
    title: '',
    description: ''
  };
  isArticleAdded = false;

  constructor(private articlesService: ArticlesService) { }

  ngOnInit(): void { }

  // Add New
  addArticle(): void {
    const data = {
      title: this.article.title,
      description: this.article.description
    };
    if (!data.title) {
      alert('Please add title!');
      return;
    }

    this.articlesService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.isArticleAdded = true;
        },
        error => {
          console.log(error);
        });
  }

  // Reset on adding new
  newArticle(): void {
    this.isArticleAdded = false;
    this.article = {
      title: '',
      description: ''
    };
  }

}
