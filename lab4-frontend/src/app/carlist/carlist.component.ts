import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-carlist',
  templateUrl: './carlist.component.html',
  styleUrls: ['./carlist.component.scss'],
})
export class EntitylistComponent implements OnInit {
  title: string = 'List of entityes';
  entityList: Entity[] = [];
  showAddForm: boolean = false;
  selectedEntity?: Entity;

  constructor(private service: Service1Service) {}

  ngOnInit(): void {
    this.updateEntityes();
    this.service.list.subscribe((list: Entity[]) => {
      this.entityList = list;
    });
  }

  updateEntityes() {
    this.service.getEntityes().subscribe((entityes) => {
      this.service.setList(entityes);
    });
  }

  addCar(Entity: Entity) {
    this.service.postEntity(Entity).subscribe((entityes) => {
      this.updateEntityes();
    });
    this.refreshPage();
  }

  onSelect(Entity: Entity) {
    if (this.selectedEntity && Entity.id == this.selectedEntity.id) {
      this.selectedEntity = undefined;
    } else {
      this.selectedEntity = Entity;
    }
  }

  deleteCar(Entity: Entity) {
    this.service.deleteEntity(Entity).subscribe(() => {
      this.updateEntityes();
    });
    this.refreshPage();
  }

  refreshPage(): void {
    window.location.reload();
  }
}
