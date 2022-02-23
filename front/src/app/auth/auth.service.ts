import { Injectable } from '@angular/core';
import { User } from './auth-data.model';

@Injectable({
  providedIn: 'root'
})

export class AuthService {
    constructor() { }
    public signIn(userData: User){
        localStorage.setItem('ACCESS_TOKEN', "access_token");
    }
    public isLoggedIn(){
        return localStorage.getItem('ACCESS_TOKEN') !== null;
    }
    public logout(){
        localStorage.removeItem('ACCESS_TOKEN');
    }
}