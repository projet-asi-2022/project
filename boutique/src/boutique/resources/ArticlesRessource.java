package boutique.resources;

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

import boutique.dao.*;
import boutique.model.*;

@Path("/articles")
public class ArticlesRessource {
    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of Articles to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Article> getArticlesBrowser() {
        List<Article> Articles = new ArrayList<Article>();
        Articles.addAll(ArticleDao.instance.getModel().values());
        return Articles;
    }

    // Return the list of Articles for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Article> getArticles() {
        List<Article> Articles = new ArrayList<Article>();
        Articles.addAll(ArticleDao.instance.getModel().values());
        return Articles;
    }

    // returns the number of Articles
    // Use http://localhost:8080/com.vogella.jersey.Article/rest/Articles/count
    // rest.Article au lieu de com.vogella.jersey.Article
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = ArticleDao.instance.getModel().size();
        return String.valueOf(count);
    }
    
    // Defines that the next path parameter after articles is
    // treated as a parameter and passed to the TodoResources
    // Allows to type http://localhost:8080/rest.todo/rest/todos/1
    // 1 will be treaded as parameter article and passed to TodoResource
    @Path("{article}")
    public ArticleRessource getArticle(@PathParam("article") int id) {
        return new ArticleRessource(uriInfo, request, id);
    }

}