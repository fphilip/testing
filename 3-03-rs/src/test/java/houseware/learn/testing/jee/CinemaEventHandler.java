package houseware.learn.testing.jee;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

@Path("movieevent")
public class CinemaEventHandler {
    public CinemaEventHandler() {
        super();
    }

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String postMovieEvent(@Context Request request, String json) {
        System.out.println("received event:" + json);
        CinemaEventRouter.sendPost(json);
        return "event received " + json;
    }

    @GET
    @Produces("text/plain")
    public String getMovieEvent(@Context Request request) {
        return "nothing to report from getMovieEvent";
    }

}