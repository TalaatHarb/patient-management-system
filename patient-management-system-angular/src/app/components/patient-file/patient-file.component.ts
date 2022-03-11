import { Component, OnInit } from '@angular/core';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-patient-file',
  templateUrl: './patient-file.component.html',
  styleUrls: ['./patient-file.component.scss']
})
export class PatientFileComponent implements OnInit {

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
  }

}
