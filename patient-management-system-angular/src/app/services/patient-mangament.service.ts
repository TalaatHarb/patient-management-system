import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { MedicalCenter } from '../models/medical-center.model';
import { Organization } from '../models/organization.model';
import { Patient } from '../models/patient.model';

const API_URL = environment.apiUrl;
const ORGANIZATION_URL = API_URL + '/v1/organizations';
const MEDICAL_CENTER_URL = '/medical-centers';

@Injectable({
  providedIn: 'root'
})
export class PatientMangamentService {
  fetchMedicalCenters(organizationId: string): Observable<MedicalCenter[]> {
    return this.httpClient.get<MedicalCenter[]>(`${API_URL}/v1/organizations/${organizationId}/medical-centers`);
  }
  
  constructor(private httpClient: HttpClient) { }
  
  public createOrganization(organization: Organization): Observable<Organization>{
    const ORGANIZATION_URL = API_URL + '/v1/organizations';
    return this.httpClient.post<Organization>(ORGANIZATION_URL, organization);
  }
  
  public fetchOrganizations(): Observable<Organization[]>{
    return this.httpClient.get<Organization[]>(ORGANIZATION_URL);
  }

  public createMedicalCenter(medicalCenter: MedicalCenter): Observable<MedicalCenter> {
    const url = ORGANIZATION_URL + '/' + medicalCenter.organizationId + MEDICAL_CENTER_URL;
    return this.httpClient.post<MedicalCenter>(url, medicalCenter);
  }

  public createPatient(patient: Patient): Observable<Patient>{
    return this.httpClient.post<Patient>(`${API_URL}/v1/patients`, patient);
  }
}
