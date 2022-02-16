package boutique.dao;

import boutique.model.*;
import java.util.HashMap;
import java.util.Map;

public enum CategorieDao {
  instance;

  private Map<Integer, Categorie> contentProvider = new HashMap<>();

  private CategorieDao() {
    Categorie accessoires = new Categorie("Accessoires ordinateurs");
    contentProvider.put(1, accessoires);
  }

  public Map<Integer, Categorie> getModel() {
    return contentProvider;
  }
}
