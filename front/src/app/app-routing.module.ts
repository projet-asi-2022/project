import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './auth/connexion/connexion.component';
import { CreateComponent } from './components/create/create.component';
import { DetailsComponent } from './components/details/details.component';
import { ListComponent } from './components/list/list.component';
import { HomeComponent } from './home/home.component';
import { PhonesModule } from './modules/phones/phones.module';

const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'connexion', component: ConnexionComponent },
    { path: 'articles', component: ListComponent },
    { path: 'articles/:id', component: DetailsComponent },
    { path: 'articles/add', component: CreateComponent },
    // Eager loading :
    { path: 'articles', children: [
        { path: 'phones', component: PhonesModule }
    ] },
    // Lazy loading :
    { path: 'stockage', loadChildren: () => import('./modules/stockage/stockage.module')
        .then(m => m.StockageModule)
    },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
