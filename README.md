# Implementación de un Servicio REST Avanzado

El equipo de desarrollo de una plataforma de gestión de inversiones necesita un servicio REST que maneje operaciones CRUD para entidades de cartera. El servicio debe cumplir con los estándares de REST, utilizando adecuadamente los códigos de estado HTTP y manejando los verbos GET, POST, PUT y DELETE. Además, debe comprender la diferencia entre PUT y PATCH y asegurar la idempotencia en las operaciones apropiadas.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Construcción de Servicios REST Robustos y Escalables |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 2 semanas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición de Entidades y Requisitos

**Objetivo:** Establecer las entidades y los requisitos funcionales del servicio REST.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Identificar las entidades clave del dominio (ej. Cartera, Inversión, Transacción).
- Definir los requisitos funcionales para cada entidad, incluyendo los verbos HTTP y los códigos de estado apropiados.

**Entregable:** Documento de requisitos funcionales con entidades y verbos HTTP definidos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la granularidad de los recursos y la semántica de los verbos HTTP.

</details>

### Fase 2: Diseño de la API

**Objetivo:** Diseñar la estructura de la API REST basada en los requisitos funcionales.

**Tiempo estimado:** 4 días

**Instrucciones:**

- Crear un diseño de la API que incluya endpoints, parámetros y respuestas esperadas.
- Asegurar que los endpoints sean idempotentes cuando sea aplicable.

**Entregable:** Diseño de la API con endpoints, parámetros y respuestas documentados.

<details>
<summary>Pistas de conocimiento</summary>

- Reflexiona sobre la idempotencia y cómo se aplica a los endpoints.

</details>

### Fase 3: Implementación y Validación

**Objetivo:** Implementar el servicio REST y validar su funcionamiento.

**Tiempo estimado:** 5 días

**Instrucciones:**

- Implementar los endpoints definidos en la fase anterior.
- Realizar pruebas para validar que los endpoints funcionan según lo esperado y que los códigos de estado HTTP son correctos.

**Entregable:** Servicio REST implementado y documentado, con pruebas de validación.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza herramientas de testing para validar la funcionalidad y la idempotencia de los endpoints.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los códigos de estado HTTP y cómo se utilizan en una API REST?
- **paraQueSirve**: ¿Para qué se utilizan los verbos HTTP en una API REST?
- **comoSeUsa**: ¿Cómo se asegura la idempotencia en los endpoints de una API REST?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar una API REST y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones de diseño implica la implementación de una API REST robusta y escalable?

## Criterios de Evaluacion

- Implementación correcta de los endpoints con los verbos HTTP apropiados.
- Uso adecuado de los códigos de estado HTTP.
- Aseguramiento de la idempotencia en los endpoints relevantes.
- Validación exhaustiva del servicio REST mediante pruebas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
