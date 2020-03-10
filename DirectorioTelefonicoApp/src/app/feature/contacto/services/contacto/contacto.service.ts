import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Contacto } from '../../shared/conctacto';
import { environment } from 'src/environments/environment';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactoService {

  recargar = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) {
  }

  listar() {
    return this.http.get<Contacto[]>(
      `${environment.endpoint}/contactos`);
  }

  crear(contacto: Contacto) {
    return this.http.post(`${environment.endpoint}/contactos`, contacto);
  }

  eliminar(id: number) {
    return this.http.delete(`${environment.endpoint}/contactos/${id}`);
  }
}
