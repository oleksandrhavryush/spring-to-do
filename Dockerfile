FROM maven:3.8.4-openjdk-17 AS builder

COPY ./ /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package -DskipTests

FROM tomcat

COPY --from=builder /usr/src/app/target/root.war /usr/local/tomcat/webapps
