import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from '../../environments/environment'
import { AuthData } from './auth-data.model';

@Injectable({providedIn: "root"})
export class AuthService{
    constructor(private http: HttpClient){}
    CreateUser(email: string, password: string, prenom: string, nom: string, date_naissance: string){
        const authData: AuthData = {
            email: email,
            password: password,
            prenom: prenom,
            nom: nom,
            date_naissance: date_naissance
        }  
        this.http.post(environment.api.concat("user/signup"), authData)
            .subscribe(response =>{
                console.log(response);
            });
    }
}
