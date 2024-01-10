import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';


@Component({
  selector: 'app-competition',
  templateUrl: './competition.component.html',
  styleUrls: ['./competition.component.css']
})
export class CompetitionComponent implements OnInit{
  competitionData: any[] = [] ;
  pageSizeOptions: number[] = [3, 5, 25, 100];
  totalItems = 0;
  currentPage = 0;
  pageSize = 3;
  constructor(private competitionService : CompetitionService,private router: Router){}
  ngOnInit(): void {
    this.loadCompetitions();
  }

  loadCompetitions(): void {
    this.competitionService.getAllPageCompetitions(this.currentPage, this.pageSize).subscribe(
      (response: any) => {
        console.log('Competitions:', response);

        this.competitionData = response.content;
        console.log(response.content);
        this.totalItems = response.totalElements;
      },
      (error) => {
        console.error('Error fetching competitions:', error);
      }
    );
  }

  onPageChange(event: PageEvent): void {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.loadCompetitions();
  }

}
