# Control de Citas - Clínica Dental 🦷

Este proyecto es una aplicación de escritorio desarrollada en **Java (Maven)** utilizando **Swing** para la interfaz gráfica. Permite a los usuarios de una clínica dental **registrar pacientes** y **consultar su información** por medio del **ID del paciente**, conectando con una **base de datos** a través de un backend hecho en **PHP**.

---

## 🛠 Tecnologías Utilizadas

- **Java** (proyecto Maven)
- **Swing** (interfaz gráfica)
- **MySQL** o **MariaDB** (gestión de base de datos)
- **PHP** (API para conexión con la base de datos)
- **JDBC** (comunicación entre Java y el backend)

---

## 🎯 Funcionalidades Principales

- Registro de nuevos usuarios/pacientes de la clínica
- Consulta de pacientes por su **ID**
- Validación para indicar si el usuario existe o no
- Interfaz amigable construida con **Swing**
- Almacenamiento seguro de los datos en base de datos

---

## 🧱 Estructura del Proyecto

/control-citas/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── interfaz/ → Ventanas Swing (formularios)
│ │ │ ├── conexion/ → Clase de conexión con el backend PHP
│ │ │ └── modelo/ → Clases de entidad y lógica de negocio
│ ├── php/
│ │ └── api/ → Scripts PHP para operaciones CRUD
├── pom.xml → Dependencias del proyecto


---

## 🧪 ¿Cómo ejecutar el proyecto?

### 🔧 Requisitos previos:

- JDK 8 o superior
- Apache NetBeans (u otro IDE compatible con Maven)
- Servidor web local (XAMPP, WAMP o similar)
- Base de datos MySQL configurada

### ▶️ Pasos:

1. Clona este repositorio:
   ```bash
   git clone https://github.com/alejapdb/formulario_clinica_dental.git
