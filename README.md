# API-FORO
# Proyecto API Foro en Spring Boot 3

Este proyecto es una API RESTful desarrollada con **Spring Boot 3**, utilizando **MySQL** como base de datos. Permite la gestión de tópicos en un foro, con operaciones de **registro**, **listado**, **eliminación** y **actualización**. La seguridad está implementada mediante **JWT Token** y **Spring Security** para la autenticación de usuarios.

## Funcionalidades

- **Registrar Tópico**: Permite crear un nuevo tema en el foro.
- **Listar Tópicos**: Obtiene todos los temas registrados en el foro.
- **Actualizar Tópico**: Permite modificar los detalles de un tema existente.
- **Eliminar Tópico**: Permite eliminar un tema del foro.

## Seguridad

La autenticación de los usuarios se realiza mediante el uso de **JWT Token**. Además, se implementó **Spring Security** para proteger las rutas de acceso y garantizar que solo los usuarios autenticados puedan interactuar con los endpoints.

## Validaciones

Se han implementado validaciones propias para asegurar la integridad de los datos, como la validación de campos obligatorios y formatos correctos.

## Herramientas y Tecnologías

- **Spring Boot 3**: Framework para desarrollo de aplicaciones Java.
- **MySQL**: Base de datos utilizada para almacenar los datos de los usuarios y tópicos.
- **JWT Token**: Método de autenticación basado en tokens para asegurar las rutas.
- **Spring Security**: Framework de seguridad para manejar la autenticación y autorización.
- **Insomnia**: Herramienta utilizada para probar los endpoints de la API.

## Instalación

### Requisitos

- **Java 17 o superior**.
- **MySQL**: Base de datos configurada con las credenciales correspondientes.

### Pasos

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git
2. Configura la base de datos en application.properties con las credenciales de tu MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contrasena

3. Crea las tablas tópicos y usuarios en la base de datos MySQL:
Topicos
CREATE TABLE IF NOT EXISTS topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    nombre_curso VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL
);
Usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);


4. Ejecuta el proyecto:
./mvnw spring-boot:run


##Endpoints
Login
POST /auth/login
Body: {"email": "usuario", "password": "contrasena"}
Respuesta: JWT Token
###Tópicos
GET /topicos - Lista todos los tópicos.
POST /topicos - Crea un nuevo tópico.
PUT /topicos/{id} - Actualiza un tópico existente.
DELETE /topicos/{id} - Elimina un tópico.
