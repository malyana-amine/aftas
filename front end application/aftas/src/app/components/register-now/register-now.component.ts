import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';
import { MemberService } from 'src/app/services/member.service'; // Import MemberService if not already imported

@Component({
  selector: 'app-register-now',
  templateUrl: './register-now.component.html',
  styleUrls: ['./register-now.component.css']
})
export class RegisterNowComponent implements OnInit {

  selectedCompetitionId: number | null = null;
  memberData: any[] = [];
  selectedMemberId: any;

  constructor(
    private competitionService: CompetitionService,
    private memberService: MemberService,
    private router: Router
  ) {}

  ngOnInit() {
    // Subscribe to changes in the selected competition ID
    this.competitionService.selectedCompetitionId$.subscribe(id => {
      this.selectedCompetitionId = id;
    });

    // Fetch members data
    this.memberService.getMembers().subscribe((result: any) => {
      console.log(result);
      this.memberData = result;
    });
  }
}
