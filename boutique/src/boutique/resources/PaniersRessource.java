package boutique.resources;

import boutique.model.*;
import db.BoutiqueDbContext;

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
	
	private BoutiqueDbContext ctx = new BoutiqueDbContext();
	
  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  // Return the list of Paniers to the user in the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Response getPaniersBrowser() {
    return ctx.getPaniers();
  }

  // Return the list of Paniers for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Response getPaniers() {
    return ctx.getPaniers() ; 
  }

  // Defines that the next path parameter after Paniers is
  // treated as a parameter and passed to the TodoResources
  // Allows to type http://localhost:8080/rest.todo/rest/todos/1
  // 1 will be treaded as parameter Panier and passed to TodoResource
  @Path("{panier}")
  public PanierRessource getPanier(@PathParam("panier") int id) {
    return new PanierRessource(uriInfo, request, id);
  }
  
  @Path("add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public void createPanier(Panier panier) {
	  ctx.insertPanier(panier);
      System.out.print(panier.getId());
  }
}
