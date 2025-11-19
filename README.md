# Direccions Library ✅

**Estado: COMPLETADO Y LISTO PARA PRODUCCIÓN**

Librería reutilizable para gestión de direcciones que incluye países, comunidades autónomas, provincias, municipios, códigos postales y tipos de vía.

## 🚀 Estado del Proyecto

✅ **Completado** - La librería está 100% funcional y lista para usar

### ✅ Características Implementadas

- ✅ Gestión completa de direcciones españolas
- ✅ API REST endpoints (`/api/v1/direccions/*`)
- ✅ Capa de servicio completa (`DireccioService`)
- ✅ Repositorios Spring Data JPA
- ✅ Mappers con MapStruct
- ✅ Auto-configuración de Spring Boot
- ✅ Entidades JPA configuradas
- ✅ DTOs optimizados
- ✅ Tests unitarios
- ✅ Base de datos configurable (PostgreSQL, H2, etc.)
- ✅ Scripts SQL de ejemplo
- ✅ Documentación completa

### 🏗️ Arquitectura

```
API Layer (REST Controllers)
    ↓
Service Layer (Business Logic)
    ↓
Repository Layer (Data Access)
    ↓
Database (PostgreSQL/H2)
```

### 📦 Publicación Exitosa

```bash
# ✅ Librería publicada en repositorio local Maven
./gradlew publishToMavenLocal

# ✅ Build exitoso
BUILD SUCCESSFUL in 1s
6 actionable tasks: 5 executed, 1 up-to-date
```

## Instalación

### Gradle

```gradle
implementation 'io.eduardnol:direccions-lib:1.0.0'
```

### Maven

```xml
<dependency>
    <groupId>io.eduardnol</groupId>
    <artifactId>direccions-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Configuración

### 1. Configuración de Base de Datos

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/your_database
    username: your_username
    password: your_password
    driver-class-name: org.postgresql.Driver
  
  jpa:
    hibernate:
      ddl-auto: none
    database-platform: org.hibernate.dialect.PostgreSQLDialect
```

### 2. Habilitar Auto-configuración

La librería se auto-configura automáticamente. Solo necesitas añadir la dependencia y configurar la base de datos.

### 3. Escaneo de Componentes (Opcional)

Si tu aplicación principal no está en el package `io.eduardnol`, añade:

```java
@SpringBootApplication
@ComponentScan(basePackages = {"com.tu.app", "io.eduardnol.direccions"})
public class TuAplicacion {
    public static void main(String[] args) {
        SpringApplication.run(TuAplicacion.class, args);
    }
}
```

## Uso

### API Endpoints

La librería expone los siguientes endpoints:

- `GET /api/v1/direccions/pais` - Obtener todos los países
- `GET /api/v1/direccions/comunitat-autonoma/{idPais}` - Obtener comunidades autónomas por país
- `GET /api/v1/direccions/provincia/{idComunitatAutonoma}` - Obtener provincias por comunidad autónoma
- `GET /api/v1/direccions/municipi/{idProvincia}` - Obtener municipios por provincia
- `GET /api/v1/direccions/tipus-via` - Obtener tipos de vía
- `POST /api/v1/direccions/codi-postal/check` - Verificar código postal
- `GET /api/v1/direccions/comarca/{idMunicipi}` - Obtener comarca por municipio

### Uso Programático

```java
@Autowired
private DireccioService direccioService;

// Obtener todos los países
List<ComboCodeDTO> paisos = direccioService.getAllPais();

// Obtener comunidades autónomas de España (idPais = 1)
List<ComboCodeDTO> comunitats = direccioService.getComunitatAutonomaByPais(1L);

// Verificar código postal
CheckCodiPostalDTO check = CheckCodiPostalDTO.builder()
    .idMunicipi(123L)
    .codiPostal("08001")
    .build();
Long idCodiPostal = direccioService.checkCodiPostal(check);
```

## Estructura de la Base de Datos

La librería espera las siguientes tablas:

- `md_pais` - Países
- `md_comunitat_autonoma` - Comunidades Autónomas
- `md_provincia` - Provincias
- `md_municipi` - Municipios
- `md_codi_postal` - Códigos Postales
- `md_tipus_via` - Tipos de Vía
- `md_direccio` - Direcciones

## Desarrollo

### Build

```bash
./gradlew build
```

### Tests

```bash
./gradlew test
```

### Publicación

```bash
./gradlew publish
```

## Requisitos

- Java 17+
- Spring Boot 3.x
- PostgreSQL o H2 (para testing)

## Licencia

Apache License 2.0
