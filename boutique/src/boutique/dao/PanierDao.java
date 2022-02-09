package boutique.dao;

import java.util.HashMap;
import java.util.Map;

import boutique.model.*;

public enum PanierDao {
    instance;

    private Map<Integer, Panier> contentProvider = new HashMap<>();

    private PanierDao() {
    	
    	Categorie accessoires = new Categorie("Accessoires ordinateurs");
    	
    	Article souris = ArticleDao.instance.getModel().get(1);
        
    	Panier panier = new Panier();
    	panier.addArticle(souris);
    	
    }
    public Map<Integer, Panier> getModel(){
        return contentProvider;
    }

}