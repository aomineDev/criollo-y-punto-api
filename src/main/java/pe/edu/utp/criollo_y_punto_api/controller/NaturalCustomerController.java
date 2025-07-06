package pe.edu.utp.criollo_y_punto_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;
import pe.edu.utp.criollo_y_punto_api.service.impl.NaturalCustomerServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/natural-customer")
public class NaturalCustomerController {
  @Autowired
  private NaturalCustomerServiceImpl naturalCustomerService;

  @GetMapping
  public ResponseEntity<List<NaturalCustomer>> getNaturalCustomerList() {
    return ResponseEntity.ok(naturalCustomerService.getAll());
  }

  @PostMapping
  public ResponseEntity<NaturalCustomer> createNaturalCustomer(@RequestBody NaturalCustomer naturalCustomer) {
    return ResponseEntity.status(HttpStatus.CREATED).body(naturalCustomerService.save(naturalCustomer));
  }

}
