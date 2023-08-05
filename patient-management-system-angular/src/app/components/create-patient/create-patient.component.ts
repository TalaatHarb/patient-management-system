import { Component, OnInit } from '@angular/core';
import { MedicalCenter } from 'src/app/models/medical-center.model';
import { Organization } from 'src/app/models/organization.model';
import { Patient } from 'src/app/models/patient.model';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.scss']
})
export class CreatePatientComponent implements OnInit {

  organizations: Organization[] = [];
  medicalCenters: MedicalCenter[] = [];
  patientToCreate: Patient = new Patient();

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
    this.patientManagementService.fetchOrganizations().subscribe(organizations => {
      this.organizations = organizations;
    })
  }

  organizationChanged(event: string){
    this.patientToCreate.organizationId = event;
    this.patientManagementService.fetchMedicalCenters(this.patientToCreate.organizationId).subscribe(centers => {
      this.medicalCenters = centers;
    })
  }

  createPatient(){
    this.patientManagementService.createPatient(this.patientToCreate).subscribe(p => {
      this.patientToCreate.firstName = '';
      this.patientToCreate.lastName = '';
    });
  }

}
