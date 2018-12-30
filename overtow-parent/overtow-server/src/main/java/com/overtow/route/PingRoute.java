package com.overtow.route;

import com.overtow.model.PingResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by cosborn on 12/29/18.
 */
@Path("/")
public class PingRoute
{

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping(@Context UriInfo uriInfo) throws Throwable
    {
        PingResponse response = new PingResponse();

        return Response.ok(response).type(MediaType.APPLICATION_JSON).build();
    }
}
