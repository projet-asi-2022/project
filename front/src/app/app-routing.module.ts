import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './Pages/home/home.component';
import { ArticleComponent } from './Pages/articles/article/article.component';

import { UserDetailsComponent } from './components/user-articles/details/details.component';
import { UserListComponent } from './components/user-articles/list/list.component';

import { ConnexionComponent } from './auth/connexion/connexion.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './auth.guard';
import { PanierComponent } from './Pages/panier/panier.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard] },
  { path: 'panier', component: PanierComponent },

  {
    path: 'articles',
    component: ArticleComponent,
    children: [
      {
        path: 'PcBureau',
        component: UserListComponent,
      },
      {
        path: 'Accessoires',
        component: UserListComponent,
      },
      {
        path: ':id',
        component: UserDetailsComponent,
      },
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
