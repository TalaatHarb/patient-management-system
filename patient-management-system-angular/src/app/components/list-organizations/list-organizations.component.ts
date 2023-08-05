import { Component, OnInit } from '@angular/core';
import { Organization } from 'src/app/models/organization.model';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-list-organizations',
  templateUrl: './list-organizations.component.html',
  styleUrls: ['./list-organizations.component.scss']
})
export class ListOrganizationsComponent implements OnInit{

  organizations: Organization[] = [];
  organizationId = '';

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
    this.patientManagementService.fetchOrganizations().subscribe(organizations => {
      this.organizations = organizations;
    })
  }

}
