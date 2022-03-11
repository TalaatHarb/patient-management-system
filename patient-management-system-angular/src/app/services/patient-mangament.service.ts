import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Organization } from '../models/organization.model';

const API_URL = environment.apiUrl;
const CREATE_ORGANIZATION_URL = API_URL + '/v1/organizations';

@Injectable({
  providedIn: 'root'
})
export class PatientMangamentService {

  constructor(private httpClient: HttpClient) { }

  public createOrganization(organization: Organization): Observable<Organization>{
const CREATE_ORGANIZATION_URL = API_URL + '/v1/organizations';
    return this.httpClient.post<Organization>(CREATE_ORGANIZATION_URL, organization);
  }
}
