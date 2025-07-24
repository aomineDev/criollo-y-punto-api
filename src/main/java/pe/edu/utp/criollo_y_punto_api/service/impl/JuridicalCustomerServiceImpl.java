package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;
import pe.edu.utp.criollo_y_punto_api.repository.JuridicalCustomerRepository;
import pe.edu.utp.criollo_y_punto_api.service.JuridicalCustomerService;

/*
 * Este servicio implementa la lógica de negocio para la entidad JuridicalCustomer, permitiendo gestionar sus operaciones básicas
 *  como listar, obtener, guardar, actualizar y eliminar entradas de JuridicalCustomer. Utiliza JuricalCustomerRepository para interactuar
 *  con la base de datos, delegando las operaciones CRUD a través de métodos proporcionados por JpaRepository, 
 * lo que facilita el acceso a los datos sin necesidad de escribir consultas manuales.
 */
@Service
public class JuridicalCustomerServiceImpl implements JuridicalCustomerService {
  @Autowired
  private JuridicalCustomerRepository juridicalCustomerRepository;

  @Override
  public List<JuridicalCustomer> getAll() {
    return juridicalCustomerRepository.findAll();
  }

  @Override
  public JuridicalCustomer get(Integer juridicalCustomerId) {
    return juridicalCustomerRepository.findById(juridicalCustomerId).orElse(null);
  }

  @Override
  public JuridicalCustomer save(JuridicalCustomer juridicalCustomer) {
    return juridicalCustomerRepository.save(juridicalCustomer);
  }

  @Override
  public JuridicalCustomer update(JuridicalCustomer juridicalCustomer) {
    return juridicalCustomerRepository.save(juridicalCustomer);
  }

  @Override
  public void delete(Integer juridicalCustomerId) {
    juridicalCustomerRepository.deleteById(juridicalCustomerId);
  }
}
