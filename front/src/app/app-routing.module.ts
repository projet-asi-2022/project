import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './Pages/home/home.component';
import { ArticleComponent } from './Pages/articles/article/article.component';

import { UserDetailsComponent } from './components/user-articles/details/details.component';
import { UserListComponent } from './components/user-articles/list/list.component';

import { ConnexionComponent } from './auth/connexion/connexion.component';
import { RegisterComponent } from './auth/register/register.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './auth.guard';
import { PanierComponent } from './Pages/panier/panier.component';
import { UpdateArticleComponent } from './Pages/update-article/update-article.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'inscription', component: RegisterComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard] },
  { path: 'panier', component: PanierComponent },
  { path: 'articles/:id/update', component: UpdateArticleComponent },
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
        path: 'PcPortable',
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
