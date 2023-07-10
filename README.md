<h1 align="center">
    <img src="https://github.com/GermoAlt/ScreenSpace-back/blob/main/images/svg/logo-no-background.svg?raw=true" width="60%"/>
</h1>


<p align="center">
  <a href="#descripcion">Descripción</a> •
  <a href="#información-general">Información general</a> •
  <a href="#instrucciones">Instrucciones</a> •
  <a href="#contexto-académico">Contexto académico</a> •
  <a href="#equipo-de-trabajo">Equipo de trabajo</a>
</p>

## Descripción
**ScreenSpace** es una aplicación mobile para la gestión de salas de cine. Se divide en una parte frontend y otra backend.
* Este README corresponde al backend, el correspondiente al frontend se puede encontrar [acá](https://github.com/GermoAlt/ScreenSpace-app/blob/main/README.md).

## Información general
* El backend de **ScreenSpace** está desarrollado con API REST Java con Spring boot.


## Instrucciones

Para clonar y ejecutar esta aplicación, necesitará [Git](https://git-scm.com), [Java 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html) y [Apache Maven](https://maven.apache.org/install.html) instalados en su computadora.

```bash
# Clone this repository
$ git clone https://github.com/GermoAlt/ScreenSpace-back.git

# Install dependencies
$ mvn clean
$ mvn install

```


### Base de datos
Para la persistencia de datos se utiliza [MongoDB](https://www.mongodb.com/es) con integración de Spring Data MongoDB.
* La conexión de MongoDB se encuentra en al archivo applicaction.properties:
```jsx
spring.data.mongodb.uri=mongodb+srv://${MONGO_USERNAME}:${MONGO_PASSWORD}@${MONGO_HOST}.mongodb.net/$${MONGO_DATABASE}
spring.data.mongodb.database=${MONGO_DATABASE}
```

## Contexto académico
* Profesores:
  - Christian Mazzeo
  - Joaquín Timerman


## Equipo de trabajo
* Desarrollo de aplicaciones 1
* Grupo #


<table>
  <tr>
    <td align="center"><sub><b>German Altairac</b></sub><br /><sub>1084200</sub><br/><a>🐵</a></td>
    <td align="center"><sub><b>Nicolas Martin Cano</b></sub><br /><sub>1147246</sub><br/><a>🙈</a></td>
    <td align="center"><sub><b>Fernando Ferreyra</b></sub><br /><sub>1137834</sub><br/><a>🙊</a></td>
    <td align="center"><sub><b>Belen Enriquez</b></sub><br /><sub>1092598</sub><br/><a>🙉</a></td>
  </tr>
</table>

> UADE - Licenciatura en gestión de tecnologías de la información - 2023
