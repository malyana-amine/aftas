import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MemberService } from 'src/app/services/member.service';

@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.css']
})
export class MemberListComponent {
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
