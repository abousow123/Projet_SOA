import { TestBed, inject } from '@angular/core/testing';

import { ClasseServiceService } from './classe-service.service';

describe('ClasseServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClasseServiceService]
    });
  });

  it('should be created', inject([ClasseServiceService], (service: ClasseServiceService) => {
    expect(service).toBeTruthy();
  }));
});
