import { TestBed, inject } from '@angular/core/testing';

import { PromotionServiceService } from './promotion-service.service';

describe('PromotionServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PromotionServiceService]
    });
  });

  it('should be created', inject([PromotionServiceService], (service: PromotionServiceService) => {
    expect(service).toBeTruthy();
  }));
});
