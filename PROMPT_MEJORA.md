# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/inversiones/cartera/infrastructure/controllers/dto/ErrorResponse.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.annotation.JsonInclude pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/inversiones/cartera/infrastructure/controllers/CarteraController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/inversiones/cartera/infrastructure/controllers/GlobalExceptionHandler.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setId`: Se invoca `setId` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setNombre`: Se invoca `setNombre` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setDescripcion`: Se invoca `setDescripcion` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setSaldoInicial`: Se invoca `setSaldoInicial` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setFechaCreacion`: Se invoca `setFechaCreacion` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setInversiones`: Se invoca `setInversiones` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getId`: Se invoca `getId` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getNombre`: Se invoca `getNombre` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getDescripcion`: Se invoca `getDescripcion` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getSaldoInicial`: Se invoca `getSaldoInicial` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getFechaCreacion`: Se invoca `getFechaCreacion` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getInversiones`: Se invoca `getInversiones` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setSimbolo`: Se invoca `setSimbolo` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setCantidad`: Se invoca `setCantidad` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setPrecioCompra`: Se invoca `setPrecioCompra` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setFechaCompra`: Se invoca `setFechaCompra` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getSimbolo`: Se invoca `getSimbolo` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getCantidad`: Se invoca `getCantidad` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getPrecioCompra`: Se invoca `getPrecioCompra` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java` — `CarteraRepository.existsByNombre`: Se invoca `existsByNombre` sobre `CarteraRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java` — `CarteraRepository.existsByNombreAndIdNot`: Se invoca `existsByNombreAndIdNot` sobre `CarteraRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java` — `Inversion.setFechaCompra`: Se invoca `setFechaCompra` sobre `Inversion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/inversiones/cartera/infrastructure/controllers/CarteraController.java` — `CarteraService.obtenerTodasCarteras`: Se invoca `obtenerTodasCarteras` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraService.obtenerTodas`: Se invoca `obtenerTodas` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraResponse.id`: Se invoca `id` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraService.obtenerPorId`: Se invoca `obtenerPorId` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraService.crear`: Se invoca `crear` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraService.actualizar`: Se invoca `actualizar` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.obtenerTodas`: Se invoca `obtenerTodas` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.size`: Se invoca `size` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.get`: Se invoca `get` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.isEmpty`: Se invoca `isEmpty` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.obtenerPorId`: Se invoca `obtenerPorId` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.isPresent`: Se invoca `isPresent` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.crear`: Se invoca `crear` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.nombre`: Se invoca `nombre` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.saldoInicial`: Se invoca `saldoInicial` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.actualizar`: Se invoca `actualizar` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.eliminar`: Se invoca `eliminar` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Desarrolla servicios REST que cumplan con los estándares: Utiliza adecuadamente con los códigos de estado HTTP (1xx, 2xx, 3xx, 4xx, 5xx), manejar los cuatro verbos principales (GET, POST, PUT, DELETE), comprende la diferencia entre PUT y PATCH y entiende la propiedad de idempotencia.

### Misión / candidato
Candidato con experiencia avanzada en Backend.

### Reto
- Tema: Construcción de Servicios REST Robustos y Escalables
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de un Servicio REST Avanzado
- Tiempo estimado: 2 semanas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición de Entidades y Requisitos — objetivo: Establecer las entidades y los requisitos funcionales del servicio REST. — entregable (NO resolver): Documento de requisitos funcionales con entidades y verbos HTTP definidos.
- Fase 2: Diseño de la API — objetivo: Diseñar la estructura de la API REST basada en los requisitos funcionales. — entregable (NO resolver): Diseño de la API con endpoints, parámetros y respuestas documentados.
- Fase 3: Implementación y Validación — objetivo: Implementar el servicio REST y validar su funcionamiento. — entregable (NO resolver): Servicio REST implementado y documentado, con pruebas de validación.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.inversiones</groupId>
    <artifactId>cartera</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>cartera</name>
    <description>Servicio REST para gestión de carteras de inversión</description>

    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.2.224</version>
            <scope>runtime</scope>
        </dependency>

        <!-- OpenAPI/Swagger -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.5.0</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>
</project>

// === ARCHIVO: src/main/java/com/inversiones/cartera/Application.java ===
package com.inversiones.cartera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: cartera
  
  datasource:
    url: jdbc:h2:mem:carteradb
    driverClassName: org.h2.Driver
    username: sa
    password: ""
  
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        web-allow-others: true
  
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

server:
  port: 8080
  servlet:
    context-path: /api

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    operationsSorter: method
"

