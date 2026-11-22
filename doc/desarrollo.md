# Ejecución y desarrollo

## Arranque local

Desde la raíz del repositorio:

```bash
./mvnw spring-boot:run
```

En Windows:

```bat
mvnw.cmd spring-boot:run
```

La aplicación se inicia en `http://localhost:8080` con la configuración actual.

## Entorno de desarrollo

| Aspecto | Herramienta |
| --- | --- |
| Gestión de versiones | Git y Github, y la rama `feature/pelicula`] |
| Proyecto | Maven (`pom.xml`), con Maven Wrapper (`mvnw` y `mvnw.cmd`) |
| Compilación | `./mvnw package`, con procesamiento de anotaciones de Lombok y MapStruct |
| Lenguaje | Java 17 |
| Framework | Spring Boot con Spring MVC |
| Librerías | Lombok, MapStruct y Jakarta Bean Validation |
| Pruebas | JUnit con Spring Boot Test |
| Documentación | Archivos Markdown en `doc/`, con diagramas Mermaid |
| IDE | Visual Studio Code |

## Versiones de las herramientas

| Herramienta | Versión |
| --- | --- |
| Java (JDK) | 17 |
| Spring Boot | 4.1.1 |
| Maven (con el Wrapper) | 3.10.0 |
| MapStruct | 1.6.3 |
| Lombok | 1.18.32 |
| lombok-mapstruct-binding | 0.2.0 |

## Implantación

La aplicación se empaqueta como un único archivo ejecutable, con el servidor web embebido, así que no hace falta instalar ningún servidor aparte. No usa base de datos, por lo que no requiere más configuración.

1. Generar el paquete: `./mvnw package`.
2. Ejecutarlo: `java -jar target/sinessa-0.0.1-SNAPSHOT.jar`.
3. Acceder en `http://localhost:8080`.

Como los datos se guardan en memoria, cada arranque vuelve a empezar con las tres películas iniciales.


