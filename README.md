# Spring Boot WebFlux Logging

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

- Java 21
- Spring Boot 3.4.4
- Spring WebFlux
- Zalando Logbook
- Logstash Logback Encoder
- ELK Stack (Elasticsearch, Logstash, Kibana) 8.18.0
- Docker & Docker Compose

## Prerequisites

- Java 21 or higher
- Maven
- Docker and Docker Compose (for running the ELK stack)

## Getting Started

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/spring-boot-webflux-logging.git
   cd spring-boot-webflux-logging
   ```

2. Build the application:
   ```bash
   mvn clean package
   ```

3. Run the application:
   ```bash
   mvn clean spring-boot:run
   ```

### Running with Docker Compose

To run the application with the ELK stack:

1. Uncomment the API service in the `compose.yaml` file
2. Run Docker Compose:
   ```bash
   docker-compose up -d
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

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

Hendi Santika

- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
