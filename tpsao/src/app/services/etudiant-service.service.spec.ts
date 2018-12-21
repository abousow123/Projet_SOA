import { TestBed, inject } from '@angular/core/testing';

import { EtudiantServiceService } from './etudiant-service.service';

describe('EtudiantServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EtudiantServiceService]
    });
  });

  it('should be created', inject([EtudiantServiceService], (service: EtudiantServiceService) => {
    expect(service).toBeTruthy();
  }));
});
