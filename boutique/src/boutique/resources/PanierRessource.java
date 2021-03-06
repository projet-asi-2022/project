package boutique.resources;

import boutique.model.Panier;
import db.BoutiqueDbContext;

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

public class PanierRessource {
	
	private BoutiqueDbContext ctx = new BoutiqueDbContext();
	
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  int id;


  public PanierRessource(UriInfo uriInfo, Request request, int id) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.id = id;
   
  }

  //Application integration
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Panier getPanier() {
    Panier Panier = ctx.getPanier(id);
    if (Panier == null) throw new RuntimeException(
      "Get: Panier with " + id + " not found"
    );
    return Panier;
  }

  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Panier getPanierHTML() {
    Panier Panier = ctx.getPanier(id);
    if (Panier == null) throw new RuntimeException(
      "Get: Panier with " + id + " not found"
    );
    return Panier;
  }
 /*
  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public Response putPanier(JAXBElement<Panier> Panier) {
    Panier c = Panier.getValue();
    return putAndGetResponse(c);
  }

  private Response putAndGetResponse(Panier Panier) {
    Response res;
    if (PanierDao.instance.getModel().containsKey(Panier.getId())) {
      res = Response.noContent().build();
    } else {
      res = Response.created(uriInfo.getAbsolutePath()).build();
    }
    PanierDao.instance.getModel().put(Panier.getId(), Panier);
    return res;
  }*/
}
