package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;
import pe.edu.utp.criollo_y_punto_api.repository.InvoiceRepository;
import pe.edu.utp.criollo_y_punto_api.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
  @Autowired
  private InvoiceRepository invoiceRepository;

  @Override
  public List<Invoice> getAll() {
    return invoiceRepository.findAll();
  }

  @Override
  public Invoice get(Integer invoiceId) {
    return invoiceRepository.findById(invoiceId).orElse(null);
  }

  @Override
  public Invoice save(Invoice invoice) {
    return invoiceRepository.save(invoice);
  }

  @Override
  public Invoice update(Invoice invoice) {
    return invoiceRepository.save(invoice);
  }

  @Override
  public void delete(Integer invoiceId) {
    invoiceRepository.deleteById(invoiceId);
  }
}
