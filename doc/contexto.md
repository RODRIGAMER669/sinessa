# Contexto de la aplicación


## Problema a resolver

Una web de películas, ya sea la de un cine, un cineclub o un catálogo en línea, necesita tener su listado de películas centralizado y accesible desde un servicio, para que cualquier interfaz (una web, una app móvil u otro sistema) pueda consultarlo y modificarlo. Sin un servicio así, cada interfaz tendría su propia copia de los datos y habría que mantenerlas por separado


## Aplicaciones que existen

Existen aplicaciones muy conocidas como FilmAffinity, IMDb o Letterboxd. Están pensadas para que el público consulte, puntúe y comente películas, no para que administre un catalogo propio.

## Qué aporta Sinessa

Sinessa ofrece ese servicio de forma sencilla y centrada en lo esencial: dar de alta una película con sus datos validados, consultar el listado, corregir sus datos y retirarla cuando deja de estar en cartel. 

## Casos de uso

El actor de todos los casos de uso es el usuario que gestiona las películas.

1. **Crear película:** el usuario envía los datos de una película y la aplicación la valida y la guarda.
2. **Listar películas:** el usuario consulta el listado completo.
3. **Editar película:** el usuario modifica los datos de una película existente.
4. **Eliminar película:** el usuario retira una película del catálogo.

Si quieres más informacion sobre los casos de uso puedes consultar en [API y ejemplos](/doc/api.md).

## Requisitos

### Funcionales

1. El usuario puede dar de alta una película con título, imagen, detalles, sinopsis, género, duración y fecha de estreno.
2. El usuario puede consultar el listado de todas las películas.
3. El usuario puede modificar los datos de una película existente.
4. El usuario puede eliminar una película.

### No funcionales

1. Una película debe tener título, detalles, sinopsis y género no vacíos, una duración mayor que 0 y una fecha de estreno con formato `dd/MM/yyyy`.
2. Los datos se guardan en memoria, por lo que no persisten al reiniciar.
