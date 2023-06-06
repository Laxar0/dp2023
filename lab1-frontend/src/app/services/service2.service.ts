import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Worker } from '../interfaces/worker';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Service2Service {
  url: string = 'http://localhost:8080/lab1/Staff';

  constructor(private http: HttpClient) {}

  //asking data from backend part
  getWorkers(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.url);
  }
}
