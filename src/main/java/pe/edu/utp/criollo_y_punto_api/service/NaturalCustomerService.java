package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;

import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;

public interface NaturalCustomerService {
  List<NaturalCustomer> getAll();

  NaturalCustomer get(Integer id);

  NaturalCustomer save(NaturalCustomer naturalCustomer);

  NaturalCustomer update(NaturalCustomer naturalCustomer);

  void delete(Integer id);
}
