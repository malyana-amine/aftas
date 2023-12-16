import { DatePipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Competition } from 'src/app/models/Competition';
import { CompetitionService } from 'src/app/services/competition.service';

@Component({
  selector: 'app-add-competition',
  templateUrl: './add-competition.component.html',
  styleUrls: ['./add-competition.component.css'],
  providers: [DatePipe] 
})
export class AddCompetitionComponent {
  isFormVisible = false;
  competition: Competition = new Competition();
  userForm!: NgForm;
  message!: String;
  status!: any;
  
  constructor(
    private competitionService: CompetitionService,
    private datePipe: DatePipe,
    private router: Router
  ) {}

  toggleForm() {
    this.isFormVisible = !this.isFormVisible;
  }

  formatTime(time: string): string {
    const [hours, minutes] = time.split(':');
    return `${hours}:${minutes}`;
  }
  public isvisible: boolean = false;

  showalert() : void {

    if (this.isvisible && this.status == 200) { 
      this.isFormVisible = false;
      return;
    } 
    this.isvisible = true;
    setTimeout(()=> this.isvisible = false,2500); // hide the alert after 2.5s
  }

  register(form: NgForm) {
    if (form.valid) {
      this.competition.startTime = this.formatTime(this.competition.startTime)+`:00`;
      this.competition.endTime = this.formatTime(this.competition.endTime)+`:00`;
      // console.log(this.competition.endTime)

      this.competitionService.saveCompetition(this.competition).subscribe(
        response => {
          console.log('Competition registered successfully', response);
          form.resetForm();
          this.message = response.message;
          this.status = response.status;
          console.log(response.message+'erzrezrzerezze');
        }
      );

      
    }
  }
}
