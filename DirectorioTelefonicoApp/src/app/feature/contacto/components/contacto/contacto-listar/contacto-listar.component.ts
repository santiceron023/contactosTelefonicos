import { Component, OnInit } from '@angular/core';
import { Contacto } from '../../../shared/conctacto';
import { MatTableDataSource } from '@angular/material/table';
import { ContactoService } from '../../../services/contacto/contacto.service';
import { MatDialog } from '@angular/material';
import { AlertDialogComponent } from 'src/app/shared/alert/alert-dialog/alert-dialog.component';
import { MSG_DELETED } from 'src/app/shared/mensajes';

@Component({
  selector: 'app-contacto-listar',
  templateUrl: './contacto-listar.component.html',
  styleUrls: ['./contacto-listar.component.css']
})
export class ContactoListarComponent implements OnInit {

  contactos: Contacto[];
  infoMessage: string;

  displayedColumns = ['nombre', 'telefono', 'acciones'];
  dataSource: MatTableDataSource<Contacto>;

  constructor(
    private contactoService: ContactoService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.setDatadable();
    this.subscripcionCambiosCreacion();
  }

  subscripcionCambiosCreacion() {
    this.contactoService.recargar.subscribe(
      (data: boolean) => {
        if (data) {
          this.setDatadable();
          this.contactoService.recargar.next(false);
        }
      });
  }

  setDatadable() {
    this.contactoService.listar().subscribe(
      (data: Contacto[]) => {
        console.log(data);
        this.dataSource = new MatTableDataSource(data);
      });
  }

  eliminar(contacto: Contacto) {
    this.contactoService.eliminar(contacto.id).subscribe(
      () => {
          this.dialog.open(AlertDialogComponent, {
            data: MSG_DELETED
          });
        this.contactoService.recargar.next(true);
      }
    );
  }

}
