package com.ibapp.service.rest.resources;

import com.ibapp.domain.Person;
import com.ibapp.domain.Register;
import com.ibapp.service.PersonService;
import com.ibapp.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by imran on 23/04/15.
 */

@Path("/person")
@Component
public class PersonResource {

    @Autowired
    public PersonService personService;

    private static final Logger LOG = LoggerFactory.getLogger(PersonResource.class);

    //Create
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response createPerson(Person person) throws Exception {

        try {

            personService.insertPerson(person);
            return Response.status(200).build();
        } catch (Exception e) {
            LOG.error("Failed to insert Person : ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
        }
    }

    //Read
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {

        try {
            return Response.status(200).entity(personService.getAllPersons()).build();
        } catch (Exception e) {
            LOG.error("Failed to get list of Persons : ", e);
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int id) {

        try {
            return Response.status(200).entity(personService.getPersonById(id)).build();
        } catch (Exception e) {
            LOG.error("Failed to get Person by id: ", e);
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
    }

    //Update
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person person) {

        try {
            personService.updatePerson(person);
            return Response.status(200).build();
        } catch (Exception e) {
            LOG.error("Failed to update Person: ", e);
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
    }

    //Delete
    @DELETE
    @Path("/{id}")
    public Response deletePersonByID (@PathParam("id")int id) {

        try {

           personService.deletePerson(id);
           return Response.status(200).build();
        }  catch (Exception e) {
            LOG.error("Failed to delete Person: ", e);
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
    }



/*    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response createRegister(String registerDetails){

        try {
            Register register = MAPPER.readValue(registerDetails, Register.class);
            registerService.insertRegister(register);
            return Response.status(200).build();

        } catch (Exception e) {
            LOG.error("Failed to insert register : ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
        }

    }*/

    /*    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{msg}")
    public Response printMessage(@PathParam("msg") String msg) {

        String result = "Restful example: " + msg;

    //   return Response.ok(msg).build();
        return  Response.status(200).entity(result).build();

    }*/

}
