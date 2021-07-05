## Product Microservice

To run this service you should prepare

1. Postgresql
2. Kafka

### Postgresql

```bash
docker run --name postgresqldb -e POSTGRES_USER=<username> -e POSTGRES_PASSWORD=<password> -p 5432:5432 -d postgres

# After executing this command you should create a new database from docker CLI
# Database name is product
```

### Kafka

To run kafka in your local environment you can follow the steps in the link below.

https://kafka.apache.org/quickstart

### Configuration

Product update topic is= `product.update`, You should consume this topic to listen product update messages.