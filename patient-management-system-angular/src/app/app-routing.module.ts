import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CreateMedicalCenterComponent } from './components/create-medical-center/create-medical-center.component';
import { CreateOrganizationComponent } from './components/create-organization/create-organization.component';
import { CreatePatientComponent } from './components/create-patient/create-patient.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EditMedicalCenterComponent } from './components/edit-medical-center/edit-medical-center.component';
import { EditOrganizationComponent } from './components/edit-organization/edit-organization.component';
import { PatientFileComponent } from './components/patient-file/patient-file.component';

const routes: Routes = [
  {path: '', redirectTo: 'web/dashboard', pathMatch: 'full' },
  {path: 'web/dashboard', component: DashboardComponent},
  {path: 'web/create-medical-center', component: CreateMedicalCenterComponent},
  {path: 'web/create-organization', component: CreateOrganizationComponent},
  {path: 'web/create-patient', component: CreatePatientComponent},
  {path: 'web/edit-medical-center', component: EditMedicalCenterComponent},
  {path: 'web/edit-organization', component: EditOrganizationComponent},
  {path: 'web/edit-patient', component: PatientFileComponent},
  {path: 'web/**', component: AppComponent},
  {path: 'login', component: AppComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
