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

@Path("/utilisateurs")
public class UtilisateursRessource {

  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  // Return the list of Utilisateurs to the user in the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public List<Utilisateur> getUtilisateursBrowser() {
    List<Utilisateur> Utilisateurs = new ArrayList<Utilisateur>();
    Utilisateurs.addAll(UtilisateurDao.instance.getModel().values());
    return Utilisateurs;
  }

  // Return the list of Utilisateurs for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Utilisateur> getUtilisateurs() {
    List<Utilisateur> Utilisateurs = new ArrayList<Utilisateur>();
    Utilisateurs.addAll(UtilisateurDao.instance.getModel().values());
    return Utilisateurs;
  }

  // returns the number of Utilisateurs
  // Use http://localhost:8080/com.vogella.jersey.Utilisateur/rest/Utilisateurs/count
  // rest.Utilisateur au lieu de com.vogella.jersey.Utilisateur
  // to get the total number of records
  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCount() {
    int count = UtilisateurDao.instance.getModel().size();
    return String.valueOf(count);
  }

  // Defines that the next path parameter after Utilisateurs is
  // treated as a parameter and passed to the TodoResources
  // Allows to type http://localhost:8080/rest.todo/rest/todos/1
  // 1 will be treaded as parameter Utilisateur and passed to TodoResource
  @Path("{utilisateur}")
  public UtilisateurRessource getUtilisateur(@PathParam("Utilisateur") int id) {
    return new UtilisateurRessource(uriInfo, request, id);
  }
}
