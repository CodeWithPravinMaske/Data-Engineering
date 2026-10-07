# code

Sample Spring Boot apps (`RestDemo`, `student-app`) used to practice building Docker images.

## Run

```bash
cd RestDemo
./mvnw package
docker build -t rest-demo .
docker run -p 8080:8080 rest-demo
```

## Sections

| Folder | About |
|---|---|
| [RestDemo](RestDemo/) |  |
| [student-app](student-app/) |  |
