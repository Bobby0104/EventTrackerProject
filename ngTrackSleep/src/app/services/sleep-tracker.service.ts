import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SleepTrackerService {

  private baseUrl = 'http://localhost:8087/';
  private url = environment.baseUrl + 'api/sleep';

  constructor(private http: HttpClient) { }
}
