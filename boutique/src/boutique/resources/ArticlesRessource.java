package boutique.resources;

import boutique.dao.*;
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

@Path("/articles")
public class ArticlesRessource {

	private BoutiqueDbContext ctx = new BoutiqueDbContext();
	
  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;

  @Context
  Request request;

  // Return the list of Articles to the user in the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Response getArticlesBrowser() {
    List<Article> Articles = new ArrayList<Article>();
    Articles.addAll(ArticleDao.instance.getModel().values());
    return Response
      .status(200)
      .header("Access-Control-Allow-Origin", "*")
      .header(
        "Access-Control-Allow-Headers",
        "origin, content-type, accept, authorization"
      )
      .header("Access-Control-Allow-Credentials", "true")
      .header(
        "Access-Control-Allow-Methods",
        "GET, POST, PUT, DELETE, OPTIONS, HEAD"
      )
      .header("Access-Control-Max-Age", "1209600")
      .entity(Articles)
      .build();
  }

  // Return the list of Articles for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Article> getArticles() {
    List<Article> Articles = new ArrayList<Article>();
    Articles.addAll(ArticleDao.instance.getModel().values());
    return Articles;
  }

  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCount() {
    int count = ArticleDao.instance.getModel().size();
    return String.valueOf(count);
  }

  @Path("{article}")
  public ArticleRessource getArticle(@PathParam("article") int id) {
    return new ArticleRessource(uriInfo, request, id);
  }
  
  @Path("add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public void createArticle(Article article) {
	  ctx.insertArticle(article);
      System.out.print(article.getLibelle());
  }
}
