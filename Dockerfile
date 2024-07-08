#imagem base
FROM ubuntu:latest AS build

#instalação das dependências
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

#copiando arquivos para imagem
COPY . .

#baixando dependência e buildando o projeto
RUN mvn clean install

#adicionando camada java 17
FROM openjdk:17-jdk-slim



#expondo porta 8080
EXPOSE 8080

#copiando arquivo jar da cama de build
COPY --from=build /target/ssr-0.0.1.jar /app.jar

#definindo entrypoint para execução da aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]