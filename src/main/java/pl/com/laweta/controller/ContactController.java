package pl.com.laweta.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import pl.com.laweta.dto.MailDto;
import pl.com.laweta.service.MailService;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class ContactController {

    private final MailService mailService;

    @Inject
    public ContactController(MailService mailService) {
        this.mailService = mailService;
    }

    @GET
    @Path("/contact")
    public Response contact() {
        return Response.ok().build();
    }

    @POST
    @Path("/send")
    public Response sendEmail(@RequestBody MailDto mail) {
        mailService.sendEmail(mail);
        return Response.ok().build();
    }
}
