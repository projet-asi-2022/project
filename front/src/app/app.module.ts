import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { ConnexionComponent } from './auth/connexion/connexion.component';
import { PhonesModule } from './modules/phones/phones.module';
import { StockageModule } from './modules/stockage/stockage.module';
import { FormsModule } from '@angular/forms';
import { CreateComponent } from './components/create/create.component';
import { DetailsComponent } from './components/details/details.component';
import { ListComponent } from './components/list/list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ConnexionComponent,
    CreateComponent,
    DetailsComponent,
    ListComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    PhonesModule,
    FormsModule,
    StockageModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
