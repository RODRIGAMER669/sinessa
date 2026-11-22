# Contexto de la aplicación

## Problema del mundo real

Un cine, cineclub o equipo que prepara una cartelera necesita mantener los datos de sus películas en un lugar común. Si cada interfaz conserva una copia propia, corregir títulos, fechas o sinopsis exige actualizar varios sitios y puede producir información distinta. Sinessa explora una solución pequeña: una API web que centraliza las operaciones básicas de un catálogo.

## Aplicaciones relacionadas

IMDb, FilmAffinity y Letterboxd permiten consultar información cinematográfica y, según el servicio, valorarla o crear listas. Sinessa tiene otro alcance: es un prototipo de administración de un catálogo propio mediante operaciones CRUD. No pretende competir en cobertura, comunidad ni cantidad de información con esos servicios; permite estudiar una API de gestión sencilla y ampliable.

## Aportación y alcance

La aplicación permite crear, consultar, modificar y eliminar películas. Separar el dominio de la web y del almacenamiento facilita sustituir el repositorio en memoria por una base de datos en una evolución posterior. Incluye un formulario HTML para el alta, aunque su campo de fecha no coincide actualmente con el formato que espera el servidor; las operaciones también se pueden consumir mediante HTTP.

El alcance actual es académico y local. No hay autenticación, roles, persistencia duradera ni interfaz completa de gestión. Los datos iniciales y los cambios se mantienen solo mientras está activo el proceso.

## Actores y casos de uso

El actor principal es el **gestor del catálogo**, una persona o cliente externo que realiza peticiones HTTP. La aplicación no modela usuarios ni exige iniciar sesión (de momento).

| Caso de uso | Descripción | Operación |
| --- | --- | --- |
| Consultar catálogo | Obtener todas las películas disponibles. | `GET /peliculas` |
| Registrar película | Enviar los campos de una película; se validan y se añade al catálogo. | `POST /peliculas` |
| Modificar película | Actualizar los campos admitidos de una película identificada por id. | `PUT /peliculas/{id}` |
| Retirar película | Eliminar una película identificada por id. | `DELETE /peliculas/{id}` |

## Requisitos funcionales

1. El sistema permite consultar el catálogo completo.
2. El sistema permite registrar una película con título, imagen opcional, detalles, sinopsis, género, duración y fecha de estreno.
3. El sistema valida los datos del alta: los campos de texto obligatorios no pueden estar vacíos; la duración debe ser positiva; la fecha debe poder convertirse a `LocalDate` con el formato de formulario `dd/MM/yyyy`; y la imagen, si se indica, debe ser una URL válida.
4. El sistema permite modificar una película existente. En la implementación actual, la edición modifica imagen, sinopsis y duración.
5. El sistema permite eliminar una película existente.
6. Cada película expone un identificador y una fecha de creación asignados por la aplicación.

## Requisitos no funcionales y restricciones

1. La aplicación se ejecuta sobre Java 17 y Spring Boot, con servidor web embebido.
2. La API usa HTTP y JSON para consultas/ediciones; el alta acepta parámetros de formulario y responde con HTML.
3. La arquitectura separa dominio, aplicación e infraestructura para reducir dependencias entre reglas de negocio y tecnología.
4. El repositorio es un mock en memoria: al reiniciar se recuperan las tres películas de ejemplo y se pierden los cambios.
5. No se requiere autenticación en esta versión.
6. Una búsqueda o modificación de un identificador inexistente no tiene todavía una respuesta 404 propia; el tratamiento depende de Spring y constituye una mejora pendiente.

Para rutas, ejemplos y formatos, véase [API y ejemplos](api.md).
