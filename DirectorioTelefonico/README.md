# Directorio telefónico
### Back End Java Api

Administración de contactos telefónicos.

### Características
* ***Arquitectura Hexagonal***
* ***JDBC template con auto generación del esquema***

* Erroes centralizados con envío via rest con estándar
* Test automatizados con patrón: AAA , TestDataBuilder
* Rest buenas prácticas
* Data binding en SQL
* Reglas de negocio => 
*tamaño numero = 7 digitos , nombre = 100 caracteres*
*no se puede ingresar 5555555(7 size)*
*no contactos con nombre repetido*

### Nota
Por optimización el campo ***TELEFFONO*** es del tipo int en el API, para correcto funcionamiento usar máximo un número con 9 dígitos,
se cumple la regla del negocio que es validar que máximo son 7. (se podría cambiar int por double en el comando)

### Ejecución
En la ejecución local tiene activado devTools para live reload. se recomienda ejecutar desde Eclipse, Spring Tool Suite o Intellij.

Ejecutar pruebas
```gradle test```

## Tecnologías

***Base de datos:*** MySQL v8.0 - H2

***Dependencias:*** Gradle V6.2 

***Frameworks:*** Spring Boot v2.2.1.RELEASE

***Documentación:*** Swagger v 2.7

## Authors

*   **Santiago Felipe Cerón Araujo** - [LinkedIn](https://www.linkedin.com/in/santiago-ceron-araujo)
