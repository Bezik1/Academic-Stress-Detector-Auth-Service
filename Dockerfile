FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

RUN apk add --no-cache wget bash \
    && wget https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz \
    && tar -xvzf apache-maven-3.9.1-bin.tar.gz \
    && mv apache-maven-3.9.1 /opt/maven \
    && ln -s /opt/maven/bin/mvn /usr/bin/mvn

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENV PORT=8081

CMD ["java", "-jar", "app.jar", "--server.port=${PORT}"]
