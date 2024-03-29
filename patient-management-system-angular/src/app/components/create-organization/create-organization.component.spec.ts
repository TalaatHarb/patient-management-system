import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

import { CreateOrganizationComponent } from './create-organization.component';
import { FormsModule } from '@angular/forms';
import { MockModule } from 'ng-mocks';

describe('CreateOrganizationComponent', () => {
  let component: CreateOrganizationComponent;
  let fixture: ComponentFixture<CreateOrganizationComponent>;
  const patientManagementService: PatientMangamentService = jasmine.createSpyObj('patientManagementService', ['createOrganization']);

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateOrganizationComponent ],
      imports: [HttpClientTestingModule, MockModule(FormsModule)],
      providers: [
        { provide: PatientMangamentService, useValue: patientManagementService }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateOrganizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
