import { Component } from '@angular/core';
import { Entity } from './interfaces/entity';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'lab3-frontend';
  carList: Entity[] = [];

  constructor(private service: Service1Service) {}

  getEntities(): void {
    this.service.getEntityes().subscribe((entityes) => {
      this.carList = entityes;
    });
  }
}
