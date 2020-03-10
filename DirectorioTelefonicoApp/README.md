# Directorio Telefónico
### Front End Web App

Administración de contactos telefónicos.

### Características
* ***Arquitectura feature-core-shared***
* ***Lazy loading***
* Erroes centralizados (mediante interceptors)
* Responsive
* Angular material en español
* Proxy reverso para evitar Cross Origin (protección AJAX)
* Patrón Page Object en Test

### Configuracion
El repositorio tiene una dependencia de Ceiba Software, para usarla ejecutar
```npm config set @ceiba:registry=https://binary.ceiba.com.co/repository/temp-npm/```
luego se puede ejecutar normalmente
```npm install``

### Ejecución
Lanzar servidor local 
```ng serve```
Ejecutar pruebas
```ng e2e```

### Nota
Por optimización el campo ***TELEFFONO*** es del tipo int en el API, para correcto funcionamiento usar máximo un número con 9 dígitos,
se cumple la regla del negocio que es validar que máximo son 7.

### Tecnologías

***Dependencias:*** [Npm] (https://nodejs.org/es/)

***Frameworks:*** Angular v8.1.3 --- Angular material

### Más --> Estructura del proyecto

Los archivos de la aplicación se encuentran en la subcarpeta src. Las pruebas iniciales correspondientes de extremo a extremo se encuentran en la subcarpeta e2e.

El proyecto base está estructurado en los módulos feature, shared y core. Asegurando una separación adecuada de las preocupaciones, lo que facilitará la escalabilidad a medida que su aplicación crezca. Lo siguiente describe brevemente cada tipo de módulo.

##### Módulo core
Deben estar lo transversal y de una sola instancia en la aplicación. Por ejemplo: NavBar o interceptor.

##### Módulo feature
Deben estar los componentes que implementan funcionalidades especificas de la aplicación. Por ejemplo, el componente datos de contacto el cual es el componente que implementa la feature de contacto. Es posible tener compartidos dentro de esta feature.

##### Módulo shared
Deben estar componentes o utilidades comunes a las diferentes feature. Por ejemplo, un componente de un botón azul que usted desea repetir en varios lugares. Un filtro para ser utilizado en todos los componentes.


### Authors

*   **Santiago Felipe Cerón Araujo** - [LinkedIn](https://www.linkedin.com/in/santiago-ceron-araujo)


