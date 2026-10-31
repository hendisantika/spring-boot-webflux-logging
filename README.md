# Spring Boot WebFlux Logging

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-webflux-logging/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-webflux-logging/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-brightgreen)

A demonstration project showcasing comprehensive HTTP request/response logging in a Spring WebFlux application with
ELK (Elasticsearch, Logstash, Kibana) stack integration.

## Overview

This project demonstrates how to implement advanced HTTP logging in a reactive Spring WebFlux application using
Zalando's Logbook library. It includes integration with the ELK stack for centralized log management and visualization.

## Features

- HTTP request/response logging with Zalando Logbook
- Reactive WebClient with logging
- JSON-formatted logs with Logstash encoder
- Sensitive data obfuscation
- ELK stack integration (Elasticsearch, Logstash, Kibana)
- Docker Compose setup for the entire stack

## Technologies

- Java 25 (Eclipse Temurin)
- Spring Boot 4.1.2
- Spring WebFlux & WebClient
- Jackson 3 (`tools.jackson`)
- Zalando Logbook 4.2.0
- Logstash Logback Encoder
- ELK Stack (Elasticsearch, Logstash, Kibana) 8.18.0
- Docker & Docker Compose

## Prerequisites

- JDK 25 or higher
- Maven 3.9+ (or use the bundled Maven Wrapper `./mvnw`)
- Docker and Docker Compose (for running the ELK stack)

## Getting Started

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/hendisantika/spring-boot-webflux-logging.git
   cd spring-boot-webflux-logging
   ```

2. Build the application:
   ```bash
   ./mvnw clean package
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

### Running with Docker Compose

To run the application with the ELK stack:

1. Build the JAR (the Docker image is based on `eclipse-temurin:25-jre`):
   ```bash
   ./mvnw clean package
   ```
2. Uncomment the API service in the `compose.yaml` file
3. Run Docker Compose:
   ```bash
   docker compose up -d
   ```

## API Endpoints

- `GET /v1/trace/log` - Makes a POST request to JSONPlaceholder API and returns the response with logging

## Logging Configuration

The application uses Zalando Logbook for HTTP logging with the following features:

- JSON-formatted logs
- Obfuscation of sensitive headers and parameters
- Exclusion of actuator and Swagger endpoints
- Integration with Logstash

## ELK Stack

The ELK stack is configured as follows:

- **Elasticsearch**: Stores and indexes logs
- **Logstash**: Processes logs from the application
- **Kibana**: Visualizes logs with a web interface

### Accessing Kibana

Once the ELK stack is running, you can access Kibana at:

```
http://localhost:5601
```

## Project Structure

- `src/main/java/id/my/hendisantika/webfluxlogging/controller/TraceController.java` - REST controller with logging
  example
- `src/main/java/id/my/hendisantika/webfluxlogging/config/LogbookConfiguration.java` - Logbook configuration
- `src/main/resources/logback-spring.xml` - Logback configuration with Logstash encoder
- `src/main/resources/application.yml` - Application configuration with Logbook settings
- `docker/conf/logstash.conf` - Logstash configuration
- `compose.yaml` - Docker Compose configuration for the ELK stack

## Continuous Integration

GitHub Actions ([`.github/workflows/maven.yml`](.github/workflows/maven.yml)) runs on every push and pull request to
`main` (and manually via *workflow_dispatch*):

- Sets up Temurin JDK 25 with Maven dependency caching
- Builds and tests with `./mvnw -B -ntp clean verify`
- Uploads surefire reports when the build fails
- Submits the Maven dependency graph to GitHub on pushes (improves Dependabot alerts)

## Dependency Updates

Dependabot ([`.github/dependabot.yml`](.github/dependabot.yml)) keeps dependencies current:

| Ecosystem      | Schedule              | Grouping                                                         |
|----------------|-----------------------|------------------------------------------------------------------|
| Maven          | Daily, 05:00 WIB      | Spring, Logbook, test dependencies, Maven plugins & wrapper      |
| GitHub Actions | Daily, 05:00 WIB      | All actions in one PR                                            |
| Docker         | Weekly (Monday)       | `eclipse-temurin` base image, major Java bumps ignored           |
| Docker Compose | Weekly (Monday)       | ELK stack images in one PR                                       |

Commit messages follow Conventional Commits (`build(deps): ...`, `ci(deps): ...`).

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

Hendi Santika

- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
