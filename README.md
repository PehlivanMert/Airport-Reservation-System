# Airport Reservation System / Havalimanı Rezervasyon Sistemi

## English

### Overview
This is a Spring Boot-based airport reservation system that allows users to manage airports, flights, routes, and tickets. The system uses PostgreSQL as the database and includes Kafka for event handling.

### Technologies Used
- Java 21
- Spring Boot
- PostgreSQL
- Kafka
- Docker
- Maven

### System Requirements
- Docker
- Docker Compose
- Maven (for local development)

### Getting Started

1. Clone the repository
2. Run the application using Docker Compose:
```bash
docker-compose up
```

The application will be available at `http://localhost:8085`

### API Endpoints

#### User Management
```bash
# User Registration
curl -X POST http://localhost:8085/users/signup -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123","email":"admin@example.com"}'

# User Login
curl -X POST http://localhost:8085/users/signin -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'

# Get Current User
curl http://localhost:8085/users/me

# Delete User
curl -X DELETE http://localhost:8085/users/{username}
```

#### Airport Management
```bash
# Create Airport
curl -X POST http://localhost:8085/api/airport/create -H "Content-Type: application/json" -d '{"name":"IST","addresses":[{"city":"Istanbul","province":"Istanbul"}]}'

# Get All Airports
curl http://localhost:8085/api/airport/all

# Get Airport by ID
curl http://localhost:8085/api/airport/{id}

# Update Airport
curl -X PUT http://localhost:8085/api/airport/update/{id} -H "Content-Type: application/json" -d '{"name":"IST","addresses":[{"city":"Istanbul","province":"Istanbul"}]}'

# Delete Airport
curl -X DELETE "http://localhost:8085/api/airport/delete?id={id}"
```

#### Flight Management
```bash
# Create Flight
curl -X POST http://localhost:8085/api/flight/create -H "Content-Type: application/json" -d '{"code":"TK123","quota":100,"price":1000,"departureDate":"2024-03-20T10:00:00","estimatedArrivalDate":"2024-03-20T11:00:00","route":{"id":1},"airportCompany":{"id":1}}'

# Get All Flights
curl http://localhost:8085/api/flight/all

# Get Flight by ID
curl http://localhost:8085/api/flight/{id}

# Update Flight
curl -X PUT http://localhost:8085/api/flight/update -H "Content-Type: application/json" -d '{"id":1,"code":"TK124"}'

# Delete Flight
curl -X DELETE "http://localhost:8085/api/flight/delete?id={id}"
```

#### Route Management
```bash
# Create Route
curl -X POST http://localhost:8085/api/route/create -H "Content-Type: application/json" -d '{"departureAirport":{"id":1},"arrivalAirport":{"id":2}}'

# Get All Routes
curl http://localhost:8085/api/route/all

# Get Route by ID
curl http://localhost:8085/api/route/{id}

# Update Route
curl -X PUT http://localhost:8085/api/route/update -H "Content-Type: application/json" -d '{"id":1,"departureAirport":{"id":1},"arrivalAirport":{"id":2}}'

# Delete Route
curl -X DELETE "http://localhost:8085/api/route/delete?id={id}"
```

#### Ticket Management
```bash
# Create Ticket
curl -X POST http://localhost:8085/api/ticket/create -H "Content-Type: application/json" -d '{"flightId":1,"passengerId":2}'

# Get All Tickets
curl http://localhost:8085/api/ticket/all

# Get Ticket by ID
curl http://localhost:8085/api/ticket/{id}

# Update Ticket
curl -X PUT http://localhost:8085/api/ticket/update -H "Content-Type: application/json" -d '{"id":1,"flightId":1,"passengerId":2}'

# Delete Ticket
curl -X DELETE "http://localhost:8085/api/ticket/delete?id={id}"
```

## Türkçe

### Genel Bakış
Bu, kullanıcıların havalimanları, uçuşlar, rotalar ve biletleri yönetmesine olanak tanıyan Spring Boot tabanlı bir havalimanı rezervasyon sistemidir. Sistem veritabanı olarak PostgreSQL kullanır ve olay işleme için Kafka içerir.

