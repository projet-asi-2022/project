package boutique.resources;

import boutique.dao.ArticleDao;
import boutique.model.Article;
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

public class ArticleRessource {

  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  int id;

  public ArticleRessource(UriInfo uriInfo, Request request, int id) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.id = id;
  }

  //Application integration
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Article getArticle() {
    Article Article = ArticleDao.instance.getModel().get(id);
    if (Article == null) throw new RuntimeException(
      "Get: Article with " + id + " not found"
    );
    return Article;
  }

  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Article getArticleHTML() {
    Article Article = ArticleDao.instance.getModel().get(id);
    if (Article == null) throw new RuntimeException(
      "Get: Article with " + id + " not found"
    );
    return Article;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public Response putArticle(JAXBElement<Article> Article) {
    Article c = Article.getValue();
    return putAndGetResponse(c);
  }

  @DELETE
  public void deleteArticle() {
    Article c = ArticleDao.instance.getModel().remove(id);
    if (c == null) throw new RuntimeException(
      "Delete: Article with " + id + " not found"
    );
  }

  private Response putAndGetResponse(Article Article) {
    Response res;
    if (ArticleDao.instance.getModel().containsKey(Article.getId())) {
      res = Response.noContent().build();
    } else {
      res = Response.created(uriInfo.getAbsolutePath()).build();
    }
    ArticleDao.instance.getModel().put(Article.getId(), Article);
    return res;
  }
}
