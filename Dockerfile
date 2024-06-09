# Etapa de construção
FROM maven:3.8.5-openjdk-17-slim AS build

# Copiar o código-fonte para a imagem
COPY . /app
WORKDIR /app

# Executar a build usando Maven
RUN mvn clean install

# Etapa final
FROM openjdk:17-jdk-slim

# Expor a porta 8080
EXPOSE 8080

# Copiar o artefato construído da etapa anterior
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
