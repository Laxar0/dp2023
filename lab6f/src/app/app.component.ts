import { Component } from '@angular/core';
import { Entity } from './interfaces/entity';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'lab6f';
  entityList: Entity[] = [];

  constructor(private service: Service1Service) {}

  getEntityes(): void {
    this.service.getEntityes().subscribe((entityes: Entity[]) => {
      this.entityList = entityes;
    });
  }
}
