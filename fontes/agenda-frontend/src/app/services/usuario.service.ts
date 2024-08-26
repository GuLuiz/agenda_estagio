import { Injectable } from '@angular/core';
import { UsuarioInterface } from '../interfaces/usuario.interface';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as defaults from '../../environments/enviroments';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  URL_USUARIO: string = defaults.environment.appUrl + "usuario";

  headers = new HttpHeaders()
    .set('content-type', 'application/json')
  constructor(private httpClient: HttpClient) { }

  lista(): Observable<Array<Object>> {
    return this.httpClient.get<Array<Object>>(this.URL_USUARIO, { "headers": this.headers });
  }

  sendData(nome: string, email: string, senha: string, logradouro: string, numero: string, bairro: string, complemento: string, cidade: string, uf: string, cep: string, telefone: string) : Observable<UsuarioInterface> {

    const data = { nome, email, senha, logradouro, numero, bairro, complemento, cidade, uf, cep, telefone }
    return this.httpClient.post<UsuarioInterface>(this.URL_USUARIO, data);
  }
}
