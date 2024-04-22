import { Injectable } from '@angular/core';
import { UsuarioInterface } from '../interfaces/usuario.interface';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  URL_USUARIO: string = "/usuario";
    headers = new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*'); // Para o http identificar o backend e nao da o erro de CORS
 

  constructor(private httpClient : HttpClient) { }

  lista(): Observable<Array<Object>> { 
    return this.httpClient.get<Array<Object>>("http://localhost:8080/agenda" + this.URL_USUARIO, {"headers":this.headers});
  }
}
