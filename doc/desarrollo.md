# Desarrollo e implantación

## Identificación

| Campo | Valor |
| --- | --- |
| Aplicación | Sinessa, catálogo web de películas |
| Versión | 0.0.1-SNAPSHOT |
| Lenguaje | Java 17 |
| Integrantes | Manuel Pavón, Aitor Rebato, Víctor Sánchez y Alexis Rodríguez |

## Entorno de desarrollo

| Aspecto | Herramienta o configuración |
| --- | --- |
| Control de versiones | Git; el proyecto incluye Maven Wrapper |
| Gestión y compilación | Maven (`pom.xml`) |
| Framework web | Spring Boot y Spring MVC |
| Validación | Jakarta Bean Validation |
| Mapeo | MapStruct |
| Reducción de código repetitivo | Lombok |
| Pruebas | Spring Boot Test; existe una clase de prueba de contexto |
| Documentación | Markdown en `doc/` y `README.md` |
| Interfaz de ejemplo | HTML estático servido desde `src/main/resources/static` |

## Versiones declaradas

| Herramienta o librería | Versión configurada |
| --- | --- |
| Java | 17 |
| Spring Boot | 4.1.1 |
| Maven Wrapper | 3.3.4 |
| Distribución Maven solicitada por el wrapper | 3.10.0 |
| MapStruct | 1.6.3 |
| Lombok | 1.18.32 |
| lombok-mapstruct-binding | 0.2.0 |

Las versiones anteriores se leen de `pom.xml` y `.mvn/wrapper/maven-wrapper.properties`; son las declaradas por el proyecto, no una comprobación del entorno instalado.

## Comandos habituales

Iniciar en modo desarrollo:

```bash
./mvnw spring-boot:run
```

Compilar y ejecutar las pruebas configuradas:

```bash
./mvnw verify
```

Crear el paquete ejecutable:

```bash
./mvnw package
```

## Implantación

El plugin de Spring Boot empaqueta la aplicación en un JAR ejecutable con servidor web embebido. En un entorno con Java 17:

```bash
java -jar target/sinessa-0.0.1-SNAPSHOT.jar
```

El puerto predeterminado es 8080. No se configura una base de datos ni almacenamiento externo. El repositorio mock vuelve a crear los datos de muestra al iniciar el proceso, así que esta versión no debe tratarse como un servicio de producción con datos persistentes.

## Organización del trabajo y mejoras

El código está organizado por funcionalidad y capas. Entre las mejoras razonables están incorporar persistencia, documentar el flujo de trabajo Git utilizado por el equipo, automatizar pruebas de los casos de uso y la API, y definir respuestas de error uniformes.
