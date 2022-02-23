import { Categorie } from './categories.model';

export class Article {
  constructor(
    public id: number,
    public libelle: string,
    public marque: string,
    public prix: number,
    public categorie: Categorie
  ) {}
}
