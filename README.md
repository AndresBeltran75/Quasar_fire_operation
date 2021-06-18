# Challenge Quasar Fire Operation
Esté challenge se desarrollo en lenguaje de programación Java, implementando arquitectura orientada a microservicios para lo cual se hizo uso del framework ***Spring Boot***, se implemento ***Swagger*** para realizar la documentación de los servicios expuestos por el Api, tambien se implemento ***JWT*** para la autenticación al realizar peticiones, a su vez se emplemento un pequeño FrontEnd en ***Angular*** el cual permite generar el token de forma más sencilla.

La Api se encuentra expuesta en Heroku y hace uso de una base de datos Postgres la cual se encarga de almacenar los usuarios para generar el token de autenticación.

# Herramientas necesarias para hacer uso del Api
* **Extensión Google Chrome ModHeader**: https://chrome.google.com/webstore/detail/modheader/idgpnmonknjnojddfkpgkljpfnnfcklj?hl=es
* **Postman**

# Uso del Api

## Generar Token
La generación del token para realizar peticiones de forma segura se puede hacer de dos maneras:

1. Se ingresa a la siguiente ***URL:*** https://quasar-operation-front.herokuapp.com/, se llena el formulario el cual consta de nombre de usuario y contraseña; para está prueba puede utilizar los siguientes datos:

```
    Nombre Usuario:  QuasarOperation*
    Contraseña    :  MELI86263"
```

* obtendrá el token para realizar las peticiones deseadas.

2. Desde postman realizar una petición ***POST*** indicando el siguiente endpoint el cual se encarga de generar el token para un usuario determinado:
https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/auth/authenticate
* En las sección body de Postman utilice la siguiente estructura Json para realizar la petición:
```
{
    "password": "QuasarOperation*",
    "username": "MELI86263"
}
```


* Al dar click en *Send* deberá obtener una respuesta similar a la siguiente:
```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNRUxJODYyNjMiLCJpYXQiOjE2MjM4ODY2OTgsImV4cCI6MTYyMzg4Njk5OH0.gCXafJEqhoxgyxCW05hAU-mqzQIM1LqySqaB3b_HyLw"
}
```

* Seleccione el contenido que acompaña la etiqueta token sin las comillas y utilicelo en las peticiones que desee realizar. Este token tiene un tiempo de duración de 30 minutos. Tomando como ejemplo el token anterior, lo seleccionado se debe ver de la siguiente manera:
```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNRUxJODYyNjMiLCJpYXQiOjE2MjM4ODY2OTgsImV4cCI6MTYyMzg4Njk5OH0.gCXafJEqhoxgyxCW05hAU-mqzQIM1LqySqaB3b_HyLw
```

## EndPoint de consumo
Los endpoint para consumir las utilidades del Api desde Postman son:
* https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/topsecret/status ***(GET)***
  
  - En la sección ***Authorization*** de Postman, seleccione la opción ***Bearer Token***, a continuación asignele el valor del token generado anteriormente.
  
  - La respuesta al realizar está petición debe ser la siguiente:
    
    - ```
        OK
      ```
      
    - La cual indica que el servicio se encuentra disponible.
* https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/topsecret ***(POST)***
    - En la sección ***Authorization*** de Postman, seleccione la opción ***Bearer Token***, a continuación asignele el valor del token generado anteriormente.
    - La estructura de la petición debe ser similar a la siguiente:
    
      ```
        {
          "satellites": [
            {
                 "distance": 100.9,
                 "message": [
                 "Hola", "", ""
                            ],
                 "name": "sato"
            },
            {
                 "distance": 10.9,
                 "message": [
                 "", "mundo", ""
                            ],
                 "name": "kenoby"
            },
            {
                 "distance": 87.9,
                 "message": [
                 "", "", "llegue!"
                            ],
                 "name": "skywalker"
            }
          ]
        }
      ```
      
    - La respuesta de está petición debe ser similar a la siguiente:
    
    ```
      {
          "position": {
              "x": -487.0,
              "y": 1575.0
          },
          "message": "Hola mundo llegue!"
      }
      
    ```
    
