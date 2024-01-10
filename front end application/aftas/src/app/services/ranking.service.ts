import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RankingService {

 
  private baseUrl = 'http://localhost:8080/register'; // Replace with your actual backend URL

  constructor(private http: HttpClient) {}

  saveRanking(registerData: any): Observable<any> {
    console.log(registerData);
    return this.http.post(`${this.baseUrl}/add`, registerData);
  }
}
