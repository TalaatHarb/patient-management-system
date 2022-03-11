import { Component, OnInit } from '@angular/core';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.scss']
})
export class CreatePatientComponent implements OnInit {

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
  }

}
