ARG BUILD_IMAGE=maven:3.6-jdk-8-alpine
ARG RUNTIME_IMAGE=openjdk:8-alpine

FROM ${BUILD_IMAGE} as dependencies
COPY pom.xml ./
RUN mvn -B dependency:go-offline

FROM dependencies as build
COPY src ./src
RUN mvn -B clean package

FROM ${RUNTIME_IMAGE}
COPY --from=build /app/target/eventstore-*.jar /app/standalone.jar

CMD ["/usr/bin/java", "-jar", "/app/standalone.jar"]
