import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError} from 'rxjs/operators';
import { Sleep } from '../models/sleep';

@Injectable({
  providedIn: 'root'
})
export class SleepTrackerService {

  private baseUrl = 'http://localhost:8087/';
  private url = environment.baseUrl + 'api/sleep';

  constructor(private http: HttpClient) { }

  index(): Observable<Sleep[]> {
    return this.http.get<Sleep[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('SleepTrackerService.index(): Error retrieving Sleep Tracker List')
      })
    );
  }

  show(id: number): Observable<Sleep> {
    return this.http.get<Sleep>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('SleepTrackerService.show(): Error retrieving Sleep Tracker show');
      })
    );
  }

  create(sleep: Sleep): Observable<Sleep> {
    return this.http.post<Sleep>(this.url, sleep).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('SleepTrackerService.create(): Error create Sleep Tracker information');
      })
    );
  }

  update(sleep: Sleep){
    return this.http.put<Sleep>(`${this.url}/${sleep.id}`, sleep).pipe(
      catchError((err: any)=>{
        console.log(err);
        return throwError('SleepTrackerService.update(): Error updating Sleep Tracker');
      })
    );
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('SleepTrackerService.delete(): error deleting Sleep Tracker with id' + id);
      })
    );
  }


}
