import { NgModule } from '@angular/core';
import { MatToolbarModule, MatButtonModule, MatInputModule, MatTableModule, MatFormFieldModule, MatIconModule } from '@angular/material'
import { MAT_DATE_LOCALE } from '@angular/material/core'

@NgModule({
  declarations: [],
  imports: [
    MatToolbarModule,
    MatButtonModule,
    MatInputModule,
    MatTableModule,
    MatFormFieldModule,
    MatIconModule
  ],

  exports: [
    MatToolbarModule,
    MatButtonModule,
    MatInputModule,
    MatTableModule,
    MatFormFieldModule,
    MatIconModule
  ],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'es-ES' }
  ]
})
export class MaterialModule { }
