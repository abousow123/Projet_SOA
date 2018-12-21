import { TestBed, inject } from '@angular/core/testing';

import { EcServiceService } from './ec-service.service';

describe('EcServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EcServiceService]
    });
  });

  it('should be created', inject([EcServiceService], (service: EcServiceService) => {
    expect(service).toBeTruthy();
  }));
});
