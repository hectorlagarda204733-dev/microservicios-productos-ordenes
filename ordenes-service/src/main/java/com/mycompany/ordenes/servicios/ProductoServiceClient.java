package com.mycompany.ordenes.servicios;

import com.mycompany.ordenes.entidades.Producto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
// como es practica ps es local
@RegisterRestClient(baseUri = "http://localhost:8081") // URL del microservicio de productos
@Path("/productos")

// interfaz para el product client
public interface ProductoServiceClient {

    @GET
    @Path("/{id}")
    Producto getById(@PathParam("id") Long id);
}
