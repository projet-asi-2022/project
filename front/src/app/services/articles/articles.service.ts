import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {

  headers = new HttpHeaders().set('Content-Type', 'application/json');


  constructor(private httpClient: HttpClient) { }

  // Show lists of item
  list(): Observable<any> {
    return this.httpClient.get(environment.api).pipe(
      catchError(this.handleError)
    );
  }

  // Create new item
  getItem(id: any): Observable<any> {
    return this.httpClient.get(`${environment.api}/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  create(data: any): Observable<any> {
    return this.httpClient.post(environment.api, data).pipe(
      catchError(this.handleError)
    );
  }

  // Edit/ Update 
  update(id: any, data: any): Observable<any> {
    return this.httpClient.put(`${environment.api}/${id}`, data).pipe(
      catchError(this.handleError)
    );
  }

  // Delete
  delete(id: any): Observable<any> {
    return this.httpClient.delete(`${environment.api}/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  // Search By Name
  filterByTitle(title: any): Observable<any> {
    return this.httpClient.get(`${environment.api}?title_like=${title}`).pipe(
      catchError(this.handleError)
    );
  }

  // Handle API errors
  handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  };
}
