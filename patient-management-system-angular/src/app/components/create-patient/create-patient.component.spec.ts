import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

import { CreatePatientComponent } from './create-patient.component';

describe('CreatePatientComponent', () => {
  let component: CreatePatientComponent;
  let fixture: ComponentFixture<CreatePatientComponent>;
  const patientManagementService: PatientMangamentService = jasmine.createSpyObj('patientManagementService', ['createOrganization']);

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatePatientComponent ],
      imports: [HttpClientTestingModule],
      providers: [
        { provide: PatientMangamentService, useValue: patientManagementService }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatePatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
