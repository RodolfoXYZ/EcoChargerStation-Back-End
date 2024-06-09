# Etapa de construção
FROM ubuntu:latest AS build

# Atualizar pacotes e instalar dependências
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Definir diretório de trabalho
WORKDIR /app

# Copiar código-fonte para a imagem
COPY . .

# Executar a build usando Maven, ignorando testes
RUN mvn clean package -DskipTests

# Listar arquivos no diretório target para debug
RUN ls -l /app/target/

# Etapa final
FROM openjdk:17-jdk-slim

# Expor a porta 8080
EXPOSE 8080

# Copiar o artefato construído da etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
