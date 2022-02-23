package boutique.resources;

import boutique.dao.UtilisateurDao;
import boutique.model.Utilisateur;
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

public class UtilisateurRessource {

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
    Utilisateur Utilisateur = UtilisateurDao.instance.getModel().get(id);
    if (Utilisateur == null) throw new RuntimeException(
      "Get: Utilisateur with " + id + " not found"
    );
    return Utilisateur;
  }

  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Utilisateur getUtilisateurHTML() {
    Utilisateur Utilisateur = UtilisateurDao.instance.getModel().get(id);
    if (Utilisateur == null) throw new RuntimeException(
      "Get: Utilisateur with " + id + " not found"
    );
    return Utilisateur;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public Response putUtilisateur(JAXBElement<Utilisateur> Utilisateur) {
    Utilisateur c = Utilisateur.getValue();
    return putAndGetResponse(c);
  }

  @DELETE
  public void deleteUtilisateur() {
    Utilisateur c = UtilisateurDao.instance.getModel().remove(id);
    if (c == null) throw new RuntimeException(
      "Delete: Utilisateur with " + id + " not found"
    );
  }

  private Response putAndGetResponse(Utilisateur Utilisateur) {
    Response res;
    if (UtilisateurDao.instance.getModel().containsKey(Utilisateur.getId())) {
      res = Response.noContent().build();
    } else {
      res = Response.created(uriInfo.getAbsolutePath()).build();
    }
    UtilisateurDao.instance.getModel().put(Utilisateur.getId(), Utilisateur);
    return res;
  }
}
