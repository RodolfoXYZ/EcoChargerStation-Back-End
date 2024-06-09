# Use a imagem base do OpenJDK com a versão 17
FROM openjdk:17

# Defina o diretório de trabalho como /app
WORKDIR /app

# Copie o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Copie todos os arquivos do projeto para o diretório de trabalho
COPY src ./src

# Execute o comando Maven para compilar e empacotar a aplicação
RUN mvn package -DskipTests

# Exponha a porta 8080, que é a porta padrão do Spring Boot
EXPOSE 8080

# Defina a variável de ambiente para o arquivo JAR da aplicação
ENV JAR_FILE=target/EcoChargerStation-0.0.1-SNAPSHOT.jar

# Execute a aplicação Java Spring quando o contêiner for iniciado
CMD ["java", "-jar", "$JAR_FILE"]
