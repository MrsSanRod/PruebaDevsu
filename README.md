# PruebaDevsu
## Proyecto de Microservicios con Spring Boot
Este proyecto consta de dos microservicios, uno para la gestión de personas/clientes y otro para la gestión de cuentas/movimientos. Ambos microservicios están desarrollados en Java utilizando Spring Boot y Maven. La comunicación entre los microservicios se realiza a través de RabbitMQ, y cada uno tiene configurada una base de datos H2 para el almacenamiento de datos.

### Requisitos Previos
Java 17 o superior
Maven 3.6.0 o superior
Docker (para RabbitMQ)
Conexión a internet para descargar dependencias

### Estructura del Proyecto
El proyecto se divide en dos microservicios principales:

#### Microservicio de Persona/Cliente

Gestión de personas y clientes.
CRUD completo (Crear, Leer, Actualizar, Eliminar).
Microservicio de Cuenta/Movimiento

#### Gestión de cuentas y movimientos financieros.
CRUD completo (Crear, Leer, Actualizar, Eliminar).
Ambos microservicios utilizan las siguientes tecnologías:

- Spring Boot para el desarrollo del backend.
- RabbitMQ para la comunicación entre los microservicios.
- H2 como base de datos en memoria para el almacenamiento de datos.
- Maven para la gestión de dependencias y la construcción del proyecto.
