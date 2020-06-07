# Telenor Product Service

### Installation / Startup

#####Maven
- `git clone https://github.com/paradigmwit/telenor-boutique.git`
- `cd telenor-boutique`
- `mvn spring-boot:run`

#####Docker
- `docker pull fahdmkhan/telenor-boutique:latest`
- `docker run -p 8080:8080 --rm -it fahdmkhan/telenor-boutique`

DockerHub was used to generate the docker image and the image is hosted in a public repository.
If the pull request is not working, kindly share email address of the reviewer and i will add as project collaborator to docker-hub.

---

#### Product Endpoint
The product endpoint provides the functionality -
- get all products: `http://localhost:8080/api/v1/products`
- get products by filter options: `http://localhost:8080/api/v1/product?type=phone`

---

### Data Strategy

An in memory H2 database instance has been employed in this implementation.
Data is loaded using the _data.sql_ file

The Data has been split between two tables 
1. phones
2. subscriptions

This has been done to make querying easier as the properties are a mix of String and Integer values.

Ideally the Normalization would be 3NF so that changes would be easier to make but in this implementation the tables are not normalized.

---

### Test Coverage

API level tests have been implemented to test the cases and the coverage report is present in the test_coverage_report folder.

---