import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from '../../environments/environment'

@Injectable({providedIn: "root"})
export class AuthService{
    constructor(private http: HttpClient){}
    CreateUser(email: string, password: string){
        this.http.post(environment. "user/signup");
    }
}
