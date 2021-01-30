package pl.com.laweta.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class ContactController {

    @GET
    @Path("/contact")
    public Response contact() {
        return Response.ok().build();
    }
}
