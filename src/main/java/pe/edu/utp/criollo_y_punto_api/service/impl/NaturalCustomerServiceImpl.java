package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;
import pe.edu.utp.criollo_y_punto_api.repository.NaturalCustomerRepository;
import pe.edu.utp.criollo_y_punto_api.service.NaturalCustomerService;

/*
 * Este servicio implementa la lógica de negocio para la entidad NaturalCustomer, permitiendo gestionar sus operaciones básicas
 *  como listar, obtener, guardar, actualizar y eliminar entradas de NaturalCustomer. Utiliza NaturalCustomerRepository para interactuar
 *  con la base de datos, delegando las operaciones CRUD a través de métodos proporcionados por JpaRepository, 
 * lo que facilita el acceso a los datos sin necesidad de escribir consultas manuales.
 */
@Service
public class NaturalCustomerServiceImpl implements NaturalCustomerService {
  @Autowired
  private NaturalCustomerRepository naturalCustomerRepository;

  @Override
  public List<NaturalCustomer> getAll() {
    return naturalCustomerRepository.findAll();
  }

  @Override
  public NaturalCustomer get(Integer id) {
    return naturalCustomerRepository.findById(id).orElse(null);
  }

  @Override
  public NaturalCustomer save(NaturalCustomer naturalCustomer) {
    return naturalCustomerRepository.save(naturalCustomer);
  }

  @Override
  public NaturalCustomer update(NaturalCustomer naturalCustomer) {
    return naturalCustomerRepository.save(naturalCustomer);
  }

  @Override
  public void delete(Integer id) {
    naturalCustomerRepository.deleteById(id);
  }
}
