import { Component } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-entityes',
  templateUrl: './entityes.component.html',
  styleUrls: ['./entityes.component.scss'],
})
export class EntityesComponent {
  title = 'lab6f';
  entityList: Entity[] = [];

  constructor(private service: Service1Service) {}

  ngOnInit(): void {
    this.service.getEntityes().subscribe((entityes: Entity[]) => {
      this.entityList = entityes;
    });
  }
}
