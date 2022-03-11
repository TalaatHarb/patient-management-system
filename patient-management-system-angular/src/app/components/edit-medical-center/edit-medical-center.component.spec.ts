import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

import { EditMedicalCenterComponent } from './edit-medical-center.component';

describe('EditMedicalCenterComponent', () => {
  let component: EditMedicalCenterComponent;
  let fixture: ComponentFixture<EditMedicalCenterComponent>;
  const patientManagementService: PatientMangamentService = jasmine.createSpyObj('patientManagementService', ['createOrganization']);

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditMedicalCenterComponent ],
      imports: [HttpClientTestingModule],
      providers: [
        { provide: PatientMangamentService, useValue: patientManagementService }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditMedicalCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
