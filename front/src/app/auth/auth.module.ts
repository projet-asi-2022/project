import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConnexionComponent } from './connexion/connexion.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    ConnexionComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule,
    FormsModule, //import here
    ReactiveFormsModule, //import here
  ],
})
export class AuthModule {}
