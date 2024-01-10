import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { CompetitionComponent } from './components/competition/competition.component';
import { AddCompetitionComponent } from './components/add-competition/add-competition.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CompetitionDetailsComponent } from './components/competition-details/competition-details.component';
import { FishListComponent } from './components/fish-list/fish-list.component';
import { RegisterCompetitionComponent } from './components/register-competition/register-competition.component';
import { CommonModule, DatePipe } from '@angular/common';
import { RegisterNowComponent } from './components/register-now/register-now.component';
import { SelectMemberComponent } from './components/select-member/select-member.component';
import { CompetitionOfTodayComponent } from './components/competition-of-today/competition-of-today.component';
import { MemberListComponent } from './components/member-list/member-list.component';
import { AddMemberComponent } from './components/add-member/add-member.component';
import { MatPaginatorModule } from '@angular/material/paginator';


@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    CompetitionComponent,
    AddCompetitionComponent,
    CompetitionDetailsComponent,
    FishListComponent,
    RegisterCompetitionComponent,
    RegisterNowComponent,
    SelectMemberComponent,
    CompetitionOfTodayComponent,
    MemberListComponent,
    AddMemberComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    MatPaginatorModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
