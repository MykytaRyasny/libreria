-- Video con las pruebas de que el proyecto funciona

https://www.youtube.com/watch?v=US26ed6uylk

-- Realización

Proyecto realizado con IntelliJ Idea ya que Eclipse daba error en JPA Persistance ya que su última versión soportada por Eclipse es 2.2 y no funciona bien o directamente no funciona. IntelliJ Idea me permite trabajar con la versión jakarta persistance 3.0

Base de datos creada en MySQL se adjunta el script.sql que contiene todo lo necesario para que la practica funcione, es decir, tanto las 3 tablas como los inserts correspondientes.

Los Inserts constan de 10 Libros sin imagen que hay que añadirlas manualmente una vez ejecutado el proyecto desde la página web. También consta de dos usuarios 'user' y 'admin'. User simula ser un usuario normal y admin los privilegios de admin que establezco con un true y false.

-- Tests

Los tests mostrados en el video se hacen con Servidor de Tomcat10.0.27, IntelliJ Idea Ultimate, JavaSE 11 y JRE 19 y el navegador EDGE.

-- Ausencia de:

Falta la implementación del registro, guardado de carrito de compra. El carrito de compra necesitaria de una tabla extra ya que sería una relación de muchos a muchos entre compra y libro o de uno a muchos si cada unidad de libro tuviese su propio ID, pero como queremos que la FK esté en la tabla compra necesitariamos de una tabla adicional de todas formas.