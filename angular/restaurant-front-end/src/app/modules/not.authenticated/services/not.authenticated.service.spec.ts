import { TestBed } from '@angular/core/testing';

import { Not.AuthenticatedService } from './not.authenticated.service';

describe('Not.AuthenticatedService', () => {
  let service: Not.AuthenticatedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Not.AuthenticatedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
