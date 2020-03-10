# Directorio Telefónico
### Front End App

Administración de contactos telefónicos.

## Características
* ***Arquitectura feature-core-shared***
* ***Lazy loading***
* Erroes centralizados
* Responsive
* Angular material en español

### Configuracion
para configurar el repositorio de ceiba como registry de node ejecutar el siguiente comando

```npm config set @ceiba:registry=https://binary.ceiba.com.co/repository/temp-npm/```

## Tecnologías

***Dependencias:*** [Npm] (https://nodejs.org/es/)

***Frameworks:*** Angular v8.1.3 --- Angular material

## Authors

*   **Santiago Felipe Cerón Araujo** - [LinkedIn](https://www.linkedin.com/in/santiago-ceron-araujo)


#### más: Estructura del proyecto

Los archivos de la aplicación se encuentran en la subcarpeta src. Las pruebas iniciales correspondientes de extremo a extremo se encuentran en la subcarpeta e2e.

El proyecto base está estructurado en los módulos feature, shared y core. Asegurando una separación adecuada de las preocupaciones, lo que facilitará la escalabilidad a medida que su aplicación crezca. Lo siguiente describe brevemente cada tipo de módulo.

##### Módulo core
Deben estar lo transversal y de una sola instancia en la aplicación. Por ejemplo: NavBar o interceptor.

##### Módulo feature
Deben estar los componentes que implementan funcionalidades especificas de la aplicación. Por ejemplo, el componente datos de contacto el cual es el componente que implementa la feature de contacto. Es posible tener compartidos dentro de esta feature.

##### Módulo shared
Deben estar componentes o utilidades comunes a las diferentes feature. Por ejemplo, un componente de un botón azul que usted desea repetir en varios lugares. Un filtro para ser utilizado en todos los componentes.

