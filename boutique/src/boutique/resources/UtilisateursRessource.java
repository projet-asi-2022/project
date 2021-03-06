package boutique.resources;

import boutique.model.*;
import db.BoutiqueDbContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	private BoutiqueDbContext ctx = new BoutiqueDbContext();
	
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
    return ctx.getUtilisateurs();
  }

  // Return the list of Utilisateurs for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Utilisateur> getUtilisateurs() {
    return ctx.getUtilisateurs();
  }
  
  // Defines that the next path parameter after Utilisateurs is
  // treated as a parameter and passed to the TodoResources
  // Allows to type http://localhost:8080/rest.todo/rest/todos/1
  // 1 will be treaded as parameter Utilisateur and passed to TodoResource
  @Path("{utilisateur}")
  public UtilisateurRessource getUtilisateur(@PathParam("utilisateur") int id) {
    return new UtilisateurRessource(uriInfo, request, id);
  }
  
  @Path("{utilisateur}/panier")
  public PanierRessource getPanierByUtilisateur(@PathParam("utilisateur") int idUser) {
	  List<Panier> paniers = ctx.getPaniers();
	  Optional<Panier> p = paniers.stream().filter(user -> user.getId() == idUser).findFirst();
	  return new PanierRessource(uriInfo, request, p.get().getUser().getId());
  }
  
  @Path("add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public void createUser(Utilisateur user) {
	  ctx.insertUtilisateur(user);
      System.out.print(user.getPrenom());
  }
  

  
  @Path("exists")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public String userExist(Utilisateur user) {
    String role = ctx.userExist(user.getEmail(), user.getPassword());
    return role;
  }

}
