package br.com.darp.resource;

import java.time.LocalDate;
import java.util.List;

import br.com.darp.application.BookService;
import br.com.darp.domain.Book;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookService service;

    @POST
    public Response create(Book book) {
        Book created = service.create(book);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @GET
    public List<Book> listAll() {
        return service.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id) {
        return Response.ok(service.getById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/current-reading")
    public Response getCurrentReading() {
        return service.getCurrentReading()
                .map(book -> Response.ok(book).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/current-reading/{id}")
    public Response setCurrentReading(@PathParam("id") String id) {
        service.setCurrentReading(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}/mark-as-read")
    public Response markAsRead(@PathParam("id") String id) {
        service.markAsRead(id, LocalDate.now().toString());
        return Response.noContent().build();
    }
}
