![Programação-Java_ Persistencia de datos y consultas con Spring Data JPA](https://github.com/genesysR-dev/2066-java-persitencia-de-datos-y-consultas-con-Spring-JPA/assets/91544872/e0e3a9f8-afc7-4e7b-be83-469351ef2d70)

# Challenge LiterAlura by Rene Avila Alonso

Proyecto desarrollado durante el curso de la formación Avanzando con Java de Alura
para BackEnd

[Descripción proyecto](#descripción-proyecto) <br/>
[Como usar la API](#como-usar-la-api) <br/>
[Tecnologías utilizadas](#Tecnologías-utilizadas) <br/>
[Personas o entidades contribuyentes en el Proyecto](#Personas-o-entidades-contribuyentes-en-el-Proyecto) <br/>
[Desarrolladores del Proyecto](#Desarrolladores-del-Proyecto) <br/>

1. [Autorizacion](#autorizacion)
2. [Registrar usuarios desde MYSQL](#registrar-usuarios-desde-MYSQL)
3. [Registrar topicos](#registrar-topicos)
4. [Lista de topicos](#lista-de-topicos)
5. [Detalle de un topico](#detalle-de-un-topico)
5. [Eliminar un topcio](#eliminar-un-topico)
6. [Recuperar topico borrado](#recuperar-topico-borrado)
7. [Actualizar topicos](#actualizar-topicos)

<h2>**26-API REST FORO CHALLENGE ALURA**</h2>
<h3>Inicio</h3>
<em> MENU DE OPCIONES </em> <br/>
- - - - - - - - - - - - - - - - - - - - - - <br/>

NOTAS ANTES DE UTILIZAR EL PROYECTO </br>
* Utilizar una variable de entorno JWT_SECRET, con un numero de 4 a 8 cifras</br>
* o Colocar DB_NAME = db_foro_api, y en properties dejar DB_NAME </br>
* Se esta utilizando JDK 17, e Intellij IDEA </br>
* puede utilizar en variables de entorno DB_NAME, DB_PASSWORD, pero </br>
* hacer los cambios respectivos en Application.properties </br>
* </br>

<h2>Descripción proyecto</h2>
Construir ana API, para manejo d eun foro, curso de ALURA backend <br/>
Aprenderás a realizar solicitudes a una API, manipular datos JSON y,
finalmente, grabar informacion en la base de datos y hacer las consultas
respectivas a estas tablas de la base de datos con MySQL, 
con sentencias en el repositorio con JPA, JPQL y sql nativo<br/>

<h2>Como usar la API</h2> <br/> 
**FORO API ALURA**   <br/>
Generar token al Inicio de Sesion. <br/>
![descripción de la imágen]()


<h2>Buscar libro por titulo y grabar bd</h2>
</br>

[Inicio](#Inicio)

<h2>Listar libros registrados BD</h2> 
</br>
[Inicio](#Inicio)

<h2>Listar autores registrados BD</h2> 
```
Hibernate: SELECT nombre, year_born, year_dead FROM autores </br>
```
</br>
[Inicio](#Inicio)

<h2>Listar autores vivos en un determinado año BD</h2> 
</br>

[Inicio](#Inicio)

<h2>Listar autores fallecidos BD</h2>
</br>

[Inicio](#Inicio)

<h2>Listar libros por idioma BD</h2>
</br>
[Inicio](#Inicio)
<h2>Libros mas populares en la API GUTENDEX</h2>
</br>

[Inicio](#Inicio)

<h2>Buscar autor por nombre BD</h2>
</br>

[Inicio](#Inicio)

<h2>Tecnologías utilizadas</h2>
- Java <br/>
- Manejo de API GUTENDEX <br/>
- Postman  (para hacer las pruebas de la API) <br/>
- Editor IDE, Intellij IDEA <br/>
- git, github y terminal. <br/>
- LURI, IA de ALURA-ONE, Sao Pablo, Brazil. <br/>
- API, Exchangerate API. <br/>
- Gson, Api de Java, desarrollada por Google. <br/>
- plugins de Intellij IDEA, para mostrar README.md <br/>
- Trello (planeador de actividades a seguir de un proyecto) <br/>
- De Manejador de base de datos, ProgreSQL.  <br/>
- Administrador de bases de datos, PGADMIN-4 <br/>

[Inicio](#Inicio)

<h2>Personas o entidades contribuyentes en el Proyecto</h2>
- Alura LATAM, ONE(Oracle Next Education) <br/>
- Profesor. Bruno Dario Fernández Ellerbach <br/>
- Profesora. Genesys Rondón </br>
- Profesor. Eric Monné Fraga de Oliveira. <br/>

<h2>Desarrolladores del Proyecto</h2>
- René Avila Alonso. <br/>
- Desarrollador BackEnd <br/>
- July, 2025. </br>
  </br>
  [Inicio](#Inicio)