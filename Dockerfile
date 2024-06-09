# Etapa de construção
FROM maven:3.8.5-openjdk-17-slim AS build

# Copiar o código-fonte para a imagem
COPY . /app
WORKDIR /app

# Definir variáveis de ambiente para o banco de dados
ENV DATABASE_URL=jdbc:postgresql://dpg-cpif6e4f7o1s73bgl0a0-a:5432/example_database_4lm9
ENV DATABASE_USERNAME=example_database_4lm9_user
ENV DATABASE_PASSWORD=Mp75So0fwB6po1hnMWSmhrc5m5EIwsgy

# Executar a build usando Maven, ignorando testes
RUN mvn clean install -DskipTests

# Etapa final
FROM openjdk:17-jdk-slim

# Expor a porta 8080
EXPOSE 8080

# Copiar o artefato construído da etapa anterior
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
