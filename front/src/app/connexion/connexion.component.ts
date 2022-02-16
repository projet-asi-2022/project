import { Component, OnInit } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from  '@angular/forms';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {
  messageError: string = ''
  loginForm: FormGroup;

  constructor(private authService: AuthService, private route: Router, private formBuilder: FormBuilder) {
    this.loginForm = new FormGroup({});
  }

  

  ngOnInit(): void {
    this.loginForm  =  this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
  });
  }



  connexion(connexionForm: any) {
    let data = connexionForm.value;
    console.log(data);
    if(this.loginForm.invalid){
      return;
    }
    //this.authService.login(this.loginForm.value);
    //this.router.navigateByUrl('/admin');
  }

  get formControls() { return this.loginForm.controls; }

}
