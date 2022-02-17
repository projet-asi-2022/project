package boutique.dao;

import boutique.model.*;
import java.util.HashMap;
import java.util.Map;

public enum CategorieDao {
  instance;

  private Map<String, Categorie> contentProvider = new HashMap<>();

  private CategorieDao() {
    Categorie accessoires = new Categorie("Accessoires ordinateurs");
    contentProvider.put("nom", accessoires);
  }

  public Map<String, Categorie> getModel() {
    return contentProvider;
  }
}
