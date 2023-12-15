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

  // redirectToSomeRoute() {
  //   this.router.navigate(['/kkk']);
  // }

  register(form: NgForm) {
    if (form.valid) {

      this.competition.startTime = this.formatTime(this.competition.startTime)+`:00`;
      this.competition.endTime = this.formatTime(this.competition.endTime)+`:00`;
      // console.log(this.competition.endTime)

      this.competitionService.saveCompetition(this.competition).subscribe(
        response => {
          console.log('Competition registered successfully', response);
          form.resetForm();
          // this.redirectToSomeRoute();
        },
        error => {
          console.error('Error registering competition', error);
          // Log the detailed error message from the server
          if (error instanceof HttpErrorResponse) {
            console.error('Server error:', error.error);
          }
        }
      );
      
    }
  }
}
