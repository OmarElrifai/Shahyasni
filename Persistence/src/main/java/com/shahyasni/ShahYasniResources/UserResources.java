package com.shahyasni.ShahYasniResources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class UserResources {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}