package com.shahyasni.shahYasniResources;

import com.shahyasni.persistence.DAOs.LodgingBuildingDao;
import com.shahyasni.persistence.DAOs.PrivatePropertyDao;
import com.shahyasni.persistence.DTOs.AccomodationsFilter;
import com.shahyasni.persistence.DTOs.LodgingBuildingDTO;
import com.shahyasni.persistence.DTOs.PrivatePropertyDTO;
import com.shahyasni.persistence.DTOs.SearchRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accomodation")
public class AccomodationResources  {

    @Inject
    LodgingBuildingDao lodgingBuildingDao;

    @Inject
    PrivatePropertyDao privatePropertyDao;
    @POST
    @Path("createLodgingBuilding")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLodgingBuilding(LodgingBuildingDTO lodgingBuildingDTO){
        try {

            this.lodgingBuildingDao.createLodgingBuilding(lodgingBuildingDTO);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }


    @POST
    @Path("getLodgingBuilding")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLodgingBuilding(@QueryParam("id") Integer id){
        try {
            return Response.ok(this.lodgingBuildingDao.getLodgingBuilding(id)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }


    @POST
    @Path("getAvailableLodgingBuilding")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableLodgingBuildings(AccomodationsFilter accomodationsFilter){
        try {

            return Response.ok(this.lodgingBuildingDao.getAvailableLodgingBuildings(accomodationsFilter)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @POST
    @Path("checkReservationAvailability")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkReservationAvailability(SearchRequest request){
        try {
            return Response.ok(this.lodgingBuildingDao.checkAvailability(request)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @POST
    @Path("updateLodgingBuilding")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLodgingBuilding(LodgingBuildingDTO lodgingBuildingDTO){
        try{
            return Response.ok(this.lodgingBuildingDao.updateLodgingBuilding(lodgingBuildingDTO)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @DELETE
    @Path("removeLodgingBuilding")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeLodgingBuilding(@QueryParam("id") Integer id){
        try{
            this.lodgingBuildingDao.removeLodgingBuilding(id);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }


    @POST
    @Path("createPrivateProperty")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPrivateProperty(PrivatePropertyDTO privatePropertyDTO){
        try {
            this.privatePropertyDao.createPrivateProperty(privatePropertyDTO);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @POST
    @Path("getPrivateProperty")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrivateProperty(@QueryParam("id") Integer id){
        try {
            return Response.ok(this.privatePropertyDao.getPrivateProperty(id)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @POST
    @Path("getAvailablePrivateProperties")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailablePrivateProperty(AccomodationsFilter accomodationsFilter){
        try {
            return Response.ok(this.privatePropertyDao.getAvailablePrivateBuilding(accomodationsFilter)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }
    @POST
    @Path("checkPropertyAvailability")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkPropertyAvailability(SearchRequest request){
        try {
            return Response.ok(this.privatePropertyDao.checkAvailability(request)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }
    @POST
    @Path("updatePrivateProperty")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLodgingBuilding(PrivatePropertyDTO privatePropertyDTO){
        try{
            return Response.ok(this.privatePropertyDao.updatePrivateProperty(privatePropertyDTO)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @DELETE
    @Path("removePrivateProperty")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removePrivateProperty(@QueryParam("id") Integer id){
        try{
            this.privatePropertyDao.removePrivateProperty(id);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

}
