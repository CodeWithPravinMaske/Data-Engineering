# Spring

Spring Framework and Spring Boot learning path, from basics to advanced. Every resource here is free and official unless marked otherwise.

## Start Here

| Resource | What it is |
|---|---|
| [Spring Academy](https://spring.academy/courses) | Official free courses with in-browser labs (Spring Boot 3, REST, Data, Security, Testing). Needs a free sign-up. |
| [Spring Guides](https://spring.io/guides) | Short official "getting started" tutorials (15–30 min each) |
| [Spring Initializr](https://start.spring.io) | Generates a new Spring Boot project |
| [Spring Learn hub](https://spring.io/learn) | Official index of docs, guides, and videos |

## Learning Path

### 1. Basics: Core Spring
- Inversion of Control (IoC) and Dependency Injection
- Beans, `@Component` / `@Service` / `@Repository`, `@Configuration` + `@Bean`
- Bean scopes and lifecycle; `ApplicationContext`
- Profiles and externalized config (`application.yml`, `@Value`, `@ConfigurationProperties`)
- 📖 [Spring Framework reference: Core](https://docs.spring.io/spring-framework/reference/)

### 2. Spring Boot Fundamentals
- Auto-configuration and starters
- Project structure, `@SpringBootApplication`, running as a jar
- Logging, Actuator (health, metrics)
- 📖 [Spring Boot reference](https://docs.spring.io/spring-boot/index.html)
- 🧪 Guide: [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service)

### 3. Web & REST APIs
- `@RestController`, `@RequestMapping`, path/query params, request bodies
- Validation (`@Valid`), exception handling (`@ControllerAdvice`)
- `RestClient` / `WebClient` for calling other services
- OpenAPI/Swagger docs (springdoc-openapi)

### 4. Data: JPA & Hibernate
- Spring Data JPA repositories, derived queries, `@Query`
- Entities and relationships, lazy vs eager loading, the N+1 problem
- Transactions (`@Transactional`, propagation, isolation)
- DB migrations with Flyway or Liquibase
- 📖 [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/reference/)
- 🧪 Guide: [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa)
- See also: [Hibernate notes](../Hibernate/)

### 5. Testing
- `@SpringBootTest`, `@WebMvcTest`, `@DataJpaTest`
- MockMvc, Mockito
- Testcontainers for real databases and Kafka in tests

### 6. Security
- Security filter chain, authentication vs authorization
- JWT and OAuth2 resource servers
- Method security (`@PreAuthorize`)
- 📖 [Spring Security reference](https://docs.spring.io/spring-security/reference/)
- 🧪 Guide: [Securing a Web Application](https://spring.io/guides/gs/securing-web)

### 7. Advanced: Microservices & Cloud
- Spring Cloud: Config Server, service discovery, API Gateway, Resilience4j circuit breakers
- Observability: Micrometer, tracing
- Docker images (`./mvnw spring-boot:build-image`), Kubernetes deployment
- 📖 [Spring Cloud](https://spring.io/projects/spring-cloud)
- See also: [Docker sample apps](../../01-Fundamentals/Docker/code/)

### 8. Advanced: Data Engineering with Spring
- **Spring Kafka:** producers, consumers, error handling, retries ([reference](https://docs.spring.io/spring-kafka/reference/))
- **Spring Batch:** chunk-oriented ETL jobs, restartability ([reference](https://docs.spring.io/spring-batch/reference/))
- Reactive Spring (WebFlux) for streaming APIs
- **Spring AI:** LLM integration, RAG ([reference](https://docs.spring.io/spring-ai/reference/))

## Practice Projects
- [Spring PetClinic](https://github.com/spring-projects/spring-petclinic): the official sample app; read it end to end
- Build a CRUD REST API with Postgres + Flyway + tests + Docker
- Add JWT security, then split it into two services that talk over Kafka

## More Tutorials
- [Baeldung: Spring tutorials](https://www.baeldung.com/spring-tutorial) and [Spring Boot tutorials](https://www.baeldung.com/spring-boot): the most complete free written tutorials (third-party)
