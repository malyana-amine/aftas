import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';

@Component({
  selector: 'app-competition-details',
  templateUrl: './competition-details.component.html',
  styleUrls: ['./competition-details.component.css']
})
export class CompetitionDetailsComponent {

  competition: any | undefined;
  constructor(private competitionService: CompetitionService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"));
    this.competitionService.getCompetitionById(id).subscribe(
      result => this.competition = result,
      
      err => console.error(err)
    )
    // console.log(result.data)
  }

}
