# hello-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `hello-quarkus-1.0.0-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/hello-quarkus-1.0.0-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/hello-quarkus-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide.

## Creating a Docker image in native (no JVM)

Build the image with:
```
docker build -f src/main/docker/Dockerfile.native -t serrodcal/employees-quarkus:0.1.0 .
```

**Note**: Or pull image from Docker Hub: `docker pull serrodcal/employees-quarkus:0.1.0`

Then run the container using:
```
docker run -i --rm -p 8080:8080 serrodcal/employees-quarkus:0.1.0
```

### Creating a distroless Docker image in native (no JVM)

Build the image with:
```
docker build -f src/main/docker/Dockerfile.native-distroless -t serrodcal/employees-quarkus-distroless:0.1.0 .
```

**Note**: Or pull image from Docker Hub: `docker pull serrodcal/employees-quarkus-distroless:0.1.0`

Then run the container using:
```
docker run -i --rm -p 8080:8080 serrodcal/hello-quarkus-distroless:0.1.0
```

### Testing the application

Once the docker container is up and running, test it with:
```
curl -vi localhost:8080/hello
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /hello HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
>
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Content-Length: 5
Content-Length: 5
< Content-Type: text/plain;charset=UTF-8
Content-Type: text/plain;charset=UTF-8

<
* Connection #0 to host localhost left intact
hello%   
```

## Kubernetes deployment

Deploy the application with:
```
kubectl apply -f k8s/
```

**Note**: Use [Kind](https://kind.sigs.k8s.io/) to create a cluster: `kind create cluster --config k8s/cluster/kind-ha-config.yaml`
