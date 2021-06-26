# spring-reactive-mongo-crud
Spring webflux

Docker commands
Docker image for MongoDB
- docker run -d -p 27017-27019:27017-27019 --name mongodb mongo:4.0.4

Build the image
- docker build -t webapp .
- docker run webapp

Network
- docker network ls
- docker create myNetwork
- docker run --net myNetwork webapp
- docker network connect myNetwork mongodb
