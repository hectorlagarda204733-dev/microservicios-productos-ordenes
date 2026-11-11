# microservicios-productos-ordenes

Practica de Sistemas Distribuidos: dos microservicios con Quarkus, base de datos H2 y persistencia con Panache.

## Servicios

| Servicio | Puerto |
|---|---|
| productos-service | 8081 |
| ordenes-service | 8082 |

## Como correr

Se ocupa Java 17 y Maven. Cada servicio se corre en su propia terminal:

```
cd productos-service
mvn quarkus:dev
```

```
cd ordenes-service
mvn quarkus:dev
```

## Probar

Crear un producto:

```
curl -X POST http://localhost:8081/productos -H "Content-Type: application/json" -d "{\"name\":\"Audifonos\",\"price\":50.0}"
```

Crear una orden (el 1 es el id del producto):

```
curl -X POST http://localhost:8082/ordenes -H "Content-Type: application/json" -d "1"
```

Ver las ordenes:

```
curl http://localhost:8082/ordenes
```
