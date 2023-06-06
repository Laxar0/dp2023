import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entity } from '../interfaces/entity';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
url:string="http://localhost:8080/Lab1.2/Servlet1";
  constructor(private http:HttpClient) { }
  GetEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }

}
