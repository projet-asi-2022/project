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

@Path("/categories")
public class CategoriesRessource {
	
	private BoutiqueDbContext ctx = new BoutiqueDbContext();

  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  // Return the list of Categories to the user in the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public ArrayList<Categorie> getCategoriesBrowser() {
    return ctx.getCategories();
  }

  // Return the list of Categories for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public ArrayList<Categorie> getCategories() {
    return ctx.getCategories();
  }

  @Path("{categorie}")
  public CategorieRessource getCategorie(@PathParam("categorie") int id) {
    return new CategorieRessource(uriInfo, request, id);
  }
  
  @Path("add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public void createCategorie(Categorie categorie) {
	  ctx.insertCategorie(categorie);
  }
}
