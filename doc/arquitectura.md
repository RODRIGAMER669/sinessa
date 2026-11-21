# Arquitectura y estructura

# Arquitectura y estructura

Sinessa está construido con Spring Boot y una arquitectura Clean organizada por dominio. Con ella, las reglas de negocio quedan separadas de los detalles web y de almacenamiento.

El código se divide en tres capas: dominio, aplicación e infraestructura. Las dependencias van siempre hacia dentro: la infraestructura conoce a la aplicación y al dominio, pero el dominio no sabe nada de HTTP ni de cómo se guardan los datos. Esto evita que un cambio en la interfaz obligue a tocar las reglas del negocio, y al revés.

Las capas se conectan mediante la inyección de dependencias de Spring: ninguna clase crea sus dependencias, las recibe del contenedor y depende de un contrato (como `PeliculaRepository`), no de su implementación.

Esta combinación nos aporta:

- **Cambios acotados:** sustituir el repositorio mock por una base de datos real solo afecta a infraestructura.
- **Mantenimiento sencillo:** cada clase tiene una única responsabilidad, con un caso de uso por operación.
- **Código desacoplado y fácil de probar:** la lógica se puede probar sin levantar la parte web.
- **Escalabilidad:** añadir una nueva funcionalidad es repetir la misma estructura sin afectar a lo existente.

## Capas

## Capas

## Capas

### Dominio (`pelicula/domain`)

Es el núcleo de la aplicación y no depende de ninguna otra capa. Contiene el modelo `Pelicula`, con sus datos (título, imagen, detalles, sinopsis, género, duración y fechas de estreno y creación), y los contratos de repositorio (`CRUDRepository` y `PeliculaRepository`). Estos contratos solo definen qué operaciones existen, como crear, listar, buscar o eliminar, y dejan a la infraestructura decidir cómo se guardan los datos.

### Aplicación (`pelicula/application`)

Contiene la lógica de cada operación: **crear**, **listar**, **editar** y **eliminar** películas. Cada operación tiene su caso de uso, que usa los contratos del dominio sin saber cómo se guardan los datos. Los **servicios** son el punto de entrada que usa el controlador, y los **comandos** son los objetos que le llevan los datos de la petición. Los casos de uso no dependen de Spring: se registran como beans en `PeliculaConfig`, en infraestructura.

### Infraestructura (`pelicula/infraestructure`)

Contiene los detalles técnicos que rodean al núcleo de la aplicación. En la parte web están el controlador `PeliculaController`, los DTO de entrada y salida con sus validaciones, el mapper `PeliculaMapper` y la configuración `PeliculaConfig`, que registra los casos de uso y servicios como beans de Spring. En la parte de datos está el repositorio mock `PeliculaRepositoryMockImpl`, que implementa el contrato del dominio guardando las películas en memoria. El tratamiento de errores común está en `common/infraestructure/web/error`.

## Flujo de una petición

En una operación HTTP, `PeliculaController` recibe la petición, convierte los datos de transporte con `PeliculaMapper` y llama al servicio de aplicación correspondiente. El servicio ejecuta el caso de uso y trabaja con el repositorio definido por el dominio; el adaptador mock resuelve la operación sobre un mapa en memoria.

## Flujo de una petición

En una operación HTTP, `PeliculaController` recibe la petición y valida los datos de entrada (si no son válidos, responde con un error 400). Después, `PeliculaMapper` los convierte en un comando y el controlador llama al servicio correspondiente, que delega en su caso de uso. El caso de uso aplica la lógica y trabaja con el contrato `PeliculaRepository` del dominio; en este proyecto lo resuelve `PeliculaRepositoryMockImpl` con un mapa en memoria. una vez obtenida la pelicula se devuelve y el mapper la convierte en `PeliculaResponse` para la respuesta.

## Persistencia y datos iniciales

`PeliculaRepositoryMockImpl` mantiene los datos en memoria y `PeliculaFactory` crea tres registros al iniciar. No hay una base de datos configurada, por lo que los cambios no sobreviven al reinicio.



## Otras rutas relevantes

- `src/main/resources/static/`: formulario HTML estático.
- `src/main/resources/application.properties`: configuración de Spring.
- `src/main/resources/messages.properties`: mensajes de validación.