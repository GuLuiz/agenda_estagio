import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { UsuarioInterface } from '../../../interfaces/usuario.interface';
import { CommonModule } from '@angular/common';
import {MatTableModule} from '@angular/material/table'; 
import { MatButtonModule } from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { Router, RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'listar',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatButtonModule,MatIconModule, RouterModule, RouterLink ],
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.scss'
})
export class ListarComponent {

  colunas: string [] = ['Id','Nome', 'Email', 'Acoes'] ;
  usuarios: any = [];

  constructor(private usuarioService : UsuarioService, private router: Router  ){}

  ngOnInit(){
    console.log("passei aqui");
    this.listar();
  }
  listar(){
    this.usuarioService.lista().subscribe(
      res => {
        console.log(res);
        this.usuarios = res;
      }
    )
  }
  adicionarNovo(){
    this.router.navigate(['usuarioNovo']);
  }
  editarUsuario(){
    this.router.navigate(['usuarioEditar']);
  }
}
