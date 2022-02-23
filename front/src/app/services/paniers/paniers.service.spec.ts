import { TestBed } from '@angular/core/testing';

import { PaniersService } from './paniers.service';

describe('PaniersService', () => {
  let service: PaniersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PaniersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
