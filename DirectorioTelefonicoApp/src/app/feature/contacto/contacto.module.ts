import { NgModule } from '@angular/core';

import { SharedModule } from 'src/app/shared/shared.module';
import { MaterialModule } from 'src/app/shared/material.module';
import { ContactoCrearComponent } from './components/contacto/contacto-crear/contacto-crear.component';
import { ContactoListarComponent } from './components/contacto/contacto-listar/contacto-listar.component';
import { ContactoRoutingModule } from './contacto-routing.module';
import { ContactoService } from './services/contacto/contacto.service';

@NgModule({
  declarations: [
    ContactoCrearComponent,
    ContactoListarComponent
  ],
  imports: [
    ContactoRoutingModule,
    SharedModule,
    MaterialModule
  ],
  providers:[
    ContactoService
  ]
})
export class ContactoModule { }
