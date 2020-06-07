# Telenor Product Service

### Installation

- git clone https://github.com/paradigmwit/telenor-boutique.git
- cd telenor-boutique
- mvn spring-boot:run
- profit?

---

#### Product Endpoint
The product endpoint provides the functionality -
- get all products: _http://localhost:8080/api/v1/products_
- get products by filter options: _http://localhost:8080/api/v1/product [?type=phone]_

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