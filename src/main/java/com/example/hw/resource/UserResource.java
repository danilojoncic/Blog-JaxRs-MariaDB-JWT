package com.example.hw.resource;

import com.example.hw.dto.LoginDto;
import com.example.hw.service.UserService;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid LoginDto loginDto){
        Map<String,String> response = new HashMap<>();
        String jwt = this.userService.login(loginDto.getUsername(),loginDto.getPassword());
        if(jwt == null){
            response.put("message","Invalid JWT");
            return Response.status(401).entity(response).build();
        }
        response.put("jwt",jwt);
        return Response.ok(response).build();
    }
}
