package boutique.dao;

import boutique.model.*;
import java.util.HashMap;
import java.util.Map;

public enum UtilisateurDao {
  instance;

  private Map<Integer, Utilisateur> contentProvider = new HashMap<>();

  private UtilisateurDao() {
	Utilisateur utilisateur = new Utilisateur(1,"moi","meme","je@ke.com","lol","22/04/2000",Role.Admin);
    contentProvider.put(1, utilisateur);
  }

  public Map<Integer, Utilisateur> getModel() {
    return contentProvider;
  }
}
