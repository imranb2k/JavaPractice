package com.ibapp.service.rest.resources;

import com.ibapp.domain.Register;
import com.ibapp.persistence.RegisterMapper;
import com.ibapp.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by imran on 23/04/15.
 */

@Path("/register")
@Component
public class RegisterResource {

    @Autowired
    public RegisterService registerService;

/*    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{msg}")
    public Response printMessage(@PathParam("msg") String msg) {

        String result = "Restful example: " + msg;

    //   return Response.ok(msg).build();
        return  Response.status(200).entity(result).build();

    }*/

    private static final Logger LOG = LoggerFactory.getLogger(RegisterResource.class);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRegisters() {

        try {
            return Response.status(200).entity(registerService.getAllRegister()).build();
        } catch (Exception e) {
            LOG.error("Failed to get list of register : ", e);
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRegisterById(@PathParam("id") int id) {

        try {
            return Response.status(200).entity(registerService.getRegisterById(id)).build();
        } catch (Exception e) {
            LOG.error("Failed to get register by id: ", e);
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response createRegister(Register register){

        try {

         //   Register register = RestUtil.readAsObjectOf(Register.class, referralRequest);
            registerService.insertRegister(register);
            return Response.status(200).build();

        } catch (Exception e) {
            LOG.error("Failed to insert register : ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
        }

    }



}
