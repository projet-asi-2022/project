import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './Pages/home/home.component';

import { PhonesModule } from './modules/phones/phones.module';
import { StockageModule } from './modules/stockage/stockage.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';
import { CreateComponent } from './components/admin-articles/create/create.component';
import { ArticlesModule } from './Pages/articles/articles.module';
import { ListComponent } from './components/admin-articles/list/list.component';
import { DetailsComponent } from './components/admin-articles/details/details.component';
import { UserDetailsComponent } from './components/user-articles/details/details.component';
import { UserListComponent } from './components/user-articles/list/list.component';

import { AdminComponent } from './admin/admin.component';
import { AuthComponent } from './auth/auth.component';
import { ConnexionComponent } from './auth/connexion/connexion.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    CreateComponent,
    DetailsComponent,
    ListComponent,
    AdminComponent,
    AuthComponent,
    UserDetailsComponent,
    UserListComponent, 
    ConnexionComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    PhonesModule,
    StockageModule,
    ArticlesModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
