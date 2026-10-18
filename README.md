# FSI Kindergarten CRUD

Sistema de gestión para el control de entradas y salidas de niños en una guardería. Desarrollado en **Java Swing** con arquitectura orientada a objetos y conexión a base de datos **MySQL** a través de JDBC.

## 📋 Descripción del Proyecto

El sistema permite registrar, actualizar, consultar y eliminar registros (CRUD) esenciales para el funcionamiento seguro de una guardería. Administra tanto a los niños como al personal a cargo y los tutores autorizados, registrando cada evento en una bitácora detallada.

## 🚀 Módulos y Funcionalidades

1. **👶 Infantes:**
   * Registro y gestión de niños inscritos.
   * Campos: CURP, Nombre completo, Sexo, Fecha de nacimiento y Estado (Activo/Inactivo).

2. **👩‍🏫 Educadores:**
   * Registro de personal educativo encargado de recibir o entregar a los infantes.
   * Campos: CURP, Nombre, Sexo, Teléfono, Dirección y Estado.

3. **👨‍👩‍👧 Responsables:**
   * Gestión de padres o tutores legales autorizados para entregar y recoger a los infantes.
   * Campos: CURP, Nombre, Sexo, Teléfono, Parentesco y Estado.

4. **📖 Bitácora:**
   * Control centralizado de entradas y salidas.
   * Asocia cada registro a un **Infante**, un **Responsable** (quien entrega/recoge) y un **Educador** (quien atiende el acceso).
   * Incluye marca de tiempo, tipo de movimiento (Entrada/Salida) y observaciones.

## 🧩 Arquitectura y Reutilización de Código (`Conexion.java`)

Para evitar duplicación de código y desacoplar las vistas de la capa de persistencia, el proyecto utiliza una clase utilitaria central (`Conexion.java`) que abstrae las operaciones más comunes:

* **Gestión de Conexión:** Apertura y cierre de la conexión JDBC a MySQL.
* **Mapeo Automático a Tablas (`entablar`):** Ejecuta consultas SQL y llena automáticamente un `JTable` configurando encabezados, filas y renderizado de imágenes (`ImageRenderer`).
* **Poblado de Desplegables (`seleccionar`):** Carga dinámicamente listas de datos en componentes `JComboBox`.
* **Consultas directas:** Métodos utilitarios como `obtenerDato` y `buscarDato` para validar o recuperar información puntual.
* **Formato e Imágenes:** Auxiliares para manejo de fechas/horas de sistema y procesamiento de imágenes.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 8+)
* **Interfaz Gráfica:** Java Swing / NetBeans GUI Builder
* **Base de Datos:** MySQL
* **Conectividad:** JDBC (`mysql-connector-java`)

## 🗄️ Configuración de la Base de Datos

El sistema se conecta por defecto a un servidor MySQL local con los siguientes parámetros:

* **Host:** `127.0.0.1`
* **Base de Datos:** `kindergarden`
* **Usuario:** `root`
* **Contraseña:** *(Vacío)*

### Tablas Principales

* `infantes`
* `educadores`
* `responsables`
* `bitacora`

## 💻 Instrucciones de Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/TU-USUARIO/FSI-Kindergarden-CRUD.git
   ```

2. Asegurarse de tener un servidor MySQL corriendo (por ejemplo mediante XAMPP o MySQL Server local) y haber creado la base de datos `kindergarden`.

3. Abrir el proyecto en **NetBeans**, **IntelliJ IDEA** o tu IDE de preferencia.

4. Asegurar que el driver de MySQL (`mysql-connector-j`) esté agregado a las librerías del proyecto.

5. Ejecutar la clase principal `FPrincipal.java`.