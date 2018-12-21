import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewfaculteComponent } from './newfaculte.component';

describe('NewfaculteComponent', () => {
  let component: NewfaculteComponent;
  let fixture: ComponentFixture<NewfaculteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewfaculteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewfaculteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
