import { Component } from '@angular/core';
import { Entity } from './interfaces/entity';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']

})
export class AppComponent {
  title = 'lab1.2f';
  entityList:Entity[]=[];

  constructor(private service:Service1Service){}

  getEntities():void{
    this.service.GetEntities().subscribe(
      (entities)=>{
        this.entityList=Object.values(entities);
      }
    )
  }
}
function getClass(entityList: Entity[]): any {
  throw new Error('Function not implemented.');
}

