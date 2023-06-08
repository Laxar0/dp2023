import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entity } from '../interfaces/entity';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Service1Service {
  list = new BehaviorSubject<Entity[]>([]);

  url: string = 'http://localhost:8080/lab6/api';

  constructor(private http: HttpClient) {}

  getEntityes(): Observable<Entity[]> {
    return this.http.get<Entity[]>(this.url + '/list');
  }

  postEntity(entity: Entity): Observable<Entity[]> {
    return this.http.post<Entity[]>(this.url + '/add', entity);
  }

  putEntity(entity: Entity): Observable<Entity[]> {
    return this.http.put<Entity[]>(this.url + '/update' + `/${entity.id}`, entity);
  }

  deleteEntity(entity: Entity): Observable<Entity[]> {
    return this.http.delete<Entity[]>(this.url + '/delete' + `/${entity.id}`);
  }

  setList(list: Entity[]) {
    this.list.next(list);
  }
}
