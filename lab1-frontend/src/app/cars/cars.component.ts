import { Component } from '@angular/core';
import { Car } from '../interfaces/car';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss'],
})
export class CarsComponent {
  title = 'lab1-frontend';
  carList: Car[] = [];

  constructor(private service: Service1Service) {}

  getCars(): void {
    this.service.getEntities().subscribe((cars) => {
      this.carList = cars;
    });
  }
}
