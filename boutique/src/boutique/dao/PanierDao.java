package boutique.dao;

import boutique.model.*;
import java.util.HashMap;
import java.util.Map;

public enum PanierDao {
  instance;

  private Map<Integer, Panier> contentProvider = new HashMap<>();

  private PanierDao() {
    Categorie accessoires = new Categorie(1, "Accessoires ordinateurs");

    Article souris = ArticleDao.instance.getModel().get(1);

    Panier panier = new Panier(1);
    panier.addArticle(souris);
    contentProvider.put(1, panier);
  }

  public Map<Integer, Panier> getModel() {
    return contentProvider;
  }
}
