import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { UsuarioInterface } from '../../../interfaces/usuario.interface';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.scss'
})
export class ListarComponent {

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
