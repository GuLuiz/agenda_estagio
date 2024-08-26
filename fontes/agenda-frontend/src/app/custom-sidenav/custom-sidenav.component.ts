import { Component, Input, computed, signal } from '@angular/core';
import { MatListModule } from '@angular/material/list'
import { MatIconModule } from '@angular/material/icon'
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

export type MenuItem = {
  icon: string;
  label: string;
  route: string;
}
@Component({
  selector: 'app-custom-sidenav',
  standalone: true,
  imports: [CommonModule, MatListModule, MatIconModule, RouterLink],
  templateUrl: './custom-sidenav.component.html',
  styleUrls: ['./custom-sidenav.component.scss'] 
})
export class CustomSidenavComponent {

  sidenavCollapsed = signal(false);
  @Input() set collapsed(val: boolean){
    this.sidenavCollapsed.set(val);
  }

  menuItems = signal<MenuItem[]>([
    {
      icon:'person',
      label:'Usuario',
      route:'listar'
    }
  ])

  get profilePicSize() {
    return this.sidenavCollapsed() ? '32' : '100';
  }
}
