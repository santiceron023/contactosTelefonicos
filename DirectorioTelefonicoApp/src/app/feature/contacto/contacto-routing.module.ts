import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactoCrearComponent } from './components/contacto/contacto-crear/contacto-crear.component';
import { ContactoListarComponent } from './components/contacto/contacto-listar/contacto-listar.component';


const routes: Routes = [
  {
    path: '',
    component: ContactoListarComponent,
    children: [
      {
        path: 'nuevo',
        component: ContactoCrearComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContactoRoutingModule { }
