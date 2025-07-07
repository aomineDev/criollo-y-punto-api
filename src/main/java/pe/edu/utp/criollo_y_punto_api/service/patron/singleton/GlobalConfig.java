package pe.edu.utp.criollo_y_punto_api.service.patron.singleton;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalConfig {
  private static GlobalConfig instance;
  private final String clienteApiKey;
  private final String clienteApiUrl;
  private final String clienteReniecApiUrl;
  private final String clienteSunatApiUrl;

  private GlobalConfig() {
    Dotenv dotenv = Dotenv.load();
    clienteApiKey = dotenv.get("CLIENTE_API_KEY");

    clienteApiUrl = "https://api.apis.net.pe/v2/";

    clienteReniecApiUrl = clienteApiUrl + "reniec/dni?numero=";
    clienteSunatApiUrl = clienteApiUrl + "sunat/ruc/full?numero=";
  }

  public static GlobalConfig getInstance() {
    if (instance == null) {
      instance = new GlobalConfig();
    }

    return instance;
  }
}
