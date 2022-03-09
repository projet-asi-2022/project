import { Injectable } from '@angular/core';
import { User } from './auth-data.model';
import { environment } from 'src/environments/environment';
import {
    HttpClient,
    HttpErrorResponse,
    HttpHeaders,
  } from '@angular/common/http';
import { Subject } from 'rxjs';

const optionRequete = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
    }),
};

@Injectable({
  providedIn: 'root'
})

export class AuthService {
    apiUrl: string = environment.api + 'utilisateurs';
    user:any={
    "prenom": "Paul", 
    "nom": "Paul", 
    "email": "Paul", 
    "password": "Paul", 
    "dateNaissance": "Paul", 
    "role": "user"
};
    userSub = new Subject<any>();

    constructor(private httpClient: HttpClient) { }
    public signIn(userData: User){
        this.httpClient.get<any[]>(this.apiUrl).subscribe((reponse) => {
           // this.user = userData;
        });
        localStorage.setItem('ACCESS_TOKEN', "access_token");
    }

      emituser() {
    this.userSub.next(this.user);
  }
    public register(userData: User){
        this.httpClient.post<any>(this.apiUrl, {
            prenom: userData.prenom,
            nom: userData.nom,
            email: userData.email,
            password: userData.password,
            dateNaissance: userData.dateNaissance,
            role: "user"
        }).subscribe(data => {
            this.user = userData;
        })
        localStorage.setItem('ACCESS_TOKEN', "access_token");
    }
    public isLoggedIn(){
        // On pourrait ajouter un argument avec l'utilisateur connecté
        // et le confronter avec l'utilisateur de la base de données aux données de l'utilisateur connecté en back
        return localStorage.getItem('ACCESS_TOKEN') !== null;
    }
    public logout(){
        localStorage.removeItem('ACCESS_TOKEN');
    }
}