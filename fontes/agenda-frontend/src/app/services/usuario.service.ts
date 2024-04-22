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
  constructor(private httpClient : HttpClient) { }

  lista(): Observable<Array<Object>> { 
    return this.httpClient.get<Array<Object>>(this.URL_USUARIO, {"headers":this.headers});
  }
}
