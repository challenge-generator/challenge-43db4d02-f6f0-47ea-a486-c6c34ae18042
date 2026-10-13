# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de un Servicio REST Avanzado**.

| | |
|---|---|
| Tema | Construcción de Servicios REST Robustos y Escalables |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar con separación de dominio e infraestructura |
| Tiempo estimado | 2 semanas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.projectlombok:lombok 1.18.30
- com.h2database:h2 2.2.224
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.5.0
- org.mockito:mockito-core 5.11.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición de Entidades y Requisitos**: Documento de requisitos funcionales con entidades y verbos HTTP definidos.
- **Fase 2 — Diseño de la API**: Diseño de la API con endpoints, parámetros y respuestas documentados.
- **Fase 3 — Implementación y Validación**: Servicio REST implementado y documentado, con pruebas de validación.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (43)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/inversiones/cartera/infrastructure/controllers/dto/ErrorResponse.java` — `com.fasterxml.jackson`
      El import com.fasterxml.jackson.annotation.JsonInclude pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/controllers/CarteraController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/controllers/GlobalExceptionHandler.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setId`
      Se invoca `setId` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setNombre`
      Se invoca `setNombre` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setDescripcion`
      Se invoca `setDescripcion` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setSaldoInicial`
      Se invoca `setSaldoInicial` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setFechaCreacion`
      Se invoca `setFechaCreacion` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setInversiones`
      Se invoca `setInversiones` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getId`
      Se invoca `getId` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getNombre`
      Se invoca `getNombre` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getDescripcion`
      Se invoca `getDescripcion` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getSaldoInicial`
      Se invoca `getSaldoInicial` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getFechaCreacion`
      Se invoca `getFechaCreacion` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getInversiones`
      Se invoca `getInversiones` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setSimbolo`
      Se invoca `setSimbolo` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setCantidad`
      Se invoca `setCantidad` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setPrecioCompra`
      Se invoca `setPrecioCompra` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.setFechaCompra`
      Se invoca `setFechaCompra` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getSimbolo`
      Se invoca `getSimbolo` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getCantidad`
      Se invoca `getCantidad` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java` — `InversionEntity.getPrecioCompra`
      Se invoca `getPrecioCompra` sobre `InversionEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java` — `CarteraRepository.existsByNombre`
      Se invoca `existsByNombre` sobre `CarteraRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java` — `CarteraRepository.existsByNombreAndIdNot`
      Se invoca `existsByNombreAndIdNot` sobre `CarteraRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java` — `Inversion.setFechaCompra`
      Se invoca `setFechaCompra` sobre `Inversion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/inversiones/cartera/infrastructure/controllers/CarteraController.java` — `CarteraService.obtenerTodasCarteras`
      Se invoca `obtenerTodasCarteras` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraService.obtenerTodas`
      Se invoca `obtenerTodas` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraResponse.id`
      Se invoca `id` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraService.obtenerPorId`
      Se invoca `obtenerPorId` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraService.crear`
      Se invoca `crear` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java` — `CarteraService.actualizar`
      Se invoca `actualizar` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.obtenerTodas`
      Se invoca `obtenerTodas` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.size`
      Se invoca `size` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.get`
      Se invoca `get` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.isEmpty`
      Se invoca `isEmpty` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.obtenerPorId`
      Se invoca `obtenerPorId` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.isPresent`
      Se invoca `isPresent` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.crear`
      Se invoca `crear` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.nombre`
      Se invoca `nombre` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraResponse.saldoInicial`
      Se invoca `saldoInicial` sobre `CarteraResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.actualizar`
      Se invoca `actualizar` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java` — `CarteraService.eliminar`
      Se invoca `eliminar` sobre `CarteraService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (16)

- `pom.xml`
- `src/main/java/com/inversiones/cartera/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/inversiones/cartera/domain/model/Cartera.java`
- `src/main/java/com/inversiones/cartera/domain/model/Inversion.java`
- `src/main/java/com/inversiones/cartera/domain/model/Transaccion.java`
- `src/main/java/com/inversiones/cartera/domain/ports/CarteraRepository.java`
- `src/main/java/com/inversiones/cartera/infrastructure/adapters/JpaCarteraRepository.java`
- `src/main/java/com/inversiones/cartera/infrastructure/controllers/dto/CarteraRequest.java`
- `src/main/java/com/inversiones/cartera/infrastructure/controllers/dto/CarteraResponse.java`
- `src/main/java/com/inversiones/cartera/infrastructure/controllers/dto/ErrorResponse.java`
- `src/main/java/com/inversiones/cartera/application/usecases/CarteraService.java`
- `src/main/java/com/inversiones/cartera/infrastructure/controllers/CarteraController.java`
- `src/main/java/com/inversiones/cartera/infrastructure/controllers/GlobalExceptionHandler.java`
- `src/test/java/com/inversiones/cartera/infrastructure/controllers/CarteraControllerTest.java`
- `src/test/java/com/inversiones/cartera/application/usecases/CarteraServiceTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/inversiones/cartera`
- `src/main/java/com/inversiones/cartera/domain`
- `src/main/java/com/inversiones/cartera/domain/model`
- `src/main/java/com/inversiones/cartera/domain/ports`
- `src/main/java/com/inversiones/cartera/application`
- `src/main/java/com/inversiones/cartera/application/usecases`
- `src/main/java/com/inversiones/cartera/infrastructure`
- `src/main/java/com/inversiones/cartera/infrastructure/adapters`
- `src/main/java/com/inversiones/cartera/infrastructure/controllers`
- `src/main/resources`
- `src/test/java/com/inversiones/cartera`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar con separación de dominio e infraestructura**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced
- Brecha que el reto ataca: Desarrolla servicios REST que cumplan con los estándares: Utiliza adecuadamente con los códigos de estado HTTP (1xx, 2xx, 3xx, 4xx, 5xx), manejar los cuatro verbos principales (GET, POST, PUT, DELETE), comprende la diferencia entre PUT y PATCH y entiende la propiedad de idempotencia.
- Mision: Candidato con experiencia avanzada en Backend.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
