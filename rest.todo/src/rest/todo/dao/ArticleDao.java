package rest.todo.dao;

import java.util.HashMap;
import java.util.Map;

import rest.todo.model.*;

public enum ArticleDao {
    instance;

    private Map<Integer, Article> contentProvider = new HashMap<>();

    private ArticleDao() {
    	
    	Categorie accessoires = new Categorie("Accessoires ordinateurs");
    	
        Article souris = new Article("Souris gaming XG5600XXXBG", "LOGIMEGATECH", 250, accessoires);
        // String libelle, String marque, float prix, Categorie categorie, Photo photo
        contentProvider.put(1, souris);
        
        System.out.println(souris);

    }
    public Map<Integer, Article> getModel(){
        return contentProvider;
    }

}