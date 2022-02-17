package boutique.resources;

import boutique.dao.*;
import boutique.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

@Path("/paniers")
public class PaniersRessource {

  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  int id;

  public PaniersRessource(UriInfo uriInfo, Request request, int id) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.id = id;
  }

  // Return the list of Paniers to the user in the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public List<Panier> getPaniersBrowser() {
    List<Panier> Paniers = new ArrayList<Panier>();
    Paniers.addAll(PanierDao.instance.getModel().values());
    return Paniers;
  }

  // Return the list of Paniers for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Panier> getPaniers() {
    List<Panier> Paniers = new ArrayList<Panier>();
    Paniers.addAll(PanierDao.instance.getModel().values());
    return Paniers;
  }

  // returns the number of Paniers
  // Use http://localhost:8080/com.vogella.jersey.Panier/rest/Paniers/count
  // rest.Panier au lieu de com.vogella.jersey.Panier
  // to get the total number of records
  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCount() {
    int count = PanierDao.instance.getModel().size();
    return String.valueOf(count);
  }

  // Defines that the next path parameter after Paniers is
  // treated as a parameter and passed to the TodoResources
  // Allows to type http://localhost:8080/rest.todo/rest/todos/1
  // 1 will be treaded as parameter Panier and passed to TodoResource
  @Path("{Panier}")
  public PanierRessource getPanier(@PathParam("Panier") int id) {
    return new PanierRessource(uriInfo, request, id);
  }
}
