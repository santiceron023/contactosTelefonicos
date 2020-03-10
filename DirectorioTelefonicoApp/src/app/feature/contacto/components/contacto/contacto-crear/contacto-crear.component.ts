import { Component, OnInit } from '@angular/core';
import { ContactoService } from '../../../services/contacto/contacto.service';
import { Contacto } from '../../../shared/conctacto';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { markFormGroupTouched } from 'src/app/shared/formValidationUtils';
import { AlertDialogComponent } from 'src/app/shared/alert/alert-dialog/alert-dialog.component';
import { MSG_CREATED } from 'src/app/shared/mensajes';

@Component({
  selector: 'app-contacto-crear',
  templateUrl: './contacto-crear.component.html',
  styleUrls: ['./contacto-crear.component.css']
})
export class ContactoCrearComponent implements OnInit {

  form: FormGroup;
  constructor(
    private contactoService: ContactoService,
    private router: Router,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.form = new FormGroup({
      nombreFormCtrl: new FormControl("", Validators.required),
      telefonoFormCtrl: new FormControl("", Validators.required)
    });
  }

  guardar() {
    if (!this.form.valid) {
      markFormGroupTouched(this.form);
      return;
    }

    let cancha = new Contacto(
      null,
      this.form.get("nombreFormCtrl").value,
      this.form.get("telefonoFormCtrl").value
    );

    this.contactoService.crear(cancha).subscribe(
      () => {
      this.dialog.open(AlertDialogComponent, {
        data: MSG_CREATED
      });      
      this.navegarLista()
    });
  }

  navegarLista() {
    this.contactoService.recargar.next(true);
    this.router.navigateByUrl("/contacto");
  }

}
