import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
  HttpEvent,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MatDialog } from '@angular/material';
import { AlertDialogComponent } from '../../shared/alert/alert-dialog/alert-dialog.component';
import {
  ERR_CONECTION,
  ERR_SERVER,
  ERR_CLIENT,
} from 'src/app/shared/mensajes';
import {
  CODE_NO_CONECTION,
  CODE_ERR_SERVER,
  CODE_ERR_CLIENT
} from 'src/app/shared/codigosError';

@Injectable()
export class ResponseCodeInterceptor implements HttpInterceptor {

  constructor(public dialog: MatDialog) { }

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === CODE_NO_CONECTION) {
          this.dialog.open(AlertDialogComponent, { data: ERR_CONECTION });
        }

        if (error.status === CODE_ERR_SERVER) {
          this.dialog.open(AlertDialogComponent, {
            data: `${ERR_SERVER}${error.error.mensaje}`
          });
        }

        if (error.status === CODE_ERR_CLIENT) {
          this.dialog.open(AlertDialogComponent, {
            data: `${ERR_CLIENT}${error.error.mensaje}`
          });
        }

        return throwError(error);
      })
    );
  }
}
