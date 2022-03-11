import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CreatePatientComponent } from './components/create-patient/create-patient.component';
import { PatientFileComponent } from './components/patient-file/patient-file.component';
import { CreateMedicalCenterComponent } from './components/create-medical-center/create-medical-center.component';
import { EditMedicalCenterComponent } from './components/edit-medical-center/edit-medical-center.component';
import { CreateOrganizationComponent } from './components/create-organization/create-organization.component';
import { EditOrganizationComponent } from './components/edit-organization/edit-organization.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    CreatePatientComponent,
    PatientFileComponent,
    CreateMedicalCenterComponent,
    EditMedicalCenterComponent,
    CreateOrganizationComponent,
    EditOrganizationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
