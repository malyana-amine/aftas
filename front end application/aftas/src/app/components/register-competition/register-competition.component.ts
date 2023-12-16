import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';

@Component({
  selector: 'app-register-competition',
  templateUrl: './register-competition.component.html',
  styleUrls: ['./register-competition.component.css']
})
export class RegisterCompetitionComponent implements OnInit {
  date = new Date();
  // competitionId !: number;
  competitionData: any[] = [];

  constructor(
    private competitionService: CompetitionService,
    private router: Router,
    private datePipe: DatePipe
  ) {}

  ngOnInit(): void {
    this.competitionService.getCompetition().subscribe((result: any) => {
      this.competitionData = result;
    });
  }
dateplus24:any = this.date.getTime();

  compareDates(x :any):boolean{
    if(new Date(x).getTime()-this.date.getTime()>(24*3600*1000)){
      return true;
    }else{
      return false;
    }
  }
  selectCompetition(id: number) {
    this.competitionService.setSelectedCompetitionId(id);
  }
}
