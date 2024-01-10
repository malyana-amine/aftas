import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Competition } from 'src/app/models/Competition';
import { Ranking } from 'src/app/models/Ranking';
import { CompetitionService } from 'src/app/services/competition.service';
import { MemberService } from 'src/app/services/member.service'; // Import MemberService if not already imported
import { RankingService } from 'src/app/services/ranking.service';

@Component({
  selector: 'app-register-now',
  templateUrl: './register-now.component.html',
  styleUrls: ['./register-now.component.css']
})
export class RegisterNowComponent implements OnInit {

  selectedCompetitionId: number | null = null;
  memberData: any[] = [];
  selectedMemberId: any;
  message!: String;
  status!: any;
  ranking : Ranking = new Ranking();
  userForm!: NgForm;

  constructor(
    private competitionService: CompetitionService,
    private memberService: MemberService,
    private rankingService :RankingService,
    private router: Router
  ) {}

  ngOnInit() {
    this.competitionService.selectedCompetitionId$.subscribe(id => {
      this.selectedCompetitionId = id;
      this.ranking.competitionId = this.selectedCompetitionId;
    });

    this.memberService.getMembers().subscribe((result: any) => {
      console.log(result);
      this.memberData = result;
    });
  }
  public isvisible: boolean = false;
  showalert() : void {
    if (this.isvisible && this.status == 200) { 
      return;
    } 
    this.isvisible = true;
    setTimeout(()=> this.isvisible = false,2500); // hide the alert after 2.5s
  }

  register(form: NgForm) {
    // this.ranking.competitionId = "1"
    if (form.valid) {
      this.rankingService.saveRanking(this.ranking).subscribe(
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
