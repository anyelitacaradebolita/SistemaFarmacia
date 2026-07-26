#  Sistema de Gestión de Farmacia

Sistema de escritorio desarrollado en **Java** utilizando **Swing** y **MySQL**, diseñado para administrar el registro y consulta de medicamentos de una farmacia mediante una interfaz gráfica moderna e intuitiva.

---

#  Integrantes

- Juan José Angulo Ugarte
- Daniel Rojas Ureña
- Anyel Fiorella Barrantes Ramírez
- Daryelin Massiel Valverde Gómez

---

#  Descripción

El Sistema de Gestión de Farmacia permite administrar medicamentos de forma sencilla y eficiente. El sistema ofrece una interfaz amigable para registrar nuevos medicamentos, visualizar el inventario y almacenar toda la información en una base de datos MySQL.

Su objetivo es facilitar el control de medicamentos dentro de una farmacia mediante una aplicación de escritorio desarrollada bajo una arquitectura por capas.

---

#  Funcionalidades

- Registro de medicamentos.
- Consulta del inventario.
- Validación de datos antes de guardar.
- Conexión con base de datos MySQL.
- Interfaz gráfica desarrollada con Java Swing.
- Diseño moderno con componentes personalizados.

---

#  Tecnologías utilizadas

- Java JDK 20 o superior
- Java Swing
- MySQL
- JDBC (MySQL Connector/J)
- Apache Ant (NetBeans)

---

#  Estructura del proyecto

```
SistemaFarmacia
│
├── src
│   ├── datos
│   │     ├── ConexionBD.java
│   │     └── MedicamentoDAO.java
│   │
│   ├── modelo
│   │     └── Medicamento.java
│   │
│   ├── negocio
│   │     ├── MedicamentoNegocio.java
│   │     └── ValidacionException.java
│   │
│   └── presentacion
│         ├── Main.java
│         ├── MainFrame.java
│         ├── PanelRegistro.java
│         ├── PanelLista.java
│         ├── FondoAnimado.java
│         ├── PanelVidrio.java
│         ├── BotonBrillante.java
│         └── TemaFarmacia.java
│
└── Base de datos Farmacia.sql
```

---

#  Base de datos

El proyecto incluye el archivo:

```
base de datos Farmacia.sql
```

Este archivo contiene la estructura necesaria para crear la base de datos utilizada por el sistema.

Antes de ejecutar el proyecto:

1. Crear una base de datos en MySQL.
2. Ejecutar el script **base de datos Farmacia.sql**.
3. Configurar el usuario y contraseña en:

```
src/datos/ConexionBD.java
```

Ejemplo:

```java
private static final String URL = "jdbc:mysql://localhost:3306/farmacia_db?useSSL=false&serverTimezone=UTC";
private static final String USUARIO = "root";
private static final String PASSWORD = "";
```

---

#  Requisitos

- Java JDK 20 o superior.
- NetBeans IDE (recomendado).
- MySQL Server.
- MySQL Connector/J agregado al proyecto.
- Base de datos creada mediante el script SQL incluido.

---

#  Cómo ejecutar

1. Clonar el repositorio.

```
git clone <URL_DEL_REPOSITORIO>
```

2. Abrir el proyecto en NetBeans.

3. Crear la base de datos utilizando el archivo:

```
base de datos Farmacia.sql
```

4. Configurar la conexión en `ConexionBD.java`.

5. Ejecutar la clase:

```
Main.java
```

---

#  Arquitectura

El proyecto está organizado utilizando una arquitectura por capas:

### Modelo

Representa las entidades del sistema.

- Medicamento.java

### Datos

Gestiona la conexión y acceso a la base de datos.

- ConexionBD.java
- MedicamentoDAO.java

### Negocio

Contiene las reglas de negocio y validaciones.

- MedicamentoNegocio.java
- ValidacionException.java

### Presentación

Contiene toda la interfaz gráfica del sistema.

- MainFrame
- PanelRegistro
- PanelLista
- Componentes personalizados

---

#  Características de la interfaz

- Diseño moderno.
- Componentes personalizados.
- Botones con efectos visuales.
- Fondo animado.
- Paneles transparentes.
- Interfaz intuitiva.

---

#  Licencia

Proyecto desarrollado con fines académicos.
