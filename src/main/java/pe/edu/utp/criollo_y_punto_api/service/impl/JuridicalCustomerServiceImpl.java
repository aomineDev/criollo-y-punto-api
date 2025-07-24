package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;
import pe.edu.utp.criollo_y_punto_api.repository.JuridicalCustomerRepository;
import pe.edu.utp.criollo_y_punto_api.service.JuridicalCustomerService;

@Service
public class JuridicalCustomerServiceImpl implements JuridicalCustomerService {
  @Autowired
  private JuridicalCustomerRepository juridicalCustomerRepository;

  @Override
  public List<JuridicalCustomer> getAll() {
    return juridicalCustomerRepository.findAll();
  }

  @Override
  public Optional<JuridicalCustomer> get(Integer juridicalCustomerId) {
    return juridicalCustomerRepository.findById(juridicalCustomerId);
  }

  @Override
  public JuridicalCustomer save(JuridicalCustomer juridicalCustomer) {
    return juridicalCustomerRepository.save(juridicalCustomer);
  }

  @Override
  public Optional<JuridicalCustomer> update(Integer id, JuridicalCustomer juridicalCustomer) {
    return juridicalCustomerRepository.findById(id).map(existingJuridicalCustomer -> {
      juridicalCustomer.setPersonId(id);

      return juridicalCustomerRepository.save(juridicalCustomer);
    });
  }

  @Override
  public void delete(Integer juridicalCustomerId) {
    juridicalCustomerRepository.deleteById(juridicalCustomerId);
  }
}
