# Imagem base Java
FROM openjdk:17-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR da aplicação para o container
COPY target/*.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]