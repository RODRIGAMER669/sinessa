# Manual de usuario

## Requisitos

- Java 17 instalado.
- Navegador web para usar el formulario, o un cliente HTTP como `curl`.

## Iniciar la aplicación

Desde la carpeta raíz del proyecto:

```bash
./mvnw spring-boot:run
```

En Windows:

```bat
mvnw.cmd spring-boot:run
```

Cuando Spring indique que el servidor está iniciado, abre `http://localhost:8080`. El proyecto incluye tres películas de ejemplo. Las operaciones se guardan en memoria y se reinician al parar y volver a iniciar la aplicación.

## Crear una película desde el formulario

1. Abre `http://localhost:8080/formularioPelicula.html`.
2. Introduce título, detalles, sinopsis, género, duración positiva y fecha de estreno. La imagen es opcional, pero, si se proporciona, debe ser una URL válida.
3. Pulsa **Añadir película**.
4. Si los datos son correctos, aparece una página con la película registrada. Si hay errores, la aplicación muestra una lista de validaciones.

El servidor espera la fecha con formato `dd/MM/yyyy`, pero el control HTML `type="date"` envía normalmente el valor como `yyyy-MM-dd`. Por esa diferencia, el alta desde el formulario puede fallar al vincular la fecha. Para registrar una película ahora, envía la fecha como `dd/MM/yyyy` mediante un cliente HTTP; el formulario necesita adaptarse para convertir el formato.

## Consultar el catálogo

Abre `http://localhost:8080/peliculas` o ejecuta:

```bash
curl http://localhost:8080/peliculas
```

La respuesta es un array JSON con los datos de cada película.

## Editar una película

Envía un `PUT` con JSON a `/peliculas/{id}`. La implementación actual modifica imagen, sinopsis y duración:

```bash
curl -X PUT http://localhost:8080/peliculas/1 \
  -H 'Content-Type: application/json' \
  -d '{"imagen":"https://example.com/pelicula.png","sinopsis":"Nueva sinopsis","duracion":120}'
```

La respuesta contiene la película modificada en JSON.

## Eliminar una película

```bash
curl -i -X DELETE http://localhost:8080/peliculas/1
```

Una eliminación correcta responde con HTTP 204. Los ids iniciales son 1, 2 y 3; las altas nuevas reciben ids posteriores.

## Ayuda técnica

Consulta [API y ejemplos](api.md) para formatos y rutas, y [Ejecución y desarrollo](desarrollo.md) para compilar y empaquetar.
