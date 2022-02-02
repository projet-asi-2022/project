package rest.todo.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import rest.todo.model.Todo;



public class Tester {
  public static void main(String[] args) {


      ClientConfig config = new ClientConfig();
      Client client = ClientBuilder.newClient(config);
      WebTarget service = client.target(getBaseURI());

      // create one todo
      Todo todo = new Todo("3", "Blabla");
      todo.setDescription("toujours Blabla");
      Response response = service.path("rest").path("todos").path(todo.getId()).request(MediaType.APPLICATION_XML).put(Entity.entity(todo,MediaType.APPLICATION_XML),Response.class);

      // Return code should be 201 == created resource
      System.out.println(response.getStatus());

      // Get the Todos
      System.out.println(service.path("rest").path("todos").request().accept(MediaType.TEXT_XML).get(String.class));
      
      //If we want a collection of todos
      
      List<Todo> listeTodos=client.target("http://localhost:8080/rest.todo/rest/todos").request(MediaType.APPLICATION_XML).get(new GenericType<List<Todo>>(){});
    
      for(Todo todoitem:listeTodos){
    	  System.out.println("Todo id: "+todoitem.getId()+", Todo description : "+todoitem.getDescription());
      }

    // Get JSON for application (Make sure to add the jersey-media-json-jackson dependency to add support for JSON)
      System.out.println(service.path("rest").path("todos").request().accept(MediaType.APPLICATION_JSON).get(String.class));

      // Get XML for application
      System.out.println(service.path("rest").path("todos").request().accept(MediaType.APPLICATION_XML).get(String.class));

      //Get Todo with id 1
     // Response checkget = service.path("rest").path("todos/1").request().accept(MediaType.APPLICATION_XML).get();
      Response checkget = service.path("rest").path("todos").path("{todo}").resolveTemplate("todo", "1").request().accept(MediaType.APPLICATION_XML).get();
      System.out.println(checkget);

      //Delete Todo with id 1
      service.path("rest").path("todos/1").request().delete();

      //Get get all Todos id 1 should be deleted
      System.out.println(service.path("rest").path("todos").request().accept(MediaType.APPLICATION_XML).get(String.class));

      //Create a Todo
      Form form =new Form();
      form.param("id", "4");
      form.param("summary","Demonstration of the client lib for forms");
      //On peut utiliser Entity.entity() ou bien Entity.form
     // response = service.path("rest").path("todos").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
      response = service.path("rest").path("todos").request().post(Entity.form(form),Response.class);
      
      System.out.println("Form response " + response.getStatus());

      //Get all the todos, id 4 should have been created
      System.out.println(service.path("rest").path("todos").request().accept(MediaType.APPLICATION_XML).get(String.class));

  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/rest.todo").build();
  }
}