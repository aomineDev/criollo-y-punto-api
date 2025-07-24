package pe.edu.utp.criollo_y_punto_api.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;
import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;
import pe.edu.utp.criollo_y_punto_api.repository.InvoiceRepository;
import pe.edu.utp.criollo_y_punto_api.repository.MenuCategoryRepository;

@ExtendWith(MockitoExtension.class)
public class InvoiceServiceImplTest {
  @Mock
  private InvoiceRepository repository;

  @InjectMocks
  private InvoiceServiceImpl service;

  @Test
  void testGetById() {
    Invoice invoice = new Invoice();
    invoice.setVoucherId(1);
    invoice.setTotalPrice(100.5);

    when(repository.findById(1)).thenReturn(Optional.of(invoice));

    Invoice result = service.get(1).orElse(null);

    assertEquals(100.5, result.getTotalPrice());
  }
}
