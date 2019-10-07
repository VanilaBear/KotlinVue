## Simple fullstack project for exam

* ##### Backend - REST API on Kotlin
* ##### Frontend - Vue.js
* ##### Store - MongoDB


##### Run MonngoDB
```
docker pull mongo
docker run --name mongo -d -p 27007:27017 mongo
```

##### Run backend
```
cd kotlin-spring-boot
mvn spring-boot:run
```

##### Run front
```
cd front
npm run serve
```
Available on localhost:8000