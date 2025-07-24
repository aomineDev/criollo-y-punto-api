package pe.edu.utp.criollo_y_punto_api.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;
import pe.edu.utp.criollo_y_punto_api.repository.JuridicalCustomerRepository;

@ExtendWith(MockitoExtension.class)
public class JuridicalCustomerServiceImplTest {
  @Mock
  private JuridicalCustomerRepository repository;

  @InjectMocks
  private JuridicalCustomerServiceImpl service;

  @Test
  void testGetById() {
    JuridicalCustomer juridicalCustomer = new JuridicalCustomer();
    juridicalCustomer.setPersonId(1);
    juridicalCustomer.setRuc("12345678901");

    when(repository.findById(1)).thenReturn(Optional.of(juridicalCustomer));

    JuridicalCustomer result = service.get(1).orElse(null);

    assertEquals("12345678901", result.getRuc());
  }
}
