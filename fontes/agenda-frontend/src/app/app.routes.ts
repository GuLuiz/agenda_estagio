import { Routes } from '@angular/router';
import { ListarComponent } from './admin/usuario/listar/listar.component';

export const routes: Routes = [
    {path:'usuario', component: ListarComponent},
    {path: '**', redirectTo: 'usuario', pathMatch: 'full' }


];