* https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/topsecret_split/status ***(GET)***
  
  - En la sección ***Authorization*** de Postman, seleccione la opción ***Bearer Token***, a continuación asignele el valor del token generado anteriormente.
  
  - La respuesta al realizar está petición debe ser la siguiente:
    
    - ```
        OK
      ```
      
    - La cual indica que el servicio se encuentra disponible.
    
* https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/topsecret_split/ ***(GET)***
    
    - En la sección ***Authorization*** de Postman, seleccione la opción ***Bearer Token***, a continuación asignele el valor del token generado anteriormente.
    
    - La respuesta de la petición debe ser similar a la siguiente:
    
      - ```
          {
              "position": {
                  "x": -487.0,
                  "y": 1575.0
              },
              "message": "No se encontro información suficiente para determinar el mensaje"
          }
        ```
        
* https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/topsecret_split/ ***(POST)***
  
  - En la sección ***Authorization*** de Postman, seleccione la opción ***Bearer Token***, a continuación asignele el valor del token generado anteriormente.
  
  - La estructura de la petición debe ser similar a la siguiente:
    
     - ```
            {
              "distance": 34.0,
              "message": [
                "Hola", "", "", "", "soy"
              ],
              "name": "sato"
            }
       ```
  - La respuesta de la petición debe ser similar a la siguiente:
    
      - ```
          {
              "position": {
                  "x": 500.0,
                  "y": 100.0
              },
              "message": "Hola soy"
          }
        ```
       
* https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/topsecret_split/{satellite_name} ***(POST)***
  
  - En la sección ***Authorization*** de Postman, seleccione la opción ***Bearer Token***, a continuación asignele el valor del token generado anteriormente.
  
  - Cambie el gragmento ***{satellite_name}***, por el nombre de alguno de los satelites los cuales son:
    
    - ***kenobi***
    
    - ***skywalker***
    
    - ***sato***
  
  - La estructura de la petición debe ser similar a la siguiente:
    
     - ```
          {
            "distance": 20.9,
            "message": [
              "Hola", "", "", "heroku"
            ]
          }
       ```
  - La respuesta de la petición debe ser similar a la siguiente:
    
      - ```
          {
              "position": {
                  "x": 500.0,
                  "y": 100.0
              },
              "message": "Hola heroku"
          }
        ```
        
 ## Swagger

* El endpoint para ver la documentación de Swagger es: https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/swagger-ui.html

* Para poder visualizar la domunetación es necesario hacer uso de la extensión de chrome ***ModHeader*** instalada al inicio en la cual se asignaran los siguinetes valores:
  
  - Authorization
  
  - Bearer {nuestro_token}
  
  - Se debe reemplazar ***{nuestro_token}*** por nuestro token, lo cual se debería ver de la siguiente manera:
    
    -  ```
         Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNRUxJODYyNjMiLCJpYXQiOjE2MjM4ODY2OTgsImV4cCI6MTYyMzg4Njk5OH0.gCXafJEqhoxgyxCW05hAU-mqzQIM1LqySqaB3b_HyLw
       ```
       
 * Ahora se puede refrescar la página, pudiendo visualizar la documentación del Api.

# Ejecutar código de manera local

* Se debe clonar el código fuente, de la siguiente manera:

    ```
        git clone https://github.com/AndresBeltran75/Quasar_fire_operation.git
    ```
* Se importa el proyecto en su ***IDE*** de preferencia.

* En su ***IDE*** de preferencia, de click derecho sobre el proyecto recientemente importado, diríjase a Maven/Update Project... 

* Esto actualizara las dependencias del proyecto, para su correcto funcionamiento.

# Observaciones

* Luego de que evidencie el funcionamiento del Api, acceda a la extensión ***ModHeader*** de Google Chrome y desactive el check que aparece en color verde, para que no tenga problemas al momento de usar el navegador como lo hace normalmente.



