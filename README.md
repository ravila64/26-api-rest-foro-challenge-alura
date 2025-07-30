# Challenge Foro Alura by Rene Avila Alonso
Proyecto desarrollado durante el curso de la formación Avanzando con Java de Alura
para BackEnd

[Descripción proyecto](#descripción-proyecto) <br/>
[Como usar la API](#como-usar-la-api) <br/>
[Tecnologías utilizadas](#Tecnologías-utilizadas) <br/>
[Personas o entidades contribuyentes en el Proyecto](#Personas-o-entidades-contribuyentes-en-el-Proyecto) <br/>
[Desarrolladores del Proyecto](#Desarrolladores-del-Proyecto) <br/>

1. [Autorización](#autorización)
2. [Registrar usuarios desde MYSQL](#registrar-usuarios-desde-mysql)
3. [Registrar topicos](#registrar-topicos)
4. [Grabar variable ambiente en Insominia](#grabar-variable-ambiente-en-insominia)
4. [Lista de topicos](#lista-de-topicos)
5. [Detalle de un topico](#detalle-de-un-topico)
6. [Eliminar un topcio](#eliminar-un-topico)
7. [Recuperar topico borrado](#recuperar-topico-borrado)
8. [Actualizar topicos](#actualizar-topicos)

<h2>**26-API REST FORO CHALLENGE ALURA**</h2>

NOTAS ANTES DE UTILIZAR EL PROYECTO </br>
* Utilizar una variable de entorno JWT_SECRET, con un numero de 4 a 8 cifras</br>
* o Colocar DB_NAME = db_foro_api, y en properties dejar DB_NAME </br>
* Se esta utilizando JDK 17, e Intellij IDEA </br>
* puede utilizar en variables de entorno DB_NAME, DB_PASSWORD, pero </br>
* hacer los cambios respectivos en Application.properties </br>
* Tener creada la base de datos o esquema en MySql, db_foros_api</br>

<h2>Descripción proyecto</h2>
¡Te damos la bienvenida a nuestro más reciente Challenge Back End! </br>

Un foro es un lugar donde todos los participantes de una plataforma
pueden colocar sus preguntas sobre determinados asuntos. Aquí en Alura, 
los estudiantes utilizan el foro para resolver sus dudas sobre los cursos 
y proyectos en los que están participando. Este lugar mágico está lleno de 
mucho aprendizaje y colaboración entre estudiantes, profesores y moderadores.</br>

Ya sabemos para que sirve el foro y sabemos cómo se ve, pero ¿sabemos cómo 
funciona por detrás? Es decir ¿dónde se almacenan las informaciones? 
¿cómo se tratan esos datos para que se relacione un tópico con una respuesta, 
o como se relacionan los usuarios con las respuestas de un tópico?</br>

Ese es nuestro desafío, que se llama Foro Hub: vamos a replicar a nivel de 
back end este proceso, y para eso crearemos una API REST usando Spring.</br>

Nuestra API va a centrarse específicamente en los tópicos, y debe permitir a 
los usuarios:</br>

* Crear un nuevo tópico</br>
* Mostrar todos los tópicos creados</br>
* Mostrar un tópico específico</br>
* Actualizar un tópico</br>
* Eliminar un tópico</br>

Es lo que conocemos comúnmente como CRUD (CREATE, READ, UPDATE, DELETE).</br>

Al final de nuestro desarrollo tendremos una API REST con las siguientes 
funcionalidades:</br>

API con rutas implementadas siguiendo las mejores prácticas del modelo REST;</br>
Validaciones realizadas según reglas de negocio;</br>
Implementación de una base de datos para la persistencia de la información;</br>
Servicio de autenticación/autorización para restringir el acceso a la información.<br/>

<h2>Como usar la API</h2> <br/> 

Generar token al Inicio de Sesion. <br/>
<h3>Autorización</h3>

![Autorización](/src/main/assets/0_crear_token_inico_sesion.png)

<h2>Registrar usuarios desde MYSQL</h2>

![grabar usuarios](/src/main/assets/8_grabar_usuarios.png)

Entre a:
```
https://bcrypt-generator.com/
```
Genere una clave encryptada de 4 a 8 digitos y grabar un usuario
con id, nombre, email, clave, activo desde MYSQL. 

Si necesita insertar registros en MySql, lo puede hacer por:
* MySql Line Clent (Esta opcion esta disponible cuando instala MYSQL WORKBENCH)
* Desde MySql Workbench, crear un query y coloque la siquiente sentencia:
```commandline
use db_foros_api;
```
La base de datos db_foros_api ya debe estar creada, esto lo hace 
la migracion con flyway automaticamente.

Grabe algunos registros en la tabla usuarios:
```commandline
use db_foros_api;
INSERT INTO `usuarios` VALUES (1,'nombre usuario 1','pedro.usuario@foro.alu','$2y$10$RNFOk3Gz7C2PrQ1knGljPu93NhpX4SIX.Dap3Vi5EGwrIvMmCSWby',1);
INSERT INTO `usuarios` VALUES (2,'nombre usuario 2','maria.apellido@voll.med','$2y$10$IJdVIrFRyH88UK1XiuPQbuSxMBFb1Pg7z54jTNtXZwtuYnqW10eQq',1);
```
<h2>Grabar token en insomnia</h2>
![1_grabar_token_env_insomnia.png](/src/blob/main/assets/1_grabar_token_env_insomnia.png)
</br>
[Inicio](#Inicio)

<h2>Grabar variable ambiente en Insominia</h2>
![token](/src/main/assets/3_insertar_var_en_los_request.png)
[Inicio](#Inicio)

<h2>Registrar topicos</h2>
![registrar topicos](/src/blob/main/assets/2_registrar_topico.png)
</br>
[Inicio](#Inicio)

<h2>Lista de Topicos</h2>
![Lista topicos](/src/main/assets/6_lista_de_topicos.png)
</br>
[Inicio](#Inicio)

<h2>Detalle de un topico</h2>
![Lista topicos](/src/main/assets/5_listar_un_topico.png)
</br>
[Inicio](#Inicio)

<h2>Eliminar un topico</h2>
![Eliminar un  topico](/src/main/assets/4_elimina_registro_2.png)
</br>
[Inicio](#Inicio)

<h2>Recuperar topico borrado</h2>
</br>
![recuperar topico](/src/main/assets/9_recuperar_registro.png)
[Inicio](#Inicio)

<h2>listar un topico elminado</h2>
</br>
![listar topico eliminado](/src/main/assets/7_listar_un_topico_eliminado.png)
[Inicio](#Inicio)

<h2>Tecnologías utilizadas</h2>
- Java, sprint boot<br/>
- Insomina o Postman  (para hacer las pruebas de la API) <br/>
- Editor IDE, Intellij IDEA <br/>
- git, github y terminal. <br/>
- LURI, IA de ALURA-ONE, Sao Pablo, Brazil. <br/>
- plugins de Intellij IDEA, para mostrar README.md <br/>
- Trello (planeador de actividades a seguir de un proyecto) <br/>
- De Manejador de base de datos, MYSQL WORKBENCH <br/>
- Administrador de bases de datos, MYSQL COMMAND LINE CLIENT<br/>

[Inicio](#Inicio)

<h2>Personas o entidades contribuyentes en el Proyecto</h2>
- Alura LATAM, ONE(Oracle Next Education) <br/>
- Profesora. Genesys Rondón </br>
- Profesor. Bruno Dario Fernández Ellerbach <br/>
- Profesor. Eric Monné Fraga de Oliveira. <br/>

<h2>Desarrolladores del Proyecto</h2>
- René Avila Alonso. <br/>
- Desarrollador BackEnd <br/>
- July, 2025. </br>
  </br>
  [Inicio](#Inicio)
