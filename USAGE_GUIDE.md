# Guía Completa de Uso - Direccions Library

## 🎯 Resumen

Has creado exitosamente una librería Java reutilizable para gestión de direcciones españolas que incluye:

- ✅ **Entidades JPA**: País, Comunidad Autónoma, Provincia, Municipio, Código Postal, Tipo de Vía, Dirección
- ✅ **Repositorios Spring Data JPA** con consultas específicas
- ✅ **Servicios** con lógica de negocio
- ✅ **Mappers MapStruct** para conversión DTO ↔ Entity
- ✅ **API REST** completa con endpoints
- ✅ **Auto-configuración Spring Boot**
- ✅ **Tests unitarios**
- ✅ **Scripts SQL** de ejemplo

## 📦 Publicación

### 1. Repositorio Local (para testing)
```bash
cd /home/eduardo.nolla/code/direccions-lib
./gradlew publishToMavenLocal
```

### 2. Repositorio Privado
```bash
# Configura gradle.properties con tus credenciales
./gradlew publish
```

### 3. GitHub Packages
```bash
# Configura variables de entorno
export GITHUB_USERNAME=tu-usuario
export GITHUB_TOKEN=tu-token
./gradlew publish
```

## 🔧 Instalación en Otros Proyectos

### Gradle
```groovy
dependencies {
    implementation 'io.eduardnol:direccions-lib:1.0.0'
}
```

### Maven
```xml
<dependency>
    <groupId>io.eduardnol</groupId>
    <artifactId>direccions-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

## ⚙️ Configuración del Proyecto Consumidor

### 1. Base de Datos (application.yml)
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/tu_bbdd
    username: tu_usuario
    password: tu_password
    driver-class-name: org.postgresql.Driver
  
  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect

# Configuración del schema de direcciones (IMPORTANTE para datos maestros)
direccions:
  schema: public  # Cambia esto si tus tablas están en otro schema
```

### 1.1 Configuración del Schema de Base de Datos

La librería permite configurar fácilmente el schema donde están ubicadas las tablas de direcciones. Esto es especialmente útil para datos maestros que pueden estar en schemas separados.

**Opciones de configuración:**

```yaml
# Usar el schema por defecto (public)
direccions:
  schema: public

# Usar un schema personalizado para datos maestros
direccions:
  schema: maestros

# Ejemplo con schema de producción
direccions:
  schema: md_produccion
```

**En application.properties:**
```properties
# Schema por defecto
direccions.schema=public

# Schema personalizado
direccions.schema=maestros
```

**Nota:** Si no se especifica ningún valor, la librería usará el schema `public` por defecto.

### 2. Aplicación Principal
```java
@SpringBootApplication
public class TuAplicacion {
    public static void main(String[] args) {
        SpringApplication.run(TuAplicacion.class, args);
    }
}
```

## 🚀 Uso de la Librería

### API REST Endpoints
```bash
# Obtener todos los países
GET /api/v1/direccions/pais

# Obtener comunidades autónomas por país
GET /api/v1/direccions/comunitat-autonoma/1

# Obtener provincias por comunidad autónoma
GET /api/v1/direccions/provincia/1

# Obtener municipios por provincia
GET /api/v1/direccions/municipi/1

# Obtener tipos de vía
GET /api/v1/direccions/tipus-via

# Verificar código postal
POST /api/v1/direccions/codi-postal/check
{
  "idMunicipi": 1,
  "codiPostal": "08001"
}

# Obtener comarca por municipio
GET /api/v1/direccions/comarca/1
```

### Uso Programático
```java
@RestController
public class MiControlador {
    
    @Autowired
    private DireccioService direccioService;
    
    @GetMapping("/ejemplo")
    public ResponseEntity<List<ComboCodeDTO>> ejemplo() {
        // Obtener todos los países
        List<ComboCodeDTO> paisos = direccioService.getAllPais();
        
        // Obtener comunidades autónomas de España
        List<ComboCodeDTO> comunitats = direccioService.getComunitatAutonomaByPais(1L);
        
        // Verificar código postal
        CheckCodiPostalDTO check = CheckCodiPostalDTO.builder()
            .idMunicipi(1L)
            .codiPostal("08001")
            .build();
        Long idCodiPostal = direccioService.checkCodiPostal(check);
        
        return ResponseEntity.ok(paisos);
    }
}
```

### Acceso Directo a Repositorios
```java
@Service
public class MiServicio {
    
    @Autowired
    private PaisRepository paisRepository;
    
    @Autowired
    private MunicipiRepository municipiRepository;
    
    public Optional<PaisEntity> buscarPaisPorCodigo(String codigo) {
        return paisRepository.findByCodi(codigo);
    }
    
    public List<MunicipiEntity> buscarMunicipiosPorProvincia(Long idProvincia) {
        return municipiRepository.findAllByProvinciaIdProvinciaOrderByNom(idProvincia);
    }
}
```

## 🗄️ Estructura de Base de Datos

Ejecuta el script SQL proporcionado para crear las tablas:

```sql
-- Ver archivo: src/main/resources/schema-example.sql
```

### Tablas Principales:
- `md_pais`
- `md_comunitat_autonoma`
- `md_provincia`
- `md_municipi`
- `md_codi_postal`
- `md_tipus_via`
- `md_direccio`

### Importante: Schema de las Tablas

Todas las tablas de la librería se crearán y consultarán en el schema configurado mediante la propiedad `direccions.schema`. 

**Ejemplo:** Si configuras `direccions.schema=maestros`, la librería buscará las tablas en:
- `maestros.md_pais`
- `maestros.md_comunitat_autonoma`
- `maestros.md_provincia`
- etc.

Asegúrate de que el usuario de la base de datos tenga permisos sobre el schema configurado.

## 🧪 Testing

### Tests Incluidos
- Tests unitarios de servicios
- Tests de mappers
- Tests de integración con H2

### Ejecutar Tests
```bash
./gradlew test
```

## 📋 Estructura del Proyecto

```
direccions-lib/
├── src/main/java/io/eduardnol/direccions/
│   ├── config/           # Auto-configuración
│   ├── controller/       # API REST
│   ├── dto/             # DTOs
│   ├── entity/          # Entidades JPA
│   ├── mapper/          # MapStruct mappers
│   ├── repository/      # Repositorios Spring Data
│   └── service/         # Servicios de negocio
├── src/main/resources/
│   ├── META-INF/        # Auto-configuración Spring
│   ├── application.properties
│   └── schema-example.sql
├── src/test/            # Tests
├── build.gradle         # Configuración Gradle
└── README.md           # Documentación
```

## 🔄 Versionado

Para nuevas versiones:
1. Actualiza `version` en `build.gradle`
2. Ejecuta `./gradlew publish`
3. Actualiza la dependencia en proyectos consumidores

## ⚡ Características Técnicas

- **Java 21+** compatibilidad
- **Spring Boot 3.x**
- **PostgreSQL** como base de datos principal
- **H2** para testing
- **MapStruct** para mapping automático
- **Lombok** para reducir boilerplate
- **Maven/Gradle** compatible

## 🎉 ¡Listo para Producción!

Tu librería `direccions-lib` está completamente lista para ser usada en producción. Incluye todas las capas desde API hasta persistencia, es totalmente configurable y reutilizable.

### Próximos Pasos:
1. ✅ Publicar en tu repositorio privado
2. ✅ Usar en otros proyectos
3. ✅ Crear más versiones según necesidades
4. ✅ Añadir nuevas funcionalidades si es necesario
