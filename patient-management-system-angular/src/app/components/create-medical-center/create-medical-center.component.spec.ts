import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';

import { MockModule } from 'ng-mocks';

import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

import { CreateMedicalCenterComponent } from './create-medical-center.component';

describe('CreateMedicalCenterComponent', () => {
  let component: CreateMedicalCenterComponent;
  let fixture: ComponentFixture<CreateMedicalCenterComponent>;
  const patientManagementService: PatientMangamentService = jasmine.createSpyObj('patientManagementService', ['fetchOrganizations', 'createMedicalCenter']);

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateMedicalCenterComponent],
      imports: [
        HttpClientTestingModule,
        MockModule(FormsModule)
      ],
      providers: [
        { provide: PatientMangamentService, useValue: patientManagementService }
      ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateMedicalCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
