package boutique.dao;

import java.util.HashMap;
import java.util.Map;

import boutique.model.*;

public enum ArticleDao {
    instance;

    private Map<Integer, Article> contentProvider = new HashMap<>();

    private ArticleDao() {
    	
    	Categorie accessoires = new Categorie(1, "Accessoires");
    	
        Article souris = new Article(1,"Souris gaming", "LOGIMEGATECH", 250, accessoires);
        // String libelle, String marque, float prix, Categorie categorie, Photo photo
        contentProvider.put(1, souris);
        
Categorie pcbureau = new Categorie(2, "PcBureau");
    	
        Article pcbureau1 = new Article(2,"omen", "HP", 1500, pcbureau);
        // String libelle, String marque, float prix, Categorie categorie, Photo photo
        contentProvider.put(2, pcbureau1);
        

    	
        Article pcbureau2 = new Article(3,"Dell", "HP", 1000, pcbureau);
        // String libelle, String marque, float prix, Categorie categorie, Photo photo
        contentProvider.put(3, pcbureau2);
        
Categorie pcPortable = new Categorie(3, "PcPortable");
    	
        Article pcportable = new Article(4,"MAC", "Apple", 1900, pcPortable);
        // String libelle, String marque, float prix, Categorie categorie, Photo photo
        contentProvider.put(4, pcportable);
        System.out.println(souris);

    }
    public Map<Integer, Article> getModel(){
        return contentProvider;
    }

}