package com.bbva.play.dao.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.bbva.play.user.dto.MissionDto;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/missions")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface MissionClient {

    @GET
    List<MissionDto> getMission(@QueryParam("id") List<String> id);
}