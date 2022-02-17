import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './auth/connexion/connexion.component';
import { CreateComponent } from './components/create/create.component';
import { DetailsComponent } from './components/details/details.component';
import { ListComponent } from './components/list/list.component';
import { HomeComponent } from './Pages/home/home.component';
import { PhonesModule } from './modules/phones/phones.module';
import { ArticleComponent } from './Pages/articles/article/article.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'connexion', component: ConnexionComponent },
  {
    path: 'articles',
    component: ArticleComponent,
    children: [
      { path: 'list', component: ListComponent },
      { path: 'id', component: DetailsComponent },
      { path: 'add', component: CreateComponent },
    ],
  },
  // Eager loading :
  // Lazy loading :
  {
    path: 'stockage',
    loadChildren: () =>
      import('./modules/stockage/stockage.module').then(
        (m) => m.StockageModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
