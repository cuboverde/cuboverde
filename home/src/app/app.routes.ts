import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { NotfoundComponent } from './core/notfound/notfound.component';
import { AboutComponent } from './pages/about/about.component';
import { NosotrosComponent } from './pages/nosotros/nosotros.component';
import { GalleryComponent } from './pages/gallery/gallery.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ContactComponent } from './pages/contact/contact.component';
import { PoliticasComponent } from './pages/politicas/politicas.component';
import { BlogComponent } from './pages/blog/blog.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { UsersComponent } from './admin/users/users.component';
import { CategoriesComponent } from './admin/categories/categories.component';
import { PublicationsComponent } from './admin/publications/publications.component';
import { ArticleComponent } from './pages/article/article.component';


export const routes: Routes = [
  {path: 'home',component:HomeComponent},
  {path: 'about',component:AboutComponent},
  {path: 'nosotros',component:NosotrosComponent},
  {path: 'gallery',component:GalleryComponent},
  {path: 'login',component:LoginComponent},
  {path: 'registrar',component:RegisterComponent},
  {path: 'contact',component:ContactComponent},
  {path: 'politicas',component:PoliticasComponent},
  {path: 'blog',component:BlogComponent},
  {path: 'dashboard',component:DashboardComponent},
  {path: 'users',component:UsersComponent},
  {path: 'categorias',component:CategoriesComponent},
  {path: 'publications',component:PublicationsComponent},
  {path: 'blog/article/:id',component: ArticleComponent },
  {path: '',redirectTo: 'home', pathMatch: 'full' },
  {path: '**', component: NotfoundComponent}
];
