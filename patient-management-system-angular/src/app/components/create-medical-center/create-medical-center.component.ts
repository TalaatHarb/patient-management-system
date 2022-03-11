import { Component, OnInit } from '@angular/core';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-create-medical-center',
  templateUrl: './create-medical-center.component.html',
  styleUrls: ['./create-medical-center.component.scss']
})
export class CreateMedicalCenterComponent implements OnInit {

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
  }

  fetchOrganization(): void {
    this.patientManagementService.fetchOrganizations().subscribe(orgs => {
      console.table(orgs);
    });
  }

}
