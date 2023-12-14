import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { CompetitionComponent } from './components/competition/competition.component';

const routes: Routes = [
  {path:'', component:SidebarComponent,
  children:[
    {path:"competition" , component:CompetitionComponent}
  ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