### Kullanılan Teknolojiler
- Java 21
- Spring Boot
- PostgreSQL
- Kafka
- Docker
- Maven

### Sistem Gereksinimleri
- Docker
- Docker Compose
- Maven (yerel geliştirme için)

### Başlangıç

1. Depoyu klonlayın
2. Docker Compose ile uygulamayı çalıştırın:
```bash
docker-compose up
```

Uygulama `http://localhost:8085` adresinde kullanılabilir olacaktır.

### API Uç Noktaları

#### Kullanıcı Yönetimi
```bash
# Kullanıcı Kaydı
curl -X POST http://localhost:8085/users/signup -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123","email":"admin@example.com"}'

# Kullanıcı Girişi
curl -X POST http://localhost:8085/users/signin -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'

# Mevcut Kullanıcıyı Getir
curl http://localhost:8085/users/me

# Kullanıcı Sil
curl -X DELETE http://localhost:8085/users/{username}'
```

#### Havalimanı Yönetimi
```bash
# Havalimanı Oluştur
curl -X POST http://localhost:8085/api/airport/create -H "Content-Type: application/json" -d '{"name":"IST","addresses":[{"city":"Istanbul","province":"Istanbul"}]}'

# Tüm Havalimanlarını Getir
curl http://localhost:8085/api/airport/all

# ID ile Havalimanı Getir
curl http://localhost:8085/api/airport/{id}

# Havalimanı Güncelle
curl -X PUT http://localhost:8085/api/airport/update/{id} -H "Content-Type: application/json" -d '{"name":"IST","addresses":[{"city":"Istanbul","province":"Istanbul"}]}'

# Havalimanı Sil
curl -X DELETE "http://localhost:8085/api/airport/delete?id={id}"
```

#### Uçuş Yönetimi
```bash
# Uçuş Oluştur
curl -X POST http://localhost:8085/api/flight/create -H "Content-Type: application/json" -d '{"code":"TK123","quota":100,"price":1000,"departureDate":"2024-03-20T10:00:00","estimatedArrivalDate":"2024-03-20T11:00:00","route":{"id":1},"airportCompany":{"id":1}}'

# Tüm Uçuşları Getir
curl http://localhost:8085/api/flight/all

# ID ile Uçuş Getir
curl http://localhost:8085/api/flight/{id}

# Uçuş Güncelle
curl -X PUT http://localhost:8085/api/flight/update -H "Content-Type: application/json" -d '{"id":1,"code":"TK124"}'

# Uçuş Sil
curl -X DELETE "http://localhost:8085/api/flight/delete?id={id}"
```

#### Rota Yönetimi
```bash
# Rota Oluştur
curl -X POST http://localhost:8085/api/route/create -H "Content-Type: application/json" -d '{"departureAirport":{"id":1},"arrivalAirport":{"id":2}}'

# Tüm Rotaları Getir
curl http://localhost:8085/api/route/all

# ID ile Rota Getir
curl http://localhost:8085/api/route/{id}

# Rota Güncelle
curl -X PUT http://localhost:8085/api/route/update -H "Content-Type: application/json" -d '{"id":1,"departureAirport":{"id":1},"arrivalAirport":{"id":2}}'

# Rota Sil
curl -X DELETE "http://localhost:8085/api/route/delete?id={id}"
```

#### Bilet Yönetimi
```bash
# Bilet Oluştur
curl -X POST http://localhost:8085/api/ticket/create -H "Content-Type: application/json" -d '{"flightId":1,"passengerId":2}'

# Tüm Biletleri Getir
curl http://localhost:8085/api/ticket/all

# ID ile Bilet Getir
curl http://localhost:8085/api/ticket/{id}

# Bilet Güncelle
curl -X PUT http://localhost:8085/api/ticket/update -H "Content-Type: application/json" -d '{"id":1,"flightId":1,"passengerId":2}'

# Bilet Sil
curl -X DELETE "http://localhost:8085/api/ticket/delete?id={id}"
``` 