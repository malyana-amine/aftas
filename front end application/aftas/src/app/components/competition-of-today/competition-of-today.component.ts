import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Competition } from 'src/app/models/Competition';
import { Hunting } from 'src/app/models/Hunting';
import { CompetitionService } from 'src/app/services/competition.service';
import { FishService } from 'src/app/services/fish.service';
import { HuntingService } from 'src/app/services/hunting.service';

@Component({
  selector: 'app-competition-of-today',
  templateUrl: './competition-of-today.component.html',
  styleUrls: ['./competition-of-today.component.css']
})
export class CompetitionOfTodayComponent implements OnInit {
  // date = new Date();
  competitionData: any[] = [] ;
  hunting : Hunting = new Hunting();
  fishData: any[] = [] ;
  message!: String;
  status!: any;
  competition!: any;
  
  
  constructor(private competitionService : CompetitionService,
    private router: Router,
    private huntingService: HuntingService,
    private fishService : FishService){}
  
  ngOnInit(): void {
    this.competitionService.getCompetition().subscribe((result: any)=>{
      this.competitionData = result;
    }
    )
  }

 

  getAllFishes(): any {
    this.fishService.getMembers().subscribe((result) => {
      this.fishData = result;
      // Additional logic with fishData, if needed
      console.log('Fish data:', this.fishData);
    });
  }

  getCompetition(id: number): any {
    this.competitionService.getCompetitionById(id).subscribe((result) => {
      this.competition = result;
      console.log(result.id);
      this.hunting.compId = result.id
      // Call getAllFishes after getting competition
      this.getAllFishes();
      // Additional logic with competition data, if needed
      console.log('Competition data:', this.competition);
    });
  }

  compareDates(x: any): number {
    const currentDate = new Date();
    const targetDate = new Date(x);
 
    if (targetDate.toDateString() === currentDate.toDateString()) {
      
      return 0;
    } else if (targetDate.getTime() - currentDate.getTime() > 0) {
      // Target date is in the future
      return 1;
    } else {
      // Target date is in the past
      return 2;
    }
  }
  
  register(form: NgForm) {
    if (form.valid) {
      this.huntingService.saveHunting(this.hunting).subscribe(
        response => {
          console.log(response);
          console.log('ranking registered successfully', response);
          
          form.resetForm();
          this.message = response.message;
          this.status = response.status;
        }
      );
    }
  }

}
