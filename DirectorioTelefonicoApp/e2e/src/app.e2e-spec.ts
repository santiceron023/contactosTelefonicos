import { AppPage } from "./app.po";
import { browser } from "protractor";

describe("workspace-project App", () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it("crear un contacto", () => {
    page.navegarVerContactos();
    browser.sleep(2000);

    page.seleccionarBotonAgregarContacto();
    browser.sleep(3000);

    page.crearContacto();
    browser.sleep(3000);

    expect(page.obtenerMensajeDialogo()).toEqual(
      "Creación éxitosa"
    );
  });

});
