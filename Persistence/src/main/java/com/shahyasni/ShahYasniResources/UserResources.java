package com.shahyasni.shahYasniResources;

import com.shahyasni.persistence.DAOs.UserDao;
import com.shahyasni.persistence.DTOs.*;
import com.shahyasni.persistence.DTOs.ReservationDTOs.ReservationDTO;
import com.shahyasni.persistence.Entities.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/User")
public class UserResources {

    @Inject
    UserDao userDao;

    @POST
    @Path("Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertNewUser(UserDTO user){
        try {
            userDao.insertUser(user);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err.getMessage()).build();
        }
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserDTO user){
        try {

            return Response.ok(userDao.login(user.getUsername(),user.getPassword())).build();

        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err.getMessage()).build();
        }
    }



    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@QueryParam("id") Integer id) {
        try {
            UserDTO user = userDao.findUserById(id);
            return Response.ok(user).build();
        }catch (Exception err){
            return Response.status(Response.Status.NOT_FOUND).entity(err).build();
        }

    }

    @GET
    @Path("getUserByUsername")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByUsername(@QueryParam("username") String username) {
        try {
            UserDTO user = userDao.findUserByUsername(username);
            return Response.ok(user).build();
        }catch (Exception err){
            return Response.status(Response.Status.NOT_FOUND).entity(err).build();
        }

    }

    @GET
    @Path("getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByUsername() {
        try {
            List<UserDTO> users = userDao.findAllUsers();
            return Response.ok().entity(users).build();
        }catch (Exception err){
            return Response.status(Response.Status.NOT_FOUND).entity(err).build();
        }

    }

    @PATCH
    @Path("updateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UserDTO user){
        try{
            User updatedUser = userDao.updateUser(user);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @POST
    @Path("addBankAccount")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBankAccount(UserBankAccountDTO userBankAccountDTO){
        try {
            userDao.addBankAccount(userBankAccountDTO);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @GET
    @Path("getBankAccountsForUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankAccounts(@QueryParam("userId") Integer userId){
        return Response.ok().entity(userDao.getBankAccountsForUser(userId)).build();
    }

    @PUT
    @Path("updateBankAccountsForUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBankAccount(UserBankAccountDTO userBankAccountDTO){
        try{
            return Response.ok().entity(userDao.updateBankAccount(userBankAccountDTO)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @DELETE
    @Path("removeBankAccountsForUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeBankAccount(@QueryParam("bankAccountId") Integer bankAccountId){
        try{
            userDao.removeBankAccount(bankAccountId);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @POST
    @Path("reserveLodgingAccomodation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reserveLodgingAccomodation(ReservationDTO reservationDTO){
        try {
            userDao.reserveLodgingAccomodation(reservationDTO);
            return Response.ok("Succcess").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @GET
    @Path("getLodgingReservationForUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLodgingAccomodationReservation(@QueryParam("userId") Integer userId){
        return Response.ok().entity(userDao.getLodgingReservationForUser(userId)).build();
    }

    @POST
    @Path("getLodgingReservationInTimeWindow")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLodgingReservationInTimeWindow(SearchRequest searchRequest){
        return Response.ok().entity(userDao.getLodgingReservationInTimeWindow(searchRequest.getFrom(), searchRequest.getTo())).build();
    }

    @POST
    @Path("getUserLodgingReservationInTimeWindow")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserLodgingReservationInTimeWindow(SearchRequest searchRequest){
        return Response.ok().entity(userDao.getUserLodgingReservationInTimeWindow(searchRequest.getUserId(), searchRequest.getFrom(), searchRequest.getTo())).build();
    }

    @PUT
    @Path("updateLodgingReservation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLodgingReservation(ReservationDTO reservationDTO){
        try{
            return Response.ok(userDao.updateLodgingReservation(reservationDTO)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @DELETE
    @Path("removeLodgingReservation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeLodgingAccomodationReservation(@QueryParam("reservationId") Integer reservationId){
        try {
            userDao.removeLodgingAccomodationReservation(reservationId);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @POST
    @Path("reservePrivateProperty")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reservePrivateProperty(ReservationDTO reservationDTO){
        try {
            userDao.reservePrivateProperty(reservationDTO);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @GET
    @Path("getPropertyReservationForUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrivatePropertyReservation(@QueryParam("userId") Integer userId){
        return Response.ok().entity(userDao.getPrivatePropertyReservationsForUser(userId)).build();
    }

    @POST
    @Path("getPropertyInTimeWindow")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrivatePropertyInTimeWindow(SearchRequest searchRequest){
        return Response.ok().entity(userDao.getPrivatePropertyInTimeWindow(searchRequest.getFrom(), searchRequest.getTo())).build();
    }

    @POST
    @Path("getUserPropertyInTimeWindow")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserPrivatePropertyInTimeWindow(SearchRequest searchRequest){
        return Response.ok().entity(userDao.getUserPrivatePropertyInTimeWindow(searchRequest.getUserId(),searchRequest.getFrom(),searchRequest.getTo())).build();
    }



    @PUT
    @Path("updatePropertyReservation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrivatePropertyReservation(ReservationDTO reservationDTO){
        try {
            userDao.updatePrivatePropertyReservation(reservationDTO);
            return Response.ok(userDao.updatePrivatePropertyReservation(reservationDTO)).build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @DELETE
    @Path("removePropertyReservation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removePrivatePropertyReservation(@QueryParam("reservationId") Integer reservationId){
        try {
            userDao.removePrivatePropertyReservation(reservationId);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @POST
    @Path("createTripOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTripOrder(TripOrderDTO tripOrderDTO){
        try {
            userDao.createTripOrder(tripOrderDTO);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }

    @GET
    @Path("getTripOrdersForUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTripOrdersForUser(@QueryParam("userId") Integer userId){
        return Response.ok().entity(userDao.getTripOrdersForUser(userId)).build();
    }

    @GET
    @Path("getTripOrderForLodgingBuilding")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTripOrderForLodgingBuilding(@QueryParam("orderId") Integer orderId){
        return Response.ok().entity(userDao.getTripOrderForLodgingBuilding(orderId)).build();
    }

    @GET
    @Path("getTripOrderForPrivateProperty")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTripOrderForPrivateProperty(@QueryParam("orderId") Integer orderId){
        return Response.ok().entity(userDao.getTripOrderForPrivateProperty(orderId)).build();
    }

    @POST
    @Path("getTripOrdersInTimeWindow")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTripOrdersInTimeWindow(SearchRequest searchRequest){
        return Response.ok().entity(userDao.getTripOrdersInTimeWindow(searchRequest.getFrom(),searchRequest.getTo())).build();
    }
    @POST
    @Path("getTripOrdersForUserInTimeWindow")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTripOrdersForUserInTimeWindow(SearchRequest searchRequest){
        return Response.ok().entity(userDao.getTripOrdersForUserInTimeWindow(searchRequest.getUserId(),searchRequest.getFrom(),searchRequest.getTo())).build();
    }

    @PUT
    @Path("updateTripOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTripOrder(TripOrderDTO tripOrderDTO){
       try {
           userDao.updateTripOrder(tripOrderDTO);
           return Response.ok("Success").build();
       }catch (Exception err){
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
       }
    }

    @DELETE
    @Path("deleteTripOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTripOrder(@QueryParam("tripOrderId") Integer tripOrderId){
        try {
            userDao.deleteTripOrder(tripOrderId);
            return Response.ok("Success").build();
        }catch (Exception err){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(err).build();
        }
    }
//
//    @POST
//    @Path("")



}
