import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';

import { MockModule } from 'ng-mocks';
import { Observable } from 'rxjs';
import { MedicalCenter } from 'src/app/models/medical-center.model';
import { Organization } from 'src/app/models/organization.model';

import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

import { CreateMedicalCenterComponent } from './create-medical-center.component';

describe('CreateMedicalCenterComponent', () => {
  let component: CreateMedicalCenterComponent;
  let fixture: ComponentFixture<CreateMedicalCenterComponent>;
  let patientManagementService: PatientMangamentService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateMedicalCenterComponent],
      imports: [
        HttpClientTestingModule,
        MockModule(FormsModule)
      ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateMedicalCenterComponent);
    component = fixture.componentInstance;
    patientManagementService = fixture.debugElement.injector.get(PatientMangamentService);

    spyOn(patientManagementService, 'fetchOrganizations').and.returnValue(new Observable<Organization[]>());
    spyOn(patientManagementService, 'createMedicalCenter').and.returnValue(new Observable<MedicalCenter>());

    fixture.detectChanges();
  });

  it('should create medical center creation page', () => {
    expect(component).toBeTruthy();
  });
});
