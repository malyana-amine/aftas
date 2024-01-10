import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FishService {
  private baseUrl = 'http://localhost:8080/fish/getall'; // Replace with your actual backend URL

  constructor(private http: HttpClient) {}

  getMembers(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
