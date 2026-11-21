# sinessa

## ¿Qué es este proyecto?

Sinessa es una aplicación web desarrollada con Spring Boot que actualmente permite dar de alta nuevas películas, consultar el listado completo, corregir sus datos y retirarlas cuando dejan de estar en cartel

Se ha construido con **Vertical Slicing** y **arquitectura Clean**, aplicando inversión e **inyección de dependencias** para reducir el acoplamiento entre componentes y facilitar el mantenimiento y la evolución del proyecto.

## Empezar

Requisitos: Java 17. El repositorio incluye Maven Wrapper.

```bash
./mvnw spring-boot:run
```

En Windows:

```bat
mvnw.cmd spring-boot:run
```

La aplicación usa el puerto 8080 por defecto. El formulario estático para crear una película está en `/formularioPelicula.html`

## Documentación detallada

- [Arquitectura y estructura del código](doc/arquitectura.md): capas, paquetes y flujo de una petición.
- [API y ejemplos](doc/api.md): rutas, formatos de entrada, validaciones y comandos `curl`.
- [Ejecución y desarrollo](doc/desarrollo.md): requisitos, comandos Maven Wrapper y notas para contribuir.

## Tecnologías principales

- Java 17
- Spring Boot 4.1.1
- Spring MVC
- Maven
- Lombok
- MapStruct
- Jakarta Bean Validation