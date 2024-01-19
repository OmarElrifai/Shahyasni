package com.shahyasni.ShahYasniResources;

import com.shahyasni.persistence.DTOs.ReservationDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accomodation")
public class AccomodationResources  {

    @POST
    @Path("checkReservationAvailability")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkReservationAvailability(ReservationDTO reservationDTO){
        try{
            return Response.ok().build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }
}
