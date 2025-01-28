import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { UsuarioService } from '../../../services/usuario.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'usuario-novo',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  providers: [UsuarioService],
  templateUrl: './novo.component.html',
  styleUrls: ['./novo.component.scss'],
})
export class UsuarioNovoComponent {
  usuarioCadastro!: FormGroup;

  constructor(private usuarioService: UsuarioService,
    private router: Router
  ) {
    
    this.usuarioCadastro = new FormGroup({
      nome: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      senha: new FormControl('', [Validators.required]),
      logradouro: new FormControl('', [Validators.required]),
      numero: new FormControl('', [Validators.required]),
      bairro: new FormControl('', [Validators.required]),
      complemento: new FormControl('', []),
      cidade: new FormControl('', [Validators.required]),
      uf: new FormControl('', [Validators.required]),
      cep: new FormControl('', [Validators.required]),
      telefone: new FormControl('', [Validators.required]),
    });
  }

  onSubmit() {
    if (this.usuarioCadastro.valid) {
      const formData = this.usuarioCadastro.value;

      this.usuarioService
        .sendData(
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
            this.usuarioCadastro.reset();
          },
          error: (err) => {
            console.error('Erro ao cadastrar usuário:', err);
          },
        });
    } else {
      console.log('Formulário inválido!');
      console.log(this.usuarioCadastro)
    }
  }
  cancelar(): void {
    this.router.navigate(['/listar']); // Redireciona para a lista de usuários
  }
}
