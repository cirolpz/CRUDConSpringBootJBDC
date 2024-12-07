# CRUDConSpringBootJDBC

**CRUDConSpringBootJDBC** es un proyecto que implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar) usando **Spring Boot** y **JDBC**. Este proyecto está diseñado para demostrar cómo interactuar con bases de datos a través de JDBC en una aplicación Spring Boot.

---

## ✨ Características

- **Crear:** Añadir nuevas entradas a la base de datos.  
- **Leer:** Obtener datos de la base de datos.  
- **Actualizar:** Modificar datos existentes en la base de datos.  
- **Eliminar:** Remover datos de la base de datos.  

---

## 🛠️ Tecnologías Utilizadas

- **Java:** Lenguaje de programación principal.  
- **Spring Boot:** Framework para la creación de aplicaciones Java.  
- **JDBC:** API para la conexión y ejecución de consultas en bases de datos.  
- **Maven:** Herramienta de gestión de proyectos y dependencias.  

---

## 📋 Requisitos Previos

- **JDK 11** o superior.  
- **Maven 3.6** o superior.  
- Una base de datos compatible con **JDBC** (por ejemplo, MySQL, PostgreSQL).  

---
## 📖 Uso

### Crear una Campaña

1. Ve a la sección **Campañas** en la aplicación.  
2. Haz clic en **Crear Nueva Campaña**.  
3. Completa los detalles de la campaña y selecciona una plantilla.  
4. Guarda la campaña y envíala a los destinatarios.  

### Analizar el Rendimiento

1. Navega a la sección **Reportes**.  
2. Selecciona la campaña que deseas analizar.  
3. Visualiza métricas como:  
   - **Tasa de apertura.**  
   - **Clics en los enlaces.**  
   - **Conversiones.**


Aquí tienes la sección de Uso formateada correctamente en Markdown para que se vea bien en un archivo .md:

markdown
Copiar código
## 📖 Uso

### Endpoints

- **GET /items:** Obtener todos los ítems.  
- **GET /items/{id}:** Obtener un ítem por ID.  
- **POST /items:** Crear un nuevo ítem.  
- **PUT /items/{id}:** Actualizar un ítem existente.  
- **DELETE /items/{id}:** Eliminar un ítem por ID.  

### Ejemplo de Peticiones

#### Crear un nuevo ítem:

curl -X POST http://localhost:8080/items -H "Content-Type: application/json" -d '{"nombre":"Nuevo Item","precio":100}'
### Obtener todos los ítems:
curl -X GET http://localhost:8080/items


### Cambios realizados:
1. Se organizaron los endpoints en una lista con viñetas.
2. Los ejemplos de comandos `curl` están dentro de bloques de código (` ```bash `) para mejor visualización.
3. Se incluyeron encabezados para las subsecciones, lo que mejora la legibilidad.


##Compilar y ejecutar la aplicación:
-mvn clean install
-mvn spring-boot:run
--Acceder a la aplicación:
Abre tu navegador y ve a:
http://localhost:8080


     
## 🚀 Instalación y Ejecución

### Clonar el repositorio:

```bash
git clone https://github.com/cirolpz/CRUDConSpringBootJBDC.git
'''

