package pe.edu.utp.criollo_y_punto_api.service.patron.singleton;

import pe.edu.utp.criollo_y_punto_api.model.User;

public class Store {
  private static Store instance;

  private User user;

  private Store() {
  }

  public static Store getInstance() {
    if (instance == null) {
      instance = new Store();
    }

    return instance;
  }

  public static void install() {
    instance = new Store();
  }

  public void setUser(User user) {
    instance.user = user;
  }

  public User getUser() {
    return instance.user;
  }
}
