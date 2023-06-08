import { Component } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-entityes',
  templateUrl: './entityes.component.html',
  styleUrls: ['./entityes.component.scss'],
})
export class EntityesComponent {
  title = 'lab7f';
  carList: Entity[] = [];
  Entity!: Entity[];

  constructor(private service: Service1Service) {}

  ngOnInit(): void {
    this.service.getEntityes().subscribe((entityes: { _embedded: { entityes: Entity[]; }; }) => {
      this.Entity = entityes._embedded.entityes;
    });
  }
}
