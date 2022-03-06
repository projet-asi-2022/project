package boutique.dao;

import boutique.model.*;
import java.util.HashMap;
import java.util.Map;

public enum PanierDao {
  instance;

  private Map<Integer, Panier> contentProvider = new HashMap<>();

  private PanierDao() {
 

    Article souris = ArticleDao.instance.getModel().get(1);
    Utilisateur user1=new Utilisateur(3, "name", "prenom", "emai@gmail.com", "testmdp", "02/11/1855", Role.Admin);
    Panier panier = new Panier(1,user1);
    panier.addArticle(souris);
    contentProvider.put(1, panier);
  }

  public Map<Integer, Panier> getModel() {
    return contentProvider;
  }
}
