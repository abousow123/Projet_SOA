import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditfaculteComponent } from './editfaculte.component';

describe('EditfaculteComponent', () => {
  let component: EditfaculteComponent;
  let fixture: ComponentFixture<EditfaculteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditfaculteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditfaculteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
