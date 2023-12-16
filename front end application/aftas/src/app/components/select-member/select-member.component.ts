import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MemberService } from 'src/app/services/member.service';

@Component({
  selector: 'app-select-member',
  templateUrl: './select-member.component.html',
  styleUrls: ['./select-member.component.css']
})
export class SelectMemberComponent implements OnInit{
  memberData: any[] = [] ;
selectedMemberId: any;
  constructor(private memberService : MemberService,private router: Router){}
  ngOnInit(): void {
    this.memberService.getMembers().subscribe((result: any)=>{
      console.log(result);
      this.memberData = result; 
    }
    )
  }

}
