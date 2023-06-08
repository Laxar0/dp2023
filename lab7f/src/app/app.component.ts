import { Component } from '@angular/core';
import { Car } from './interfaces/entity';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'lab7f';
  carList: Car[] = [];

  constructor(private service: Service1Service) {}

  Car!: Car[];

  getCars(): void {
    this.service.getCars().subscribe((cars) => {
      this.Car = cars._embedded.cars;
    });
  }
}
