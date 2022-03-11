import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Organization } from '../models/organization.model';

const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class PatientMangamentService {

  constructor(private httpClient: HttpClient) { }

  public createOrganization(organization: Organization): Organization{
    return new Organization();
  }
}
