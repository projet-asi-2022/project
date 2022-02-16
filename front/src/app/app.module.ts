import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { PcPortableComponent } from './pc-portable/pc-portable.component';
import { PcBureauComponent } from './pc-bureau/pc-bureau.component';
import { PcAccessoiresComponent } from './pc-accessoires/pc-accessoires.component';
import { ConnexionComponent } from './auth/connexion/connexion.component';
import { PhonesModule } from './modules/phones/phones.module';
import { StockageModule } from './modules/stockage/stockage.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    PcPortableComponent,
    PcBureauComponent,
    PcAccessoiresComponent,
    ConnexionComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    PhonesModule,
    StockageModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
