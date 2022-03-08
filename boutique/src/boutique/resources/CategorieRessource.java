package boutique.resources;

import boutique.model.Categorie;
import db.BoutiqueDbContext;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class CategorieRessource {

	private BoutiqueDbContext ctx = new BoutiqueDbContext();
	
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  int id;

  public CategorieRessource(UriInfo uriInfo, Request request, int id) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.id = id;
  }

  //Application integration
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Categorie getCategorie() {
    Categorie Categorie = ctx.getCategorie(id);
    if (Categorie == null) throw new RuntimeException(
      "Get: Categorie with " + id + " not found"
    );
    return Categorie;
  }

  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Categorie getCategorieHTML() {
    Categorie Categorie = ctx.getCategorie(id);
    if (Categorie == null) throw new RuntimeException(
      "Get: Categorie with " + id + " not found"
    );
    return Categorie;
  }
}
