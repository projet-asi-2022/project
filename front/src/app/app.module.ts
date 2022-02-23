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

import { CreateComponent } from './components/create/create.component';
import { DetailsComponent } from './components/details/details.component';
import { ListComponent } from './components/list/list.component';
import { ArticlesModule } from './Pages/articles/articles.module';
import { CommonModule } from '@angular/common';

import { AdminComponent } from './admin/admin.component';
import { AuthComponent } from './auth/auth.component';
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
