import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  private baseUrl = 'http://localhost:8080/member'; // Replace with your actual backend URL

  constructor(private http: HttpClient) {}

  getMembers(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  saveMember(registerData: any): Observable<any> {
    console.log(registerData);
    return this.http.post(`${this.baseUrl}/add`, registerData);
  }

}
