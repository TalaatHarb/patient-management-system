import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { PatientMangamentService } from './patient-mangament.service';

describe('PatientMangamentService', () => {
  let service: PatientMangamentService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ]
    });
    service = TestBed.inject(PatientMangamentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
