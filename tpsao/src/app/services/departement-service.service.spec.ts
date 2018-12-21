import { TestBed, inject } from '@angular/core/testing';

import { DepartementServiceService } from './departement-service.service';

describe('DepartementServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DepartementServiceService]
    });
  });

  it('should be created', inject([DepartementServiceService], (service: DepartementServiceService) => {
    expect(service).toBeTruthy();
  }));
});
