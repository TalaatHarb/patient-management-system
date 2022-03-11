import { Component, OnInit } from '@angular/core';
import { Organization } from 'src/app/models/organization.model';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-create-organization',
  templateUrl: './create-organization.component.html',
  styleUrls: ['./create-organization.component.scss']
})
export class CreateOrganizationComponent implements OnInit {

  public organizationToCreate: Organization = new Organization();

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
  }

  createOrganization(): void{
    console.log(this.organizationToCreate.name);
    if(this.organizationToCreate.name !== ''){
      this.patientManagementService.createOrganization(this.organizationToCreate).subscribe(outputOrganization => {
        this.organizationToCreate = outputOrganization;
      });
    }
  }

}
