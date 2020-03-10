import { browser, by, element } from "protractor";

export class AppPage {

  navegarVerContactos() {
    return browser.get("/contacto");
  }

  crearContacto() {
    element(by.formControlName("nombreFormCtrl")).sendKeys("juliana diaz");
    element(by.formControlName("telefonoFormCtrl")).sendKeys("300772");
    element(by.id("contactoGuardarBtn")).click();
  }
  seleccionarBotonAgregarContacto(){
    element(by.id("contactoAgregarBtn")).click();
  }
  obtenerMensajeDialogo(){
    return element(by.xpath("//p[@id='dialogMensaje']")).getText();
  }
  
}
