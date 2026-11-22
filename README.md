# sinessa

**Versión:** 0.0.1-SNAPSHOT

## ¿Qué es este proyecto?

Sinessa es una aplicación web desarrollada con Spring Boot que permite dar de alta películas, consultar el catálogo, modificar algunos datos y retirar películas.

Se ha construido con **Vertical Slicing** y **arquitectura Clean**, aplicando **inversión de control** e **inyección de dependencias** para reducir el acoplamiento entre componentes y facilitar el mantenimiento y la evolución del proyecto.

## Empezar

Requisitos: Java 17. El repositorio incluye Maven Wrapper.

```bash
./mvnw spring-boot:run
```

En Windows:

```bat
mvnw.cmd spring-boot:run
```

La aplicación usa el puerto 8080 por defecto. El formulario estático para crear una película está en `/formularioPelicula.html`.

## Documentación detallada

- [Arquitectura y estructura del código](doc/arquitectura.md): capas, paquetes y flujo de una petición.
- [API y ejemplos](doc/api.md): rutas, formatos de entrada, validaciones y comandos `curl`.
- [Ejecución y desarrollo](doc/desarrollo.md): requisitos, comandos Maven Wrapper y notas para contribuir.
- [Contexto](doc/contexto.md).
- [Diseño](doc/diseño.md).
- [Manual de usuario](doc/manual-usuario.md)

## Tecnologías principales

- Java 17
- Spring Boot 4.1.1
- Spring MVC
- Maven
- Lombok
- MapStruct
- Jakarta Bean Validation

## Integrantes

- Manuel Pavón.
- Aitor Rebato.
- Víctor Sánchez.
- Alexis Rodríguez.
