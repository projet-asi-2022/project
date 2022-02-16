import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './auth/connexion/connexion.component';
import { HomeComponent } from './home/home.component';
import { PhonesModule } from './modules/phones/phones.module';
import { PcAccessoiresComponent } from './pc-accessoires/pc-accessoires.component';
import { PcBureauComponent } from './pc-bureau/pc-bureau.component';
import { PcPortableComponent } from './pc-portable/pc-portable.component';

const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'pc_portable', component: PcPortableComponent },
    { path: 'pc_bureau', component: PcBureauComponent },
    { path: 'pc_accessoires', component: PcAccessoiresComponent },
    { path: 'connexion', component: ConnexionComponent },

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
