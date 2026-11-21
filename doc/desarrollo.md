# Ejecución y desarrollo

## Requisitos

- JDK 17.
- Maven Wrapper incluido (`mvnw` para Linux/macOS y `mvnw.cmd` para Windows).

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

## Compilar y ejecutar pruebas

```bash
./mvnw test
```

Para empaquetar el proyecto:

```bash
./mvnw package
```

Usa `mvnw.cmd` en lugar de `./mvnw` en Windows.
