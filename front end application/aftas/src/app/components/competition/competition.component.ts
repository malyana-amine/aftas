import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';

@Component({
  selector: 'app-competition',
  templateUrl: './competition.component.html',
  styleUrls: ['./competition.component.css']
})
export class CompetitionComponent implements OnInit{
  competitionData: any[] = [] ;
  constructor(private competitionService : CompetitionService,private router: Router){}
  ngOnInit(): void {
    this.competitionService.getCompetition().subscribe((result: any)=>{
      console.log(result);
      this.competitionData = result;
      // console.log(result.data);
    }
    )
  }


}
