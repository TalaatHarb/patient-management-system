import { Component, OnInit } from '@angular/core';
import { PatientMangamentService } from 'src/app/services/patient-mangament.service';

@Component({
  selector: 'app-edit-medical-center',
  templateUrl: './edit-medical-center.component.html',
  styleUrls: ['./edit-medical-center.component.scss']
})
export class EditMedicalCenterComponent implements OnInit {

  constructor(private patientManagementService: PatientMangamentService) { }

  ngOnInit(): void {
  }

}
