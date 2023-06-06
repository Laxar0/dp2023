import { Component } from '@angular/core';
import { Entity } fro../interfaces/entityentity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss'],
})
export class CarsComponent {
  title = 'lab3-frontend';
  carList: Entity[] = [];

  constructor(private service: Service1Service) {}

  ngOnInit(): void {
    this.service.getEntityes().subscribe((entityes) => {
      this.carList = entityes;
    });
  }
}
