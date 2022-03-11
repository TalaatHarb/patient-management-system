import { Component, OnInit } from '@angular/core';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-create-organization',
  templateUrl: './create-organization.component.html',
  styleUrls: ['./create-organization.component.scss']
})
export class CreateOrganizationComponent implements OnInit {

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
  }

}