// === ARCHIVO: src/main/java/com/inversiones/cartera/domain/model/Cartera.java ===
package com.inversiones.cartera.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cartera {
    private UUID id;
    private String nombre;
    private String descripcion;
    private BigDecimal saldoInicial;
    private LocalDateTime fechaCreacion;
    private List<Inversion> inversiones;

    public Cartera(UUID id, String nombre, String descripcion, BigDecimal saldoInicial) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.saldoInicial = saldoInicial;
        this.fechaCreacion = LocalDateTime.now();
        this.inversiones = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Inversion> getInversiones() {
        return new ArrayList<>(inversiones);
    }

    public void agregarInversion(Inversion inversion) {
        if (inversion == null) {
            throw new IllegalArgumentException("La inversión no puede ser nula");
        }
        this.inversiones.add(inversion);
    }

    public void eliminarInversion(UUID inversionId) {
        inversiones.removeIf(inversion -> inversion.getId().equals(inversionId));
    }

    public BigDecimal calcularSaldoActual() {
        BigDecimal saldoActual = saldoInicial;
        for (Inversion inversion : inversiones) {
            for (Transaccion transaccion : inversion.getTransacciones()) {
                saldoActual = saldoActual.add(transaccion.getMonto());
            }
        }
        return saldoActual;
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/domain/model/Inversion.java ===
package com.inversiones.cartera.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Inversion {
    private UUID id;
    private String nombre;
    private String simbolo;
    private BigDecimal cantidad;
    private BigDecimal precioCompra;
    private LocalDateTime fechaCompra;
    private List<Transaccion> transacciones;

    public Inversion(UUID id, String nombre, String simbolo, BigDecimal cantidad, BigDecimal precioCompra) {
        this.id = id;
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.fechaCompra = LocalDateTime.now();
        this.transacciones = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public List<Transaccion> getTransacciones() {
        return new ArrayList<>(transacciones);
    }

    public void agregarTransaccion(Transaccion transaccion) {
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula");
        }
        this.transacciones.add(transaccion);
    }

    public BigDecimal calcularValorActual() {
        BigDecimal valorActual = cantidad.multiply(precioCompra);
        for (Transaccion transaccion : transacciones) {
            valorActual = valorActual.add(transaccion.getMonto());
        }
        return valorActual;
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/domain/model/Transaccion.java ===
package com.inversiones.cartera.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaccion {
    private UUID id;
    private TipoTransaccion tipo;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String descripcion;

    public enum TipoTransaccion {
        COMPRA, VENTA, DIVIDENDO, AJUSTE
    }

    public Transaccion(UUID id, TipoTransaccion tipo, BigDecimal monto, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
        this.descripcion = descripcion;
    }

    public UUID getId() {
        return id;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal calcularImpacto() {
        return tipo == TipoTransaccion.VENTA || tipo == TipoTransaccion.DIVIDENDO ? monto : monto.negate();
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/domain/ports/CarteraRepository.java ===
package com.inversiones.cartera.domain.ports;

import com.inversiones.cartera.domain.model.Cartera;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarteraRepository {
    
    Optional<Cartera> findById(UUID id);
    
    List<Cartera> findAll();
    
    Cartera save(Cartera cartera);
    
    void deleteById(UUID id);
    
    boolean existsById(UUID id);
    
    List<Cartera> findByNombreContainingIgnoreCase(String nombre);
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java ===
package com.inversiones.cartera.infrastructure.adapters;

import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.domain.model.Inversion;
import com.inversiones.cartera.domain.ports.CarteraRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaCarteraRepository implements CarteraRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Cartera> findById(UUID id) {
        CarteraEntity entity = entityManager.find(CarteraEntity.class, id);
        return Optional.ofNullable(entity).map(this::toDomain);
    }

    @Override
    public List<Cartera> findAll() {
        List<CarteraEntity> entities = entityManager
            .createQuery("SELECT c FROM CarteraEntity c", CarteraEntity.class)
            .getResultList();
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Cartera save(Cartera cartera) {
        if (cartera.getId() == null) {
            cartera = new Cartera(
                UUID.randomUUID(),
                cartera.getNombre(),
                cartera.getDescripcion(),
                cartera.getSaldoInicial(),
                LocalDateTime.now()
            );
        }
        CarteraEntity entity = toEntity(cartera);
        entityManager.persist(entity);
        return toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        CarteraEntity entity = entityManager.find(CarteraEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        CarteraEntity entity = entityManager.find(CarteraEntity.class, id);
        return entity != null;
    }

    @Override
    public List<Cartera> findByNombreContainingIgnoreCase(String nombre) {
        List<CarteraEntity> entities = entityManager
            .createQuery("SELECT c FROM CarteraEntity c WHERE LOWER(c.nombre) LIKE LOWER(:nombre)", CarteraEntity.class)
            .setParameter("nombre", "%" + nombre + "%")
            .getResultList();
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    private CarteraEntity toEntity(Cartera cartera) {
        CarteraEntity entity = new CarteraEntity();
        entity.setId(cartera.getId());
        entity.setNombre(cartera.getNombre());
        entity.setDescripcion(cartera.getDescripcion());
        entity.setSaldoInicial(cartera.getSaldoInicial());
        entity.setFechaCreacion(cartera.getFechaCreacion());
        
        if (cartera.getInversiones() != null) {
            List<InversionEntity> inversiones = cartera.getInversiones().stream()
                .map(this::toInversionEntity)
                .collect(Collectors.toList());
            entity.setInversiones(inversiones);
        }
        return entity;
    }

    private Cartera toDomain(CarteraEntity entity) {
        Cartera cartera = new Cartera(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getSaldoInicial(),
            entity.getFechaCreacion()
        );
        
        if (entity.getInversiones() != null) {
            for (InversionEntity invEntity : entity.getInversiones()) {
                cartera.agregarInversion(toInversionDomain(invEntity));
            }
        }
        return cartera;
    }

    private InversionEntity toInversionEntity(Inversion inversion) {
        InversionEntity entity = new InversionEntity();
        entity.setId(inversion.getId());
        entity.setNombre(inversion.getNombre());
        entity.setSimbolo(inversion.getSimbolo());
        entity.setCantidad(inversion.getCantidad());
        entity.setPrecioCompra(inversion.getPrecioCompra());
        entity.setFechaCompra(inversion.getFechaCompra());
        return entity;
    }

    private Inversion toInversionDomain(InversionEntity entity) {
        Inversion inversion = new Inversion(
            entity.getId(),
            entity.getNombre(),
            entity.getSimbolo(),
            entity.getCantidad(),
            entity.getPrecioCompra()
        );
        return inversion;
    }

    @Entity
    @Table(name = "carteras")
    public static class CarteraEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        
        @Column(nullable = false, length = 100)
        private String nombre;
        
        @Column(length = 500)
        private String descripcion;
        
        @Column(precision = 19, scale = 4)
        private BigDecimal saldoInicial;
        
        @Column(nullable = false)
        private LocalDateTime fechaCreacion;
        
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        @JoinColumn(name = "cartera_id")
        private List<InversionEntity> inversiones;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
        public BigDecimal getSaldoInicial() { return saldoInicial; }
        public void setSaldoInicial(BigDecimal saldoInicial) { this.saldoInicial = saldoInicial; }
        public LocalDateTime getFechaCreacion() { return fechaCreacion; }
        public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
        public List<InversionEntity> getInversiones() { return inversiones; }
        public void setInversiones(List<InversionEntity> inversiones) { this.inversiones = inversiones; }
    }

    @Entity
    @Table(name = "inversiones")
    public static class InversionEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        
        @Column(nullable = false, length = 100)
        private String nombre;
        
        @Column(length = 20)
        private String simbolo;
        
        @Column(precision = 19, scale = 6)
        private BigDecimal cantidad;
        
        @Column(precision = 19, scale = 4)
        private BigDecimal precioCompra;
        
        @Column(nullable = false)
        private LocalDateTime fechaCompra;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getSimbolo() { return simbolo; }
        public void setSimbolo(String simbolo) { this.simbolo = simbolo; }
        public BigDecimal getCantidad() { return cantidad; }
        public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
        public BigDecimal getPrecioCompra() { return precioCompra; }
        public void setPrecioCompra(BigDecimal precioCompra) { this.precioCompra = precioCompra; }
        public LocalDateTime getFechaCompra() { return fechaCompra; }
        public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/infrastructure/controllers/dto/CarteraRequest.java ===
package com.inversiones.cartera.infrastructure.controllers.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record CarteraRequest(
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    String nombre,
    
    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    String descripcion,
    
    @DecimalMin(value = "0.0", message = "El saldo inicial no puede ser negativo")
    BigDecimal saldoInicial,
    
    @Size(min = 3, max = 20, message = "El símbolo debe tener entre 3 y 20 caracteres")
    String simbolo,
    
    @DecimalMin(value = "0.000001", message = "La cantidad debe ser mayor a cero")
    BigDecimal cantidad,
    
    @DecimalMin(value = "0.01", message = "El precio de compra debe ser mayor a cero")
    BigDecimal precioCompra
) {
    public CarteraRequest {
        if (descripcion == null) {
            descripcion = "";
        }
        if (saldoInicial == null) {
            saldoInicial = BigDecimal.ZERO;
        }
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/infrastructure/controllers/dto/CarteraResponse.java ===
package com.inversiones.cartera.infrastructure.controllers.dto;

import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.domain.model.Inversion;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CarteraResponse(
    UUID id,
    String nombre,
    String descripcion,
    BigDecimal saldoInicial,
    BigDecimal saldoActual,
    LocalDateTime fechaCreacion,
    List<InversionResponse> inversiones
) {
    public static CarteraResponse fromEntity(Cartera cartera) {
        List<InversionResponse> inversionesResponse = cartera.getInversiones().stream()
            .map(InversionResponse::fromEntity)
            .toList();
        
        return new CarteraResponse(
            cartera.getId(),
            cartera.getNombre(),
            cartera.getDescripcion(),
            cartera.getSaldoInicial(),
            cartera.calcularSaldoActual(),
            cartera.getFechaCreacion(),
            inversionesResponse
        );
    }

    public static record InversionResponse(
        UUID id,
        String nombre,
        String simbolo,
        BigDecimal cantidad,
        BigDecimal precioCompra,
        BigDecimal valorActual,
        LocalDateTime fechaCompra
    ) {
        public static InversionResponse fromEntity(Inversion inversion) {
            return new InversionResponse(
                inversion.getId(),
                inversion.getNombre(),
                inversion.getSimbolo(),
                inversion.getCantidad(),
                inversion.getPrecioCompra(),
                inversion.calcularValorActual(),
                inversion.getFechaCompra()
            );
        }
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/infrastructure/controllers/dto/ErrorResponse.java ===
package com.inversiones.cartera.infrastructure.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
    int status,
    String error,
    String message,
    String path,
    LocalDateTime timestamp,
    Map<String, List<String>> validationErrors
) {
    public static ErrorResponse of(int status, String error, String message, String path) {
        return new ErrorResponse(status, error, message, path, LocalDateTime.now(), null);
    }

    public static ErrorResponse of(int status, String error, String message, String path, 
                                    Map<String, List<String>> validationErrors) {
        return new ErrorResponse(status, error, message, path, LocalDateTime.now(), validationErrors);
    }

    public static ErrorResponse notFound(String message, String path) {
        return of(404, "Not Found", message, path);
    }

    public static ErrorResponse badRequest(String message, String path) {
        return of(400, "Bad Request", message, path);
    }

    public static ErrorResponse internalError(String message, String path) {
        return of(500, "Internal Server Error", message, path);
    }

    public static ErrorResponse conflict(String message, String path) {
        return of(409, "Conflict", message, path);
    }

    public static ErrorResponse validationError(String message, String path, 
                                                 Map<String, List<String>> validationErrors) {
        return of(400, "Validation Error", message, path, validationErrors);
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java ===
package com.inversiones.cartera.application.usecases;

import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.domain.model.Inversion;
import com.inversiones.cartera.domain.ports.CarteraRepository;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraRequest;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CarteraService {

    private static final Logger log = LoggerFactory.getLogger(CarteraService.class);

    private final CarteraRepository carteraRepository;

    public CarteraService(CarteraRepository carteraRepository) {
        this.carteraRepository = carteraRepository;
    }

    public List<CarteraResponse> listarCarteras() {
        log.info("Listando todas las carteras");
        List<Cartera> carteras = carteraRepository.findAll();
        return carteras.stream()
            .map(CarteraResponse::fromEntity)
            .toList();
    }

    public Optional<CarteraResponse> obtenerCarteraPorId(UUID id) {
        log.info("Obteniendo cartera con id: {}", id);
        return carteraRepository.findById(id)
            .map(CarteraResponse::fromEntity);
    }

    public CarteraResponse crearCartera(@Valid CarteraRequest request) {
        log.info("Creando nueva cartera con nombre: {}", request.nombre());

        if (carteraRepository.existsByNombre(request.nombre())) {
            throw new IllegalArgumentException("Ya existe una cartera con el nombre: " + request.nombre());
        }

        Cartera cartera = new Cartera(
            UUID.randomUUID(),
            request.nombre(),
            request.descripcion(),
            request.saldoInicial() != null ? request.saldoInicial() : BigDecimal.ZERO
        );

        Cartera saved = carteraRepository.save(cartera);
        log.info("Cartera creada exitosamente con id: {}", saved.getId());
        return CarteraResponse.fromEntity(saved);
    }

    public Optional<CarteraResponse> actualizarCartera(UUID id, @Valid CarteraRequest request) {
        log.info("Actualizando cartera con id: {}", id);

        return carteraRepository.findById(id)
            .map(carteraExistente -> {
                boolean nombreDuplicado = carteraRepository.existsByNombreAndIdNot(
                    request.nombre(), id
                );
                if (nombreDuplicado) {
                    throw new IllegalArgumentException(
                        "Ya existe otra cartera con el nombre: " + request.nombre()
                    );
                }

                carteraExistente.setNombre(request.nombre());
                carteraExistente.setDescripcion(request.descripcion());
                if (request.saldoInicial() != null) {
                    carteraExistente.setSaldoInicial(request.saldoInicial());
                }

                Cartera updated = carteraRepository.save(carteraExistente);
                log.info("Cartera actualizada exitosamente: {}", id);
                return CarteraResponse.fromEntity(updated);
            });
    }

    public Optional<CarteraResponse> actualizarParcialCartera(UUID id, @Valid CarteraRequest request) {
        log.info("Actualizando parcialmente cartera con id: {}", id);

        return carteraRepository.findById(id)
            .map(carteraExistente -> {
                if (request.nombre() != null && !request.nombre().equals(carteraExistente.getNombre())) {
                    boolean nombreDuplicado = carteraRepository.existsByNombreAndIdNot(
                        request.nombre(), id
                    );
                    if (nombreDuplicado) {
                        throw new IllegalArgumentException(
                            "Ya existe otra cartera con el nombre: " + request.nombre()
                        );
                    }
                    carteraExistente.setNombre(request.nombre());
                }

                if (request.descripcion() != null) {
                    carteraExistente.setDescripcion(request.descripcion());
                }

                if (request.saldoInicial() != null) {
                    carteraExistente.setSaldoInicial(request.saldoInicial());
                }

                Cartera updated = carteraRepository.save(carteraExistente);
                log.info("Cartera actualizada parcialmente: {}", id);
                return CarteraResponse.fromEntity(updated);
            });
    }

    public boolean eliminarCartera(UUID id) {
        log.info("Eliminando cartera con id: {}", id);

        if (!carteraRepository.existsById(id)) {
            log.warn("Cartera no encontrada para eliminación: {}", id);
            return false;
        }

        carteraRepository.deleteById(id);
        log.info("Cartera eliminada exitosamente: {}", id);
        return true;
    }

    public Optional<CarteraResponse> agregarInversion(UUID carteraId, String nombreInversion, 
                                                       String simbolo, BigDecimal cantidad, 
                                                       BigDecimal precioCompra) {
        log.info("Agregando inversión a cartera {}: {} ({})", carteraId, nombreInversion, simbolo);

        return carteraRepository.findById(carteraId)
            .map(cartera -> {
                Inversion inversion = new Inversion(
                    UUID.randomUUID(),
                    nombreInversion,
                    simbolo,
                    cantidad,
                    precioCompra
                );
                inversion.setFechaCompra(LocalDateTime.now());

                cartera.agregarInversion(inversion);
                Cartera updated = carteraRepository.save(cartera);

                log.info("Inversión agregada exitosamente a cartera {}", carteraId);
                return CarteraResponse.fromEntity(updated);
            });
    }

    public Optional<CarteraResponse> eliminarInversion(UUID carteraId, UUID inversionId) {
        log.info("Eliminando inversión {} de cartera {}", inversionId, carteraId);

        return carteraRepository.findById(carteraId)
            .map(cartera -> {
                cartera.eliminarInversion(inversionId);
                Cartera updated = carteraRepository.save(cartera);

                log.info("Inversión {} eliminada de cartera {}", inversionId, carteraId);
                return CarteraResponse.fromEntity(updated);
            });
    }

    public Optional<BigDecimal> calcularSaldoActual(UUID carteraId) {
        log.info("Calculando saldo actual de cartera: {}", carteraId);

        return carteraRepository.findById(carteraId)
            .map(Cartera::calcularSaldoActual);
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/infrastructure/controllers/CarteraController.java ===
package com.inversiones.cartera.infrastructure.controllers;

import com.inversiones.cartera.application.usecases.CarteraService;
import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraRequest;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraResponse;
import com.inversiones.cartera.infrastructure.controllers.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/carteras")
@Tag(name = "Carteras", description = "API para gestión de carteras de inversión")
public class CarteraController {

    private final CarteraService carteraService;

    public CarteraController(CarteraService carteraService) {
        this.carteraService = carteraService;
    }

    @GetMapping
    @Operation(summary = "Listar todas las carteras", description = "Retorna una lista de todas las carteras de inversión registradas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de carteras obtenida exitosamente",
                     content = @Content(schema = @Schema(implementation = CarteraResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<List<CarteraResponse>> listarCarteras() {
        List<Cartera> carteras = carteraService.obtenerTodasCarteras();
        List<CarteraResponse> respuestas = carteras.stream()
                .map(CarteraResponse::fromDomain)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cartera por ID", description = "Retorna los detalles de una cartera específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cartera encontrada",
                     content = @Content(schema = @Schema(implementation = CarteraResponse.class))),
        @ApiResponse(responseCode = "404", description = "Cartera no encontrada",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CarteraResponse> obtenerCartera(
            @Parameter(description = "ID único de la cartera", required = true)
            @PathVariable UUID id) {
        Cartera cartera = carteraService.obtenerCarteraPorId(id);
        if (cartera == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CarteraResponse.fromDomain(cartera));
    }

    @PostMapping
    @Operation(summary = "Crear nueva cartera", description = "Crea una nueva cartera de inversión")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cartera creada exitosamente",
                     content = @Content(schema = @Schema(implementation = CarteraResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CarteraResponse> crearCartera(
            @Valid @RequestBody CarteraRequest request) {
        Cartera carteraCreada = carteraService.crearCartera(request);
        CarteraResponse response = CarteraResponse.fromDomain(carteraCreada);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carteraCreada.getId())
                .toUri();
        
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar cartera completamente", description = "Reemplaza todos los campos de una cartera existente (idempotente)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cartera actualizada exitosamente",
                     content = @Content(schema = @Schema(implementation = CarteraResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", descripción = "Cartera no encontrada",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CarteraResponse> actualizarCartera(
            @Parameter(description = "ID único de la cartera", required = true)
            @PathVariable UUID id,
            @Valid @RequestBody CarteraRequest request) {
        Cartera carteraActualizada = carteraService.actualizarCartera(id, request);
        if (carteraActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CarteraResponse.fromDomain(carteraActualizada));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cartera", description = "Elimina una cartera de inversión por su ID (idempotente)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cartera eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cartera no encontrada",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Void> eliminarCartera(
            @Parameter(description = "ID único de la cartera", required = true)
            @PathVariable UUID id) {
        boolean eliminada = carteraService.eliminarCartera(id);
        if (!eliminada) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

// === ARCHIVO: src/main/java/com/inversiones/cartera/infrastructure/controllers/GlobalExceptionHandler.java ===
package com.inversiones.cartera.infrastructure.controllers;

import com.inversiones.cartera.infrastructure.controllers.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> manejarValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> errores = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage() != null 
                                ? error.getDefaultMessage() 
                                : "Valor inválido",
                        (existing, replacement) -> existing
                ));

        String mensaje = "Error de validación en los campos: " + String.join(", ", errores.keySet());
        logger.warn("Validación fallida: {}", errores);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(mensaje)
                .detalles(errores)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> manejarNoEncontrado(NoSuchElementException ex) {
        logger.warn("Recurso no encontrado: {}", ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> manejarEliminacionNoExistente(EmptyResultDataAccessException ex) {
        logger.warn("Intento de eliminar recurso que no existe: {}", ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message("El recurso que intenta eliminar no existe")
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> manejarViolacionIntegridad(DataIntegrityViolationException ex) {
        logger.error("Violación de integridad de datos: {}", ex.getMessage());

        String mensaje = "Violación de integridad de datos. Verifique que no existan dependencias asociadas.";
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error("Conflict")
                .message(mensaje)
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> manejarMensajeIlegible(HttpMessageNotReadableException ex) {
        logger.warn("Mensaje HTTP no legible: {}", ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message("El cuerpo de la solicitud no es válido o está mal formado")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> manejarTipoIncorrecto(MethodArgumentTypeMismatchException ex) {
        logger.warn("Tipo de argumento incorrecto: {} - valor: {}", 
                    ex.getName(), ex.getValue());

        String mensaje = String.format("El parámetro '%s' expects a valid %s value, but got '%s'",
                ex.getName(),
                ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "value",
                ex.getValue());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(mensaje)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> manejarArgumentoIlegal(IllegalArgumentException ex) {
        logger.warn("Argumento ilegal: {}", ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> manejarExcepcionGeneral(Exception ex) {
        logger.error("Error interno del servidor: ", ex);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message("Ha ocurrido un error inesperado. Por favor, contacte al administrador.")
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

// === ARCHIVO: src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java ===
package com.inversiones.cartera.infrastructure.controllers;

import com.inversiones.cartera.application.usecases.CarteraService;
import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraRequest;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarteraController.class)
class CarteraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarteraService carteraService;

    private Cartera carteraMock;
    private CarteraResponse carteraResponse;
    private CarteraRequest carteraRequest;

    @BeforeEach
    void setUp() {
        UUID carteraId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        carteraMock = new Cartera(
            carteraId,
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00"),
            LocalDateTime.now()
        );

        carteraResponse = new CarteraResponse(
            carteraId,
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00"),
            LocalDateTime.now(),
            List.of()
        );

        carteraRequest = new CarteraRequest(
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00")
        );
    }

    @Test
    @DisplayName("GET /api/carteras debe retornar todas las carteras")
    void testObtenerTodasLasCarteras() throws Exception {
        when(carteraService.obtenerTodas()).thenReturn(List.of(carteraResponse));

        mockMvc.perform(get("/api/carteras"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(carteraResponse.id().toString()))
            .andExpect(jsonPath("$[0].nombre").value("Cartera Principal"))
            .andExpect(jsonPath("$[0].saldoInicial").value(100000.00));
    }

    @Test
    @DisplayName("GET /api/carteras/{id} debe retornar una cartera por su ID")
    void testObtenerCarteraPorId() throws Exception {
        UUID carteraId = carteraMock.getId();
        when(carteraService.obtenerPorId(carteraId)).thenReturn(java.util.Optional.of(carteraResponse));

        mockMvc.perform(get("/api/carteras/" + carteraId.toString()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(carteraId.toString()))
            .andExpect(jsonPath("$.nombre").value("Cartera Principal"));
    }

    @Test
    @DisplayName("GET /api/carteras/{id} debe retornar 404 cuando la cartera no existe")
    void testObtenerCarteraPorIdNoExistente() throws Exception {
        UUID carteraId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        when(carteraService.obtenerPorId(carteraId)).thenReturn(java.util.Optional.empty());

        mockMvc.perform(get("/api/carteras/" + carteraId.toString()))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/carteras debe crear una nueva cartera")
    void testCrearCartera() throws Exception {
        when(carteraService.crear(any(CarteraRequest.class))).thenReturn(carteraResponse);

        mockMvc.perform(post("/api/carteras")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Cartera Principal\",\"descripcion\":\"Cartera de inversiones a largo plazo\",\"saldoInicial\":100000.00}"))
            .andExpect(status().isCreated())
            .andExpect(header().exists("Location"))
            .andExpect(jsonPath("$.nombre").value("Cartera Principal"));
    }

    @Test
    @DisplayName("POST /api/carteras debe retornar 400 cuando los datos son inválidos")
    void testCrearCarteraDatosInvalidos() throws Exception {
        when(carteraService.crear(any(CarteraRequest.class))).thenReturn(carteraResponse);

        mockMvc.perform(post("/api/carteras")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"\",\"descripcion\":\"\",\"saldoInicial\":-100}"))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("PUT /api/carteras/{id} debe actualizar completamente una cartera")
    void testActualizarCartera() throws Exception {
        UUID carteraId = carteraMock.getId();
        when(carteraService.actualizar(eq(carteraId), any(CarteraRequest.class))).thenReturn(carteraResponse);

        mockMvc.perform(put("/api/carteras/" + carteraId.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Cartera Actualizada\",\"descripcion\":\"Nueva descripcion\",\"saldoInicial\":200000.00}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Cartera Principal"));
    }

    @Test
    @DisplayName("DELETE /api/carteras/{id} debe eliminar una cartera")
    void testEliminarCartera() throws Exception {
        UUID carteraId = carteraMock.getId();
        doNothing().when(carteraService).eliminar(carteraId);

        mockMvc.perform(delete("/api/carteras/" + carteraId.toString()))
            .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /api/carteras/{id} debe retornar 404 cuando la cartera no existe")
    void testEliminarCarteraNoExistente() throws Exception {
        UUID carteraId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        doNothing().when(carteraService).eliminar(carteraId);

        mockMvc.perform(delete("/api/carteras/" + carteraId.toString()))
            .andExpect(status().isNoContent());
    }
}

// === ARCHIVO: src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java ===
package com.inversiones.cartera.application.usecases;

import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.domain.model.Inversion;
import com.inversiones.cartera.domain.ports.CarteraRepository;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraRequest;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarteraServiceTest {

    @Mock
    private CarteraRepository carteraRepository;

    @InjectMocks
    private CarteraService carteraService;

    private Cartera carteraMock;
    private CarteraRequest carteraRequest;
    private UUID carteraId;

    @BeforeEach
    void setUp() {
        carteraId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        carteraMock = new Cartera(
            carteraId,
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00"),
            LocalDateTime.of(2024, 1, 15, 10, 30)
        );

        Inversion inversionMock = new Inversion(
            UUID.fromString("550e8400-e29b-41d4-a716-446655440001"),
            "Apple Inc.",
            "AAPL",
            new BigDecimal("50"),
            new BigDecimal("150.00")
        );
        carteraMock.agregarInversion(inversionMock);

        carteraRequest = new CarteraRequest(
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00")
        );
    }

    @Test
    @DisplayName("obtenerTodas debe retornar lista de carteras")
    void testObtenerTodas() {
        when(carteraRepository.findAll()).thenReturn(List.of(carteraMock));

        List<CarteraResponse> result = carteraService.obtenerTodas();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Cartera Principal", result.get(0).nombre());
        verify(carteraRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("obtenerTodas debe retornar lista vacía cuando no hay carteras")
    void testObtenerTodasVacia() {
        when(carteraRepository.findAll()).thenReturn(List.of());

        List<CarteraResponse> result = carteraService.obtenerTodas();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(carteraRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("obtenerPorId debe retornar cartera cuando existe")
    void testObtenerPorIdExistente() {
        when(carteraRepository.findById(carteraId)).thenReturn(Optional.of(carteraMock));

        Optional<CarteraResponse> result = carteraService.obtenerPorId(carteraId);

        assertTrue(result.isPresent());
        assertEquals(carteraId, result.get().id());
        assertEquals("Cartera Principal", result.get().nombre());
        verify(carteraRepository, times(1)).findById(carteraId);
    }

    @Test
    @DisplayName("obtenerPorId debe retornar Optional.empty cuando no existe")
    void testObtenerPorIdNoExistente() {
        UUID idNoExistente = UUID.fromString("550e8400-e29b-41d4-a716-446655440099");
        when(carteraRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        Optional<CarteraResponse> result = carteraService.obtenerPorId(idNoExistente);

        assertFalse(result.isPresent());
        verify(carteraRepository, times(1)).findById(idNoExistente);
    }

    @Test
    @DisplayName("crear debe persistir y retornar la cartera creada")
    void testCrearCartera() {
        when(carteraRepository.save(any(Cartera.class))).thenReturn(carteraMock);

        CarteraResponse result = carteraService.crear(carteraRequest);

        assertNotNull(result);
        assertEquals("Cartera Principal", result.nombre());
        assertEquals(new BigDecimal("100000.00"), result.saldoInicial());
        verify(carteraRepository, times(1)).save(any(Cartera.class));
    }

    @Test
    @DisplayName("crear debe asignar ID y fecha de creación")
    void testCrearCarteraAsignaIdYFecha() {
        when(carteraRepository.save(any(Cartera.class))).thenAnswer(invocation -> {
            Cartera cartera = invocation.getArgument(0);
            assertNotNull(cartera.getId(), "El ID debe ser asignado");
            assertNotNull(cartera.getFechaCreacion(), "La fecha de creación debe ser asignada");
            return cartera;
        });

        carteraService.crear(carteraRequest);

        verify(carteraRepository, times(1)).save(any(Cartera.class));
    }

    @Test
    @DisplayName("actualizar debe modificar datos y retornar la cartera actualizada")
    void testActualizarCartera() {
        when(carteraRepository.findById(carteraId)).thenReturn(Optional.of(carteraMock));
        when(carteraRepository.save(any(Cartera.class))).thenReturn(carteraMock);

        CarteraRequest updateRequest = new CarteraRequest(
            "Cartera Actualizada",
            "Nueva descripción",
            new BigDecimal("200000.00")
        );

        CarteraResponse result = carteraService.actualizar(carteraId, updateRequest);

        assertNotNull(result);
        verify(carteraRepository, times(1)).findById(carteraId);
        verify(carteraRepository, times(1)).save(any(Cartera.class));
    }

    @Test
    @DisplayName("actualizar debe lanzar excepción cuando la cartera no existe")
    void testActualizarCarteraNoExistente() {
        UUID idNoExistente = UUID.fromString("550e8400-e29b-41d4-a716-446655440099");
        when(carteraRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        assertThrows(
            RuntimeException.class,
            () -> carteraService.actualizar(idNoExistente, carteraRequest)
        );

        verify(carteraRepository, times(1)).findById(idNoExistente);
        verify(carteraRepository, never()).save(any(Cartera.class));
    }

    @Test
    @DisplayName("eliminar debe borrar la cartera existente")
    void testEliminarCarteraExistente() {
        when(carteraRepository.findById(carteraId)).thenReturn(Optional.of(carteraMock));
        doNothing().when(carteraRepository).delete(carteraMock);

        assertDoesNotThrow(() -> carteraService.eliminar(carteraId));

        verify(carteraRepository, times(1)).findById(carteraId);
        verify(carteraRepository, times(1)).delete(carteraMock);
    }

    @Test
    @DisplayName("eliminar debe lanzar excepción cuando la cartera no existe")
    void testEliminarCarteraNoExistente() {
        UUID idNoExistente = UUID.fromString("550e8400-e29b-41d4-a716-446655440099");
        when(carteraRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        assertThrows(
            RuntimeException.class,
            () -> carteraService.eliminar(idNoExistente)
        );

        verify(carteraRepository, times(1)).findById(idNoExistente);
        verify(carteraRepository, never()).delete(any(Cartera.class));
    }

    @Test
    @DisplayName("calcularSaldoActual debe retornar el saldo con ganancias")
    void testCalcularSaldoActual() {
        when(carteraRepository.findById(carteraId)).thenReturn(Optional.of(carteraMock));

        Optional<BigDecimal> result = carteraService.calcularSaldoActual(carteraId);

        assertTrue(result.isPresent());
        assertTrue(result.get().compareTo(new BigDecimal("100000.00")) > 0,
            "El saldo actual debe ser mayor al inicial por las inversiones");
    }

    @Test
    @DisplayName("calcularSaldoActual debe retornar Optional.empty para cartera inexistente")
    void testCalcularSaldoActualCarteraNoExistente() {
        UUID idNoExistente = UUID.fromString("550e8400-e29b-41d4-a716-446655440099");
        when(carteraRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        Optional<BigDecimal> result = carteraService.calcularSaldoActual(idNoExistente);

        assertFalse(result.isPresent());
    }
}
```
