import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

import { PatientFileComponent } from './patient-file.component';

describe('PatientFileComponent', () => {
  let component: PatientFileComponent;
  let fixture: ComponentFixture<PatientFileComponent>;
  const patientManagementService: PatientMangamentService = jasmine.createSpyObj('patientManagementService', ['createOrganization']);

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientFileComponent ],
      imports: [HttpClientTestingModule],
      providers: [
        { provide: PatientMangamentService, useValue: patientManagementService }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
