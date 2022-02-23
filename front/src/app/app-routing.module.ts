import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './components/admin-articles/create/create.component';
import { HomeComponent } from './Pages/home/home.component';
import { ArticleComponent } from './Pages/articles/article/article.component';
import { ListComponent } from './components/admin-articles/list/list.component';
import { DetailsComponent } from './components/admin-articles/details/details.component';
import { UserDetailsComponent } from './components/user-articles/details/details.component';
import { UserListComponent } from './components/user-articles/list/list.component';
import { AdminArticleComponent } from './Pages/admin-articles/article/article.component';


import { ConnexionComponent } from './auth/connexion/connexion.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard] },
  {
    path: 'admin/articles',
    component: ArticleComponent,
    children: [
      { path: 'list', component: ListComponent },
      { path: 'id', component: DetailsComponent },
      { path: 'add', component: CreateComponent },
    ],
  },
  {
    path: 'articles',
    component: AdminArticleComponent,
    children: [
      { path: 'list', component: UserListComponent },
      { path: 'id', component: UserDetailsComponent },
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
