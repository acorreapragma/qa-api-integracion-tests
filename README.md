# Proyecto de Automatización de Pruebas API con Serenity BDD

Este es un proyecto de inicio rápido (starter) para la automatización de pruebas de API, utilizando el patrón Screenplay con Serenity BDD, Cucumber, y Java.

---

## Tabla de Contenidos

- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Prerrequisitos](#prerrequisitos)
- [Instalación](#instalación)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Configuración de Entornos](#configuración-de-entornos)
- [Ejecución de las Pruebas](#ejecución-de-las-pruebas)
  - [Usando Gradle](#usando-gradle)
  - [Usando Maven](#usando-maven)
- [Visualización de Reportes](#visualización-de-reportes)

---

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación base.
- **Serenity BDD**: Framework para escribir pruebas de aceptación y regresión de alta calidad.
- **Cucumber**: Herramienta para escribir pruebas en formato BDD (Gherkin).
- **Screenplay Pattern**: Patrón de diseño para escribir pruebas de aceptación mantenibles y escalables.
- **Rest-Assured**: Librería para probar y validar servicios REST en Java.
- **Gradle**: Herramienta de automatización de compilación.
- **Maven**: Herramienta de gestión y comprensión de proyectos de software.
- **JUnit 5**: Framework de pruebas para Java.

---

## Prerrequisitos

Asegúrate de tener instalado lo siguiente en tu sistema:

- **JDK 17** (Java Development Kit).
- **Git** para clonar el repositorio.

---

## Instalación

1.  Clona este repositorio en tu máquina local:
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd clone <URL_DEL_REPOSITORIO>
    ```

2.  El proyecto utiliza wrappers de Gradle (`gradlew`) y Maven (`mvnw`), por lo que no es necesario tenerlos instalados globalmente. Los wrappers descargarán la versión requerida automáticamente.

---

## Estructura del Proyecto

El proyecto sigue una estructura estándar para facilitar la navegación y el mantenimiento:

```
serenity-junit-starter/
├── build/                      # Directorio de salida de Gradle (incluye reportes)
├── target/                     # Directorio de salida de Maven (incluye reportes)
├── src/
│   ├── main/java/              # Código fuente principal (si aplica)
│   └── test/
│       ├── java/               # Código de las pruebas (Steps, Tasks, Questions)
│       └── resources/
│           ├── features/       # Archivos .feature de Cucumber
│           └── serenity.conf   # Archivo de configuración de Serenity
├── build.gradle                # Archivo de build para Gradle
├── gradlew                     # Wrapper de Gradle para Unix/Linux
├── pom.xml                     # Archivo de build para Maven
└── mvnw                        # Wrapper de Maven para Unix/Linux
```

---

## Configuración de Entornos

La configuración para diferentes entornos (ej. `qa`, `dev`, `prod`) se gestiona en el archivo `src/test/resources/serenity.conf`.

Puedes definir variables, como la URL base de la API, para cada entorno:

```properties
environments {
  default {
    baseUrl = "http://localhost:8080"
  }
  qa {
    baseUrl = "https://api.qa.dominio.com"
  }
  prod {
    baseUrl = "https://api.prod.dominio.com"
  }
}
```

---

## Ejecución de las Pruebas

Puedes ejecutar las pruebas automatizadas utilizando Gradle o Maven.

### Usando Gradle

Para ejecutar todas las pruebas en el entorno de `qa`, utiliza el siguiente comando. Esto limpiará el proyecto, ejecutará las pruebas y generará los reportes.

```bash
./gradlew clean test -Denvironment=qa
```

### Usando Maven

De forma similar, puedes usar el wrapper de Maven para ejecutar las pruebas:

```bash
./mvnw clean verify -Denvironment=qa
```

> **Nota**: Reemplaza `qa` con el entorno que desees utilizar según lo definido en `serenity.conf`. Si no se especifica, se usará el entorno `default`.

---

## Visualización de Reportes

Después de cada ejecución, Serenity BDD genera un reporte HTML detallado con los resultados de las pruebas.

- **Si usaste Gradle**, el reporte se encontrará en:
  `build/reports/serenity/index.html`

- **Si usaste Maven**, el reporte se encontrará en:
  `target/site/serenity/index.html`

Abre el archivo `index.html` en tu navegador para ver un desglose completo de la ejecución, incluyendo los pasos de cada escenario y las capturas de evidencia.

