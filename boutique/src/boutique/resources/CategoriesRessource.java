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

@Path("/categories")
public class CategoriesRessource {

  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  // Return the list of Categories to the user in the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public List<Categorie> getCategoriesBrowser() {
    List<Categorie> Categories = new ArrayList<Categorie>();
    Categories.addAll(CategorieDao.instance.getModel().values());
    return Categories;
  }

  // Return the list of Categories for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Categorie> getCategories() {
    List<Categorie> Categories = new ArrayList<Categorie>();
    Categories.addAll(CategorieDao.instance.getModel().values());
    return Categories;
  }

  // returns the number of Categories
  // Use http://localhost:8080/com.vogella.jersey.Categorie/rest/Categories/count
  // rest.Categorie au lieu de com.vogella.jersey.Categorie
  // to get the total number of records
  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCount() {
    int count = CategorieDao.instance.getModel().size();
    return String.valueOf(count);
  }

  // Defines that the next path parameter after Categories is
  // treated as a parameter and passed to the TodoResources
  // Allows to type http://localhost:8080/rest.todo/rest/todos/1
  // 1 will be treaded as parameter Categorie and passed to TodoResource
  @Path("{categorie}")
  public CategorieRessource getCategorie(@PathParam("categorie") int id) {
    return new CategorieRessource(uriInfo, request, id);
  }
}
