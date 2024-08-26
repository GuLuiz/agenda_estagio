import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators, AbstractControl, ValidatorFn } from '@angular/forms';
import { BtnPrimaryComponent } from '../../../btn-primary/btn-primary.component';
import { UsuarioService } from '../../../services/usuario.service';

export function cepValidator(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    const cep = control.value;
    const validCepPattern = /^[0-9]{5}-?[0-9]{3}$/;
    return validCepPattern.test(cep) ? null : { 'invalidCep': { value: cep } };
  };
}

@Component({
  selector: 'app-usuario-novo',
  standalone: true,
  imports: [ReactiveFormsModule, BtnPrimaryComponent],
  providers: [UsuarioService],
  templateUrl: './novo.component.html',
  styleUrls: ['./novo.component.scss']
})
export class UsuarioNovoComponent {
  usuarioCadastro!: FormGroup;

  constructor(private service: UsuarioService) {
    this.usuarioCadastro = new FormGroup({
      nome: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      senha: new FormControl('', [Validators.required]),
      telefone: new FormControl('', [Validators.required]),
      cep: new FormControl('', [Validators.required, cepValidator()]),
      uf: new FormControl('', [Validators.required]),
      logradouro: new FormControl('', [Validators.required]),
      numero: new FormControl('', [Validators.required]),
      cidade: new FormControl('', [Validators.required]),
      bairro: new FormControl('', [Validators.required]),
      complemento: new FormControl('', []),
    });
  }

  onSubmit() {
    console.log(this.usuarioCadastro.value);
    if (this.usuarioCadastro.valid) {
      this.service.sendData(
        this.usuarioCadastro.value.nome,
        this.usuarioCadastro.value.email,
        this.usuarioCadastro.value.senha,
        this.usuarioCadastro.value.telefone,
        this.usuarioCadastro.value.cep,
        this.usuarioCadastro.value.uf,
        this.usuarioCadastro.value.logradouro,
        this.usuarioCadastro.value.numero,
        this.usuarioCadastro.value.cidade,
        this.usuarioCadastro.value.bairro,
        this.usuarioCadastro.value.complemento
      ).subscribe({
        next: () => { this.usuarioCadastro.reset(); }
      })
    }
  }
}
