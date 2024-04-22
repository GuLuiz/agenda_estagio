import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
import { ListarComponent } from './admin/usuario/listar/listar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatButtonModule, RouterLink, RouterLinkActive, ListarComponent],
  //templateUrl: './app.component.html',
  template : `<router-outlet></router-outlet>`,
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'agenda';
}
