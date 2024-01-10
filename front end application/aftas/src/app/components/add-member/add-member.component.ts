import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Member } from 'src/app/models/Member';
import { CompetitionService } from 'src/app/services/competition.service';
import { MemberService } from 'src/app/services/member.service';
import { RankingService } from 'src/app/services/ranking.service';

@Component({
  selector: 'app-add-member',
  templateUrl: './add-member.component.html',
  styleUrls: ['./add-member.component.css']
})
export class AddMemberComponent {

  
  selectedCompetitionId: number | null = null;
  memberData: any[] = [];
  selectedMemberId: any;
  message!: String;
  status!: any;
  userForm!: NgForm;
  member : Member = new Member();

  constructor(
    private memberService: MemberService,
  ) {}


  register(form: NgForm) {
    // this.ranking.competitionId = "1"
    if (form.valid) {
      this.memberService.saveMember(this.member).subscribe(
        response => {
          console.log(response);
          console.log('member registered successfully', response);
          form.resetForm();
          this.message = response.message;
          this.status = response.status;
        }
      );
    }
  }
}
