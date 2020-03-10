import { FormGroup } from '@angular/forms';

export function markFormGroupTouched(formGroup: FormGroup) {
  ObjectValues(formGroup.controls).forEach(control => {

      if (control.controls) { // control is a FormGroup
          markFormGroupTouched(control);
      } else { // control is a FormControl
          control.markAsTouched();
      }
  });
}

export function ObjectValues(obj) {
   
  let vals = [];
  let keys = (<any>Object).keys(obj);
  keys.forEach(element => {
      vals.push(obj[element]);
  });

  return vals;
}