package com.mycompany.ordenes.servicios;

import com.mycompany.ordenes.entidades.Orden;
import com.mycompany.ordenes.entidades.Producto;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/ordenes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdenResource {

    @Inject
    @RestClient
    ProductoServiceClient productClient;

    @GET
    public List<Orden> listar() {
        return Orden.listAll();
    }

    @POST
    @Transactional
    public Response crearOrden(Long productId) {
        Producto producto;
        try {
            // llamada distribuida al microservicio de productos
            producto = productClient.getById(productId);
        } catch (WebApplicationException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("El producto no existe").build();
        }

        Orden orden = new Orden();
        orden.productId = producto.id;
        orden.productName = producto.name;
        orden.persist();

        return Response.status(Response.Status.CREATED).entity(orden).build();
    }
}
