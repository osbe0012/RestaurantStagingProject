import { TestBed } from '@angular/core/testing';

import { HttpUtilityService } from './http.utility.service';

describe('Http.UtilityService', () => {
  let service: HttpUtilityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpUtilityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
