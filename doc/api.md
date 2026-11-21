# API de Sinessa

La aplicación se está ejecutando en `http://localhost:8080`.

| Método | Ruta | Resultado |
| --- | --- | --- |
| `GET` | `/peliculas` | Lista las peliculas en JSON. |
| `POST` | `/peliculas` | Crea una pelicula desde datos de formulario, validando los campos y devuelve la pelicula creada en JSON. |
| `PUT` | `/peliculas/{id}` | Actualiza una pelicula y devuelve el recurso en JSON. |
| `DELETE` | `/peliculas/{id}` | Elimina la pelicula |

## Listar

```bash
curl http://localhost:8080/peliculas
```

La respuesta contiene objetos con `id`, `titulo`, `imagen`, `detalles`, `sinopsis`, `genero`, `duracion`, `fechaEstreno` y `createdAt`.

## Crear

El controlador recibe `PeliculaRequest` como parámetro de formulario:

```bash
curl -X POST http://localhost:8080/peliculas \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'titulo=Alien' \
  --data-urlencode 'imagen=https://example.com/alien.png' \
  --data-urlencode 'detalles=Dirigida por Ridley Scott' \
  --data-urlencode 'sinopsis=En el espacio nadie puede oír tus gritos' \
  --data-urlencode 'genero=Terror' \
  --data-urlencode 'duracion=117' \
  --data-urlencode 'fechaEstreno=1979-05-25'
```

También está disponible el formulario del navegador en `http://localhost:8080/formularioPelicula.html`.

## Editar

El cuerpo del `PUT` es JSON. Envía los campos de la película:

```bash
curl -X PUT http://localhost:8080/peliculas/1 \
  -H 'Content-Type: application/json' \
  -d '{"imagen":"https://example.com/alien-nuevo.png","sinopsis":"Nueva sinopsis","duracion":120}'
```

## Eliminar

```bash
curl -i -X DELETE http://localhost:8080/peliculas/1
```

Los identificadores `1`, `2` y `3` se precargan en el repositorio mock.

## Validaciones de entrada

- `titulo`: no puede estar vacío.
- `imagen`: es opcional; si se indica, debe ser una URL válida (`http(s)://dominio.ext`).
- `detalles`: no puede estar vacío.
- `sinopsis`: no puede estar vacía.
- `genero`: no puede estar vacío.
- `duracion`: es obligatoria y debe ser mayor que 0.
- `fechaEstreno`: es obligatoria y se envía con formato `dd/MM/yyyy`.

Las validaciones se aplican en el endpoint de creación mediante `@Valid`.