# employee-micronaut project

This project uses Micronaut, a modern, JVM-based, full-stack framework for building modular, easily testable microservice
and serverless applications..

If you want to learn more about Micronaut, please visit its website: https://micronaut.io/ .

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `original-employee-micronaut-1.0.0.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/employee-micronaut-1.0.0.jar`.

## Creating a Docker image

Build the image with:
```
docker build -f src/main/docker/Dockerfile.jvm -t serrodcal/employees-micronaut:0.1.0 .
```

**Note**: Or pull image from Docker Hub: `docker pull serrodcal/employees-micronaut:0.1.0`

Then run the container using:
```
docker run -i --rm -p 8080:8080 serrodcal/employees-micronaut:0.1.0
```

### Testing the application

Firstly, create a PostgresSQL database with:
```
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name micronaut_test -e POSTGRES_USER=micronaut_test -e POSTGRES_PASSWORD=micronaut_test -e POSTGRES_DB=micronaut_test -p 5432:5432 postgres:10.5
```

Once the docker container is up and running, test it with:
```
curl -vi localhost:8080/micronaut/employee
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /quarkus/employee HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
>
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Content-Length: 57
Content-Length: 57
< Content-Type: application/json
Content-Type: application/json

<
* Connection #0 to host localhost left intact
[{"id":1,"name":"Lechowsky"},{"id":2,"name":"Serrodcal"}]%    
```
