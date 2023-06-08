import { EntityesLinks } from './rest.interfaces/entityes_links';

export interface Entity {
  id: number;
  img: string;
  name: string;
  price: number;
  _links?: EntityesLinks;
}
