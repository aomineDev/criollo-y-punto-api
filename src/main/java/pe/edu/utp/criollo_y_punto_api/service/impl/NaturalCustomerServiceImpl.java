package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;
import pe.edu.utp.criollo_y_punto_api.repository.NaturalCustomerRepository;
import pe.edu.utp.criollo_y_punto_api.service.NaturalCustomerService;

@Service
public class NaturalCustomerServiceImpl implements NaturalCustomerService {
  @Autowired
  private NaturalCustomerRepository naturalCustomerRepository;

  @Override
  public List<NaturalCustomer> getAll() {
    return naturalCustomerRepository.findAll();
  }

  @Override
  public Optional<NaturalCustomer> get(Integer id) {
    return naturalCustomerRepository.findById(id);
  }

  @Override
  public NaturalCustomer save(NaturalCustomer naturalCustomer) {
    return naturalCustomerRepository.save(naturalCustomer);
  }

  @Override
  public Optional<NaturalCustomer> update(Integer id, NaturalCustomer naturalCustomer) {
    return naturalCustomerRepository.findById(id).map(existingNaturalCustomer -> {
      naturalCustomer.setPersonId(id);

      return naturalCustomerRepository.save(naturalCustomer);
    });
  }

  @Override
  public void delete(Integer id) {
    naturalCustomerRepository.deleteById(id);
  }
}
