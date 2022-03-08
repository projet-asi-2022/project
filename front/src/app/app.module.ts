import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './Pages/home/home.component';

import { PhonesModule } from './modules/phones/phones.module';
import { StockageModule } from './modules/stockage/stockage.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';

import { ArticlesModule } from './Pages/articles/articles.module';

import { UserDetailsComponent } from './components/user-articles/details/details.component';
import { UserListComponent } from './components/user-articles/list/list.component';

import { AdminComponent } from './admin/admin.component';
import { AuthComponent } from './auth/auth.component';
import { AuthModule } from './auth/auth.module';
import { HttpClientModule } from '@angular/common/http';
import { PanierComponent } from './Pages/panier/panier.component';
import { MatIconModule } from '@angular/material/icon';
import { UpdateArticleComponent } from './Pages/update-article/update-article.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,

    AdminComponent,
    AuthComponent,
    UserDetailsComponent,
    UserListComponent,
    PanierComponent,
    UpdateArticleComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatIconModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    PhonesModule,
    StockageModule,
    ArticlesModule, //module article(sous module)
    AuthModule, //module auth (sous module)
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
