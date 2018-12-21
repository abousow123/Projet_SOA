import { TestBed, inject } from '@angular/core/testing';

import { FaculteServiceService } from './faculte-service.service';

describe('FaculteServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FaculteServiceService]
    });
  });

  it('should be created', inject([FaculteServiceService], (service: FaculteServiceService) => {
    expect(service).toBeTruthy();
  }));
});
