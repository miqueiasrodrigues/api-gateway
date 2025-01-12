# Usar a imagem base OpenJDK 17 para ARM64
#FROM arm64v8/openjdk:17-jdk-slim
FROM openjdk:17-jdk-slim

# Configurar o diretório de trabalho no container
WORKDIR /app

# Copiar o JAR compilado para o container
COPY target/api-gateway-0.1.1-SNAPSHOT.jar app.jar

# Expor a porta que a aplicação irá rodar
EXPOSE 8950

# Definir o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]


