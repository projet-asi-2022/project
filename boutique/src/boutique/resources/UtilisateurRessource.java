package boutique.resources;

import boutique.model.Utilisateur;
import db.BoutiqueDbContext;

import javax.management.relation.Role;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class UtilisateurRessource {

	private BoutiqueDbContext ctx = new BoutiqueDbContext();
	
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  int id;

  public UtilisateurRessource(UriInfo uriInfo, Request request, int id) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.id = id;
  }

  //Application integration
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Utilisateur getUtilisateur() {
    Utilisateur Utilisateur = ctx.getUtilisateur(id);
    if (Utilisateur == null) throw new RuntimeException(
      "Get: Utilisateur with " + id + " not found"
    );
    return Utilisateur;
  }
  

  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Utilisateur getUtilisateurHTML() {
    Utilisateur Utilisateur = ctx.getUtilisateur(id);
    if (Utilisateur == null) throw new RuntimeException(
      "Get: Utilisateur with " + id + " not found"
    );
    return Utilisateur;
  }
}
