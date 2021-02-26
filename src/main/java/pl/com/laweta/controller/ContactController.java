package pl.com.laweta.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import pl.com.laweta.dto.MailDto;
import pl.com.laweta.service.ContactService;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactController {

    private final Validator validator;
    private final ContactService contactService;

    @Inject
    public ContactController(ContactService contactService, Validator validator) {
        this.contactService = contactService;
        this.validator = validator;
    }

    @GET
    @Path("/contact")
    public Response contact() {
        return Response.ok().build();
    }

    @POST
    @Path("/send")
    public Response sendEmail(@RequestBody MailDto mailDto) {
        if (!validator.validate(mailDto).isEmpty()) {
            return Response.status(Status.NOT_ACCEPTABLE).build();
        }

        contactService.sendEmail(mailDto);
        return Response.ok().build();
    }
}
