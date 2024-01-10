import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetitionOfTodayComponent } from './competition-of-today.component';

describe('CompetitionOfTodayComponent', () => {
  let component: CompetitionOfTodayComponent;
  let fixture: ComponentFixture<CompetitionOfTodayComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CompetitionOfTodayComponent]
    });
    fixture = TestBed.createComponent(CompetitionOfTodayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
