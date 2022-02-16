import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({providedIn: "root"})
export class AuthService{
    constructor(private http: HttpClient){}
    CreateUser(email: string, password: string){
        this.http.post("http://localhost:3000/api/user/signup");
    }
}
