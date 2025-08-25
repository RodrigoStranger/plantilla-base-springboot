# Proyecto Demo - Spring Boot + PostgreSQL

Este es un **proyecto demo** desarrollado con **Spring Boot** que se conecta a una base de datos **PostgreSQL**.  
Su objetivo es demostrar cómo realizar un **CRUD básico** sobre una tabla llamada **Persona**.

## 📌 Descripción del Proyecto

La aplicación permite gestionar una tabla `Persona` con los siguientes campos:
- **ID** (identificador único **autoincrementable**, no es necesario incluirlo en el JSON al crear una persona)
- **Nombre**
- **Apellido**
- **Edad**

### **Características principales**
- **Crear** una persona (**no permite nombres y apellidos duplicados**).
- **Leer** una persona por su **ID**.
- **Listar** todas las personas.
- **Actualizar** los datos de una persona por su **ID** (**también valida que no existan nombres y apellidos duplicados**).
- **Eliminar** una persona por su **ID**.

---

## ⚙️ Requisitos Previos

Para ejecutar este proyecto necesitarás:

1. **IntelliJ IDEA Ultimate**  
   - Puedes obtener una licencia gratuita para estudiantes en el siguiente enlace:  
     [https://www.jetbrains.com/community/education/#students](https://www.jetbrains.com/community/education/#students)

2. **PostgreSQL** (motor de base de datos instalado en tu sistema)  
   - Descarga: [https://www.postgresql.org/download/](https://www.postgresql.org/download/)

3. **Postman** (para probar los endpoints)  
   - Descarga: [https://www.postman.com/downloads/](https://www.postman.com/downloads/)  
   - Importa la colección JSON incluida en este proyecto para realizar pruebas fácilmente (ver sección [Uso del Archivo Postman](https://github.com/RodrigoStranger/plantilla-base-springboot/tree/main/pruebas%20endpoints)).

---

## 🛠 Configuración del Proyecto

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/RodrigoStranger/plantilla-base-springboot.git
   ```
2. **Configurar credenciales en application.yaml (ubicado en src/main/resources/):**

Edita el archivo application.yaml y coloca tus credenciales:
```java
   spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/TU_BASE_DE_DATOS # Cambiar el nombre de la aplicaci�n dependiendo del proyecto
    username: TU_USUARIO # Cambiar el nombre de la aplicacion dependiendo del proyecto
    password: TU_CONTRASEÑA # Cambiar el nombre de la aplicacion dependiendo del proyecto
  jpa:
    hibernate:
      ddl-auto: update # Cambiar a 'update' o 'validate' en produccion
    show-sql: true
```

## 📦 Uso del Archivo Postman (Colección de Pruebas)

Este proyecto incluye un archivo **Postman Collection** exportado en formato `.json` para que puedas probar fácilmente los endpoints de la API.

### **1. Importar la colección en Postman**
1. Abre **Postman** en tu computadora.
2. Haz clic en el botón **Import** (parte superior izquierda).
3. Selecciona **Upload Files** y busca el archivo: Plantilla SpringBoot.postman_collection.json
