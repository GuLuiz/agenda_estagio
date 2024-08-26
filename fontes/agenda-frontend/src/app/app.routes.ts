import { Routes } from '@angular/router';
import { ListarComponent } from './admin/usuario/listar/listar.component';

export const routes: Routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    {path:'usuario', component: ListarComponent}


];
