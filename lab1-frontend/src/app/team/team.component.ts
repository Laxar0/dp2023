import { Component } from '@angular/core';
import { Worker } from '../interfaces/worker';
import { Service2Service } from '../services/service2.service';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.scss'],
})
export class TeamComponent {
  title = 'lab1-frontend';
  workerList: Worker[] = [];

  constructor(private service: Service2Service) {}

  getWorkers(): void {
    this.service.getWorkers().subscribe((workers) => {
      this.workerList = workers;
    });
  }
}
