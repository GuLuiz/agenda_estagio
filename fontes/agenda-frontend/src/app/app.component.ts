import { CommonModule } from '@angular/common';
import { Component, computed, signal } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterOutlet } from '@angular/router';
import { CustomSidenavComponent } from './custom-sidenav/custom-sidenav.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatSidenavModule, CommonModule, MatMenuModule, MatIconModule, MatToolbarModule, CustomSidenavComponent, MatButtonModule],
  templateUrl :'./app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  collapsed = signal(false);

  sidenavWidth = computed(() => this.collapsed() ? '65px' : '250px');

  title(title: any) {
    throw new Error('Method not implemented.');

  }

}
