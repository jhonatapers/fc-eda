FROM gradle:8.10.2-jdk23-alpine AS builder
WORKDIR /app
COPY . .
RUN gradle build

FROM openjdk:23-slim
WORKDIR /app
ENV ENVIRIOMENT=docker
COPY --from=builder /app/build/libs/app.jar .
CMD [ "java", "-jar",  "app.jar" ]