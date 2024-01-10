import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HuntingService {

  
  private baseUrl = 'http://localhost:8080/Hunting'; // Replace with your actual backend URL

  constructor(private http: HttpClient) {}

  saveHunting(registerData: any): Observable<any> {
    console.log(registerData);
    return this.http.post(`${this.baseUrl}/add`, registerData);
  }
}
