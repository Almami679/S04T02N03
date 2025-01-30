# FruitsAPI Tasca S4.02 (nivel 3)

### Albert Marin



## Descripción


_Esta es una aplicación desarrollada con Spring Boot para gestionar 
frutas en una base de datos. **Proporciona operaciones CRUD (Crear, Leer, Actualizar, Eliminar)** 
para manejar datos de frutas a través de una API REST. (Mediante MongoDB)_


## Estructura del Proyecto
```
├───cat
│   └───itacademy
│       └───s04
│           └───t02
│               └───n03
│                   └───S04T02N03
│                       │   S04T02N03Application.java
│                       │
│                       ├───controller
│                       │       FruitController.java
│                       │
│                       ├───exception
│                       │   │   GlobalExceptionHandler.java
│                       │   │
│                       │   └───custom
│                       │           DuplicateFruitException.java
│                       │           NoFruitFoundException.java
│                       │
│                       ├───repository
│                       │       FruitRepository.java
│                       │
│                       └───service
│                           │   FruitService.java
│                           │
│                           ├───fruitDto
│                           │       FruitDTO.java
│                           │
│                           └───impl
│                                   FruitServiceImpl.java
│
└───documents
        Fruit.java
            
```

## Links

Enlace de github del codigo: [Almami fruitsAPI repository](https://github.com/Almami679/S04T02N03).

## Funcionalidades


 **Endpoints**
>
>Crear, obtener, actualizar y eliminar frutas.


**Excepciones Personalizadas**
>DuplicateFruitException.
>NoFruitFoundException.

**Integración con Base de Datos**
>Mejorando el diseño de la anterior nivel en SQL, he añadido un DTO (Data Transfer Object)
>para poder realizar las validaciones de los datos introducidos, a partir de una clase Record.
>
>Ya que en mongo no tenemos forma de gestionar el Id en autoincrement, he aadido un servicio
>que nos devuelve el ultimo Id de la base de datos ara gestionarlo en el constructor de fruits/add


## Tables

| Requisitos Previos  | 
| ------------- |
| Java 17 o superior      | 
| Maven 3.8 o superior      | 
| Postman para peticiones      | 
| MongoDB Compass     |


## Instalación

### Clona el repositorio:
```
git clone <repository-url>
```

### Navega al directorio del proyecto:
```
cd <project-directory>
```
### Compila el proyecto:
```
./mvnw clean install
```
### Se debera iniciar el Servicio mongoDB ubicado en:
```
C:\Program Files\MongoDB\Server\8.0\bin\mongod
```
