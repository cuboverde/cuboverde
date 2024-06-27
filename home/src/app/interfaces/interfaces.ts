export interface BlogInterface {
  images: string;
  idCategory: number;
  creationDate: string;
  idPublication: number;
  idUser: number;
  favorites: number;
  shared: number;
  likes: number;
  typePublication: string;
  titlePublication: string;
  descriptionPublication: string;
  approved: number;
  publicationDate: string;
}

export interface ErrorInterface {
  message:string;
  name:string;
  ok:boolean;
  status:number;
  statusText:string;
  url:string;
}

export interface UserInterface {
  idUser: number;
  creationDate:string;
  email:string;
  fistName:string;
  lastName:string;
  phone:string;
  userPassword:string;
}

export interface CategoryInterface {
  idCategory: number;
  descriptionCategory:string;
  createdDate:string;
}

export interface PublicationInterface {
  idPublication:number;
  idCategory:number;
  typePublication:number;
  titlePublication:string;
  descriptionPublication:string;
  approved:number;
  idUser:number;
  publicationDate:string;
  creationDate:string;
  favorites:number;
  shared:number;
  likes:number;
  images:string;
  
}

export interface CategoriesInterface {
  idCategory:number;
  descriptionCategory:string;
  createdDate:string;
}

export interface RolesInterface {
  idRol:number;
  rol:string;
}