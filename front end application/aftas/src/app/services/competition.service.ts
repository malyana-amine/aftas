// competition.service.ts

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators'; // Import operators

@Injectable({
  providedIn: 'root',
})
export class CompetitionService {
  private baseUrl = 'http://localhost:8080/competition'; // Replace with your actual backend URL

  constructor(private http: HttpClient) {}

  saveCompetition(competitionData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, competitionData);
  }

  getCompetition(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getCompetitionById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`).pipe(
      tap(data => console.log(data)),
      catchError(this.handleError) // Use the catchError operator
    );
  }

  private handleError(error: any) {
    // Your error handling logic here
    console.error('An error occurred:', error);
    return throwError('Something went wrong, please try again later.');
  }

  private selectedCompetitionIdSource = new BehaviorSubject<number | null>(null);
  selectedCompetitionId$ = this.selectedCompetitionIdSource.asObservable();

  setSelectedCompetitionId(id: number | null) {
    this.selectedCompetitionIdSource.next(id);
  }


  getAllPageCompetitions(page: number, size: number): Observable<any> {
    const params = new HttpParams().set('page', page.toString()).set('size', size.toString());
    return this.http.get<any>(`${this.baseUrl}/paged`, { params });
  }
}
