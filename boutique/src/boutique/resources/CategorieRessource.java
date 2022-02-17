package boutique.resources;

import boutique.dao.CategorieDao;
import boutique.model.Categorie;
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
    Categorie Categorie = CategorieDao.instance.getModel().get(id);
    if (Categorie == null) throw new RuntimeException(
      "Get: Categorie with " + id + " not found"
    );
    return Categorie;
  }

  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Categorie getCategorieHTML() {
    Categorie Categorie = CategorieDao.instance.getModel().get(id);
    if (Categorie == null) throw new RuntimeException(
      "Get: Categorie with " + id + " not found"
    );
    return Categorie;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public Response putCategorie(JAXBElement<Categorie> Categorie) {
    Categorie c = Categorie.getValue();
    return putAndGetResponse(c);
  }

  @DELETE
  public void deleteCategorie() {
    Categorie c = CategorieDao.instance.getModel().remove(id);
    if (c == null) throw new RuntimeException(
      "Delete: Categorie with " + id + " not found"
    );
  }

  private Response putAndGetResponse(Categorie Categorie) {
    Response res;
    if (CategorieDao.instance.getModel().containsKey(Categorie.getNom())) {
      res = Response.noContent().build();
    } else {
      res = Response.created(uriInfo.getAbsolutePath()).build();
    }
    CategorieDao.instance.getModel().put(Categorie.getNom(), Categorie);
    return res;
  }
}
