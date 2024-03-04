package com.shahyasni.shahYasniResources;

import com.shahyasni.persistence.DAOs.LocationDao;
import com.shahyasni.persistence.DTOs.LocationDTO;
import com.shahyasni.persistence.DTOs.SearchRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/location")
public class LocationResources {

    @Inject
    private LocationDao locationDao;

    @POST
    @Path("/createLocation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLocation(LocationDTO locationDTO){
        try {
            locationDao.createLocation(locationDTO);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err.getMessage()).build();
        }

    }

    @GET
    @Path("/getLocations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocations(@QueryParam("activity") String activity){
       return Response.ok().entity(locationDao.getLocations(activity)).build();
    }


    @POST
    @Path("/getPrivateProperty")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrivateProperty(SearchRequest searchRequest){
       return Response.ok().entity(locationDao.getPrivateProperty(searchRequest)).build();
    }

    @POST
    @Path("/getActivities")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActivities(SearchRequest searchRequest){
       return Response.ok().entity(locationDao.getActivities(searchRequest)).build();
    }

    @POST
    @Path("/getLodgingBuildings")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLodgingBuildings(SearchRequest searchRequest){
       return Response.ok().entity(locationDao.getLodgingBuildings(searchRequest)).build();
    }




    @PUT
    @Path("/updateLocation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLocation(LocationDTO locationDTO){
        try {
            return Response.ok().entity(locationDao.updateLocation(locationDTO)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err.getMessage()).build();
        }
    }


    @DELETE
    @Path("/deleteLocations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocations(@QueryParam("locationId") Integer locationId){
        try {
            locationDao.removeLocation(locationId);
            return Response.ok().entity("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err.getMessage()).build();
        }
    }
}
