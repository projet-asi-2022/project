import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ArticlesService } from 'src/app/services/articles/articles.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-update-article',
  templateUrl: './update-article.component.html',
  styleUrls: ['./update-article.component.css'],
})
export class UpdateArticleComponent implements OnInit {
  updateform: FormGroup;
  apiUrl: string = environment.api + 'articles';
  article: any;
  constructor(
    private formBuilder: FormBuilder,
    private httpClient: HttpClient,
    private articleService: ArticlesService,
    private route: ActivatedRoute
  ) {
    this.updateform = new FormGroup({});
  }

  ngOnInit(): void {
    this.httpClient
      .get<any[]>(this.apiUrl + '/' + this.route.snapshot.paramMap.get('id'))
      .subscribe((reponse) => {
        this.article = reponse;
        console.log(reponse);
      });

    this.updateform = this.formBuilder.group({
      id: [this.article.id],
      libelle: [this.article.libelle],
      prix: [this.article.prix],
      categorie: this.formBuilder.group({
        nom: [this.article.categorie.nom],
        id: [this.article.categorie.id],
      }),
      photo: this.formBuilder.group({
        size: [this.article.photo.size],
        url: [this.article.photo.url],
      }),
    });
  }
  get formControls() {
    return this.updateform.controls;
  }

  updateArticle() {
    this.httpClient
      .post(this.apiUrl + '/', this.updateform.value)
      .subscribe((reponse) => {
        console.log(reponse);
      });
  }
}
