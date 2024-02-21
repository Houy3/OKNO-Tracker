#FROM maven AS build
#COPY src /home/application/src
#COPY pom.xml /home/application
#USER root
##RUN -mount=type=cache,target=/root/.m2 mvn -DskipTests=true -f /home/application/pom.xml clean package
#RUN mvn -DskipTests=true -f /home/application/pom.xml clean package
#
#FROM openjdk:19-alpine
#COPY --from=build /home/application/target/app.jar /usr/local/lib/app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]




FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

EXPOSE 8080
CMD ["./mvnw", "spring-boot:run"]