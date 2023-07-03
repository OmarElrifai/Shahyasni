package com.shahyasni.ShahYasniResources;

import com.shahyasni.persistence.DAOs.UserModel;
import com.shahyasni.persistence.Entities.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/User")
public class UserResources {

    @Inject
    UserModel userModel;

    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertNewUser(User user){
        try {
            userModel.insert(user);
            return Response.ok("Success").status(Response.Status.OK).build();
        }catch (Exception err){
            return Response.status(Response.Status.NOT_FOUND).entity(err).build();
        }
    }

    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserWithUsername(@QueryParam("username") String username) {
        try {
            User user = userModel.findUserByUsername(username);
            return Response.ok(user).status(Response.Status.FOUND).build();
        }catch (Exception err){
            return Response.status(Response.Status.NOT_FOUND).entity(err).build();
        }

    }

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserWithId(@PathParam("username") String username) {
        try {
            User user = userModel.findUserByUsername(username);
            return Response.ok(user).status(Response.Status.FOUND).build();
        }catch (Exception err){
            return Response.status(Response.Status.NOT_FOUND).entity(err).build();
        }

    }
}