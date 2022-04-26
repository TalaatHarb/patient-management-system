import { Component, OnInit } from '@angular/core';
import { MedicalCenter } from 'src/app/models/medical-center.model';
import { Organization } from 'src/app/models/organization.model';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-create-medical-center',
  templateUrl: './create-medical-center.component.html',
  styleUrls: ['./create-medical-center.component.scss']
})
export class CreateMedicalCenterComponent implements OnInit {

  organizations: Organization[] = [];
  medicalCenterToCreate: MedicalCenter = new MedicalCenter();

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
    this.fetchOrganization();
  }

  fetchOrganization(): void {
    this.patientManagementService.fetchOrganizations().subscribe(orgs => {
      this.organizations = orgs;
    });
  }

  createMedicalCenter(): void{
    if(this.medicalCenterToCreate.organizationId !== '' && this.medicalCenterToCreate.name !== ''){
      this.patientManagementService.createMedicalCenter(this.medicalCenterToCreate).subscribe(medicalCenter => {
        this.medicalCenterToCreate = medicalCenter;
      });
    }
  }

}
