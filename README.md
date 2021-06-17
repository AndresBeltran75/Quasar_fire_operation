# Challenge Quasar Fire Operation
Esté challenge se desarrollo en lenguaje de programación Java, implementando arquitectura orientada a microservicios para lo cual se hizo uso del framework ***Spring Boot***, tambien se implemento ***Swagger*** para realizar la documentación de los servicios expuestos por el Api, a su vez se implemento ***JWT*** para la autenticación al realizar peticiones.

La Api se encuentra expuesta en Heroku y hace uso de una base de datos Postgres la cual se encarga de almacenar los usuarios para generar el token de autenticación.

# Herramientas necesarias para hacer uso del Api
* **Extensión Google Chrome ModHeader**: https://chrome.google.com/webstore/detail/modheader/idgpnmonknjnojddfkpgkljpfnnfcklj?hl=es
* **Postman**

# Uso del Api

* Desde postman realizar una petición ***POST*** indicando el siguiente endpoint el cual se encarga de generar el token para un usuario determinado:
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

* Seleccione el contenido que acompaña la etiqueta token sin las comillas y utilicelo en las peticiones que desee realizar. Este token tiene un tiempo de duración de 5 minutos. Tomando como ejemplo el token anterior, lo seleccionado se debe ver de la siguiente manera:
```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNRUxJODYyNjMiLCJpYXQiOjE2MjM4ODY2OTgsImV4cCI6MTYyMzg4Njk5OH0.gCXafJEqhoxgyxCW05hAU-mqzQIM1LqySqaB3b_HyLw
```
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
        
 # Swagger

* El endpoint para ver la documentación de Swagger es: https://quasar-operation-fire-meli.herokuapp.com/quasar-operation/api/swagger-ui.html

* Para poder visualizar la domunetación es necesario hacer uso de la extensión de chrome ***ModHeader*** instalada al inicio en la cual se asignaran los siguinetes valores:
  
  - Authorization
  
  - Bearer {nuestro_token}
  
  - Se debe reemplazar ***{nuestro_token}*** por nuestro token, lo cual se debería ver de la siguiente manera:
    
    -  ```
         Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNRUxJODYyNjMiLCJpYXQiOjE2MjM4ODY2OTgsImV4cCI6MTYyMzg4Njk5OH0.gCXafJEqhoxgyxCW05hAU-mqzQIM1LqySqaB3b_HyLw
       ```
       
 * Ahora se puede refrescar la página, pudiendo visualizar la documentación del Api.




