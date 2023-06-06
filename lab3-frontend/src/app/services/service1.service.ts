import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entity } from '../interfaces/entity';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Service1Service {
  list = new BehaviorSubject<Entity[]>([]);

  url: string = 'http://localhost:8080/lab33/cars';

  constructor(private http: HttpClient) {}

  getEntityes(): Observable<Entity[]> {
    return this.http.get<Entity[]>(this.url);
  }

  postEntity(entity: Entity): Observable<Entity[]> {
    return this.http.post<Entity[]>(this.url, entity);
  }

  putEntity(entity: Entity): Observable<Entity[]> {
    return this.http.put<Entity[]>(this.url + '/' + entity.id, entity);
  }

  deleteEntity(entity: Entity): Observable<Entity[]> {
    return this.http.delete<Entity[]>(this.url + '/' + entity.id);
  }

  setList(list: Entity[]) {
    this.list.next(list);
  }
}
