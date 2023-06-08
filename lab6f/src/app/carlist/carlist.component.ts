import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-entitylist',
  templateUrl: './entitylist.component.html',
  styleUrls: ['./entitylist.component.scss'],
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
    this.service.getEntityes().subscribe((entityes: Entity[]) => {
      this.service.setList(entityes);
    });
  }

  addEntity(entity: Entity) {
    this.service.postEntity(entity).subscribe((entityes: any) => {
      this.updateEntityes();
    });
    this.refreshPage();
  }

  onSelect(entity: Entity) {
    if (this.selectedEntity && entity.id == this.selectedEntity.id) {
      this.selectedEntity = undefined;
    } else {
      this.selectedEntity = entity;
    }
  }

  deleteEntity(entity: Entity) {
    this.service.deleteEntity(entity).subscribe(() => {
      this.updateEntityes();
    });
    this.refreshPage();
  }

  refreshPage(): void {
    window.location.reload();
  }
}
