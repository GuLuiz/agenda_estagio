import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { UsuarioInterface } from '../../../interfaces/usuario.interface';
import { CommonModule } from '@angular/common';
import {MatTableModule} from '@angular/material/table'; 

@Component({
  selector: 'app-listar',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.scss'
})
export class ListarComponent {

  colunas: string [] = ['Id','Nome', 'Email'] ;
  usuarios: any = []; 

  constructor(private usuarioService : UsuarioService){}

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
}
