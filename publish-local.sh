#!/bin/bash

# Ejemplo de uso de la librería direccions-lib

echo "📦 Publicando la librería direccions-lib..."

# Publicar al repositorio local para testing
./gradlew publishToMavenLocal

echo "✅ Librería publicada en repositorio local Maven"

echo "📋 Para usar la librería en otro proyecto:"
echo ""
echo "1. Añade la dependencia en build.gradle:"
echo "   implementation 'io.eduardnol:direccions-lib:1.0.0'"
echo ""
echo "2. Configura tu base de datos en application.yml:"
echo "   spring:"
echo "     datasource:"
echo "       url: jdbc:postgresql://localhost:5432/tu_bbdd"
echo "       username: tu_usuario"
echo "       password: tu_password"
echo ""
echo "3. Los endpoints estarán disponibles en:"
echo "   GET  /api/v1/direccions/pais"
echo "   GET  /api/v1/direccions/comunitat-autonoma/{idPais}"
echo "   GET  /api/v1/direccions/provincia/{idComunitatAutonoma}"
echo "   GET  /api/v1/direccions/municipi/{idProvincia}"
echo "   GET  /api/v1/direccions/tipus-via"
echo "   POST /api/v1/direccions/codi-postal/check"
echo "   GET  /api/v1/direccions/comarca/{idMunicipi}"
echo ""
echo "4. También puedes usar el servicio directamente:"
echo "   @Autowired"
echo "   private DireccioService direccioService;"
echo ""
echo "🎉 ¡Listo para usar!"
