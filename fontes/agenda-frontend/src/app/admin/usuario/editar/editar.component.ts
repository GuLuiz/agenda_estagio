import { Component } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { ActivatedRoute, Router, RouterLink, RouterModule } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Observable, switchMap } from 'rxjs';
import { UsuarioInterface } from '../../../interfaces/usuario.interface';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'usuarioEditar',
  standalone: true,
  imports: [RouterLink, RouterModule, ReactiveFormsModule, MatIconModule],
  templateUrl: './editar.component.html',
  styleUrl: './editar.component.scss'
})
export class EditarComponent {

  usuarioEditar!: FormGroup;
  usuario!: UsuarioInterface;
  selectedId: string;

  constructor(private route: ActivatedRoute, private service: UsuarioService, private router: Router) {
    this.selectedId = "0";

    this.usuarioEditar = new FormGroup({
      nome: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      senha: new FormControl('', [Validators.required]),
      logradouro: new FormControl('', [Validators.required]),
      numero: new FormControl('', [Validators.required]),
      bairro: new FormControl('', [Validators.required]),
      complemento: new FormControl('', []),
      cidade: new FormControl('', [Validators.required]),
      uf: new FormControl('', [Validators.required]),
      cep: new FormControl('', [Validators.required]),
      telefone: new FormControl('', [Validators.required])
    });
  }

  ngOnInit() {
    this.selectedId = this.route.snapshot.paramMap.get('id') ?? "0";
    this.service.selectById(this.selectedId).subscribe(
      (res) => {
        console.log(res);
        this.usuario = res;

        this.usuarioEditar.patchValue({
          nome: this.usuario.nome,
          email: this.usuario.email,
          logradouro: this.usuario.logradouro,
          numero: this.usuario.numero,
          bairro: this.usuario.bairro,
          complemento: this.usuario.complemento,
          cidade: this.usuario.cidade,
          uf: this.usuario.uf,
          cep: this.usuario.cep,
          telefone: this.usuario.telefone,
          senha: this.usuario.senha,
        });
      },
      (err) => {
        console.error('Erro ao buscar usuário:', err);
      }
    );
  }
  
  onSubmit() {
    if (this.usuarioEditar.valid) {
      const formData = this.usuarioEditar.value;
      console.log('Formulário enviado:', formData);

      this.service
        .sendDataById(
          this.selectedId,
          formData.nome,
          formData.email,
          formData.senha,
          formData.logradouro,
          formData.numero,
          formData.bairro,
          formData.complemento,
          formData.cidade,
          formData.uf,
          formData.cep,
          formData.telefone
        )
        .subscribe({
          next: () => {
            console.log('Usuário cadastrado com sucesso!');
            this.router.navigate(['/listar']);
            this.usuarioEditar.reset();
          },
          error: (err) => {
            console.error('Erro ao cadastrar usuário:', err);
          },
        });
    } else {
      console.log('Formulário inválido!');
    }
  }
  cancelar(): void {
    this.router.navigate(['/listar']);
  }

  deletarUsuario(): void{
    if(confirm('Tem certeza que deseja excluir este usuário?')){
      this.service.deleteById(this.selectedId).subscribe({
        next: ()=>{
          console.log('Usuário excluído com sucesso!');
          this.router.navigate(['listar']);
        },
        error:(err) =>{
          console.error('Erro ao excluir o usuário: ', err)
        }
      })
    }
  }

}
