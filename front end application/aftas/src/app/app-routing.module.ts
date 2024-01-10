import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { CompetitionComponent } from './components/competition/competition.component';
import { CompetitionDetailsComponent } from './components/competition-details/competition-details.component';
import { RegisterCompetitionComponent } from './components/register-competition/register-competition.component';
import { CompetitionOfTodayComponent } from './components/competition-of-today/competition-of-today.component';
import { MemberListComponent } from './components/member-list/member-list.component';

const routes: Routes = [
  {path:'', component:SidebarComponent,
  children:[
    {path:"competition" , component:CompetitionComponent},
    {path:"competition/:id",component:CompetitionDetailsComponent},
    {path:"register",component:RegisterCompetitionComponent},
    {path:"dashboard",component:CompetitionOfTodayComponent},
    {path:"member",component:MemberListComponent}
  ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
