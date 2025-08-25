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

---

## 🛠 Configuración del Proyecto

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/proyecto-demo-springboot.git
   cd proyecto-demo-springboot
