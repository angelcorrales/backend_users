package com.bbva.play.user;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.*;

import java.util.List;

import com.bbva.play.user.dto.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/user")
public class UserResource {

    @Inject
    UserService service;

    @Operation(summary = "Return user by id")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = UserDTO.class)))
    @APIResponse(responseCode = "204", description = "User nor found")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getUser(
    @Parameter(description = "User identifier", required = true)    
    @PathParam("id") Long id) {
        UserDTO user = service.getUser(id);
        if (user == null)
            return Response.noContent().build();
        else 
            return Response.ok(user).build();
    }

    @Operation(summary = "Return user's missions")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = MissionDto.class)))
    @APIResponse(responseCode = "204", description = "User has no")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/missions")
    public Response getUserMissions(@PathParam("id") Long id) {
        
        List<MissionDto> list = service.getUserMissions(id);
        
        if (list == null || list.isEmpty())
            return Response.noContent().build();
        else
            return Response.ok(list).build();
    }

}