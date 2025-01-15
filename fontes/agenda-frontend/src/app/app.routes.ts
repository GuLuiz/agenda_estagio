import { Routes } from '@angular/router';
import { ListarComponent } from './admin/usuario/listar/listar.component';
import { UsuarioNovoComponent } from './admin/usuario/novo/novo.component';

export const routes: Routes = [
    { path: '', redirectTo: 'listar', pathMatch: 'full' },
    {path:'listar', component: ListarComponent},
    {path:'usuarioNovo', component: UsuarioNovoComponent}
];
