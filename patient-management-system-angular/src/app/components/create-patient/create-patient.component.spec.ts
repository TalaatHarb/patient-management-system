import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

import { CreatePatientComponent } from './create-patient.component';
import { MockModule } from 'ng-mocks';
import { FormsModule } from '@angular/forms';
import { MedicalCenter } from 'src/app/models/medical-center.model';
import { Observable } from 'rxjs';
import { Organization } from 'src/app/models/organization.model';
import { Patient } from 'src/app/models/patient.model';

describe('CreatePatientComponent', () => {
  let component: CreatePatientComponent;
  let fixture: ComponentFixture<CreatePatientComponent>;
  let patientManagementService: PatientMangamentService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatePatientComponent ],
      imports: [HttpClientTestingModule, MockModule(FormsModule)],
      
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatePatientComponent);
    component = fixture.componentInstance;
    patientManagementService = fixture.debugElement.injector.get(PatientMangamentService);

    spyOn(patientManagementService, 'fetchOrganizations').and.returnValue(new Observable<Organization[]>());
    spyOn(patientManagementService, 'fetchMedicalCenters').and.returnValue(new Observable<MedicalCenter[]>());
    spyOn(patientManagementService, 'createPatient').and.returnValue(new Observable<Patient>());

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
