package edu.matc.rest;
import edu.matc.entity.Run;
import edu.matc.persistence.GenericDao;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/runs")
public class RunResource {

    @GET
    @Produces("application/json")
    public Response getRuns() {
        GenericDao<Run> dao = new GenericDao<>(Run.class);

        List<Run> runs = dao.getAll();

        return Response.status(200).entity(runs).build();
    }
}
