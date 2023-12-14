// competition.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CompetitionService {
  private baseUrl = 'http://localhost:8080/competition'; // Replace with your actual backend URL

  constructor(private http: HttpClient) {}

  saveCompetition(competitionData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, competitionData);
  }
}
