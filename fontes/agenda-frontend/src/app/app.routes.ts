import { Routes } from '@angular/router';
import { ListarComponent } from './admin/usuario/listar/listar.component';
import { UsuarioNovoComponent } from './admin/usuario/novo/novo.component';
import { EditarComponent } from './admin/usuario/editar/editar.component';

export const routes: Routes = [
    {path: '', redirectTo: 'listar', pathMatch: 'full' },
    {path:'listar', component: ListarComponent},
    {path:'usuarioNovo', component: UsuarioNovoComponent},
    {path:'usuarioEditar/:id', component: EditarComponent}
];
