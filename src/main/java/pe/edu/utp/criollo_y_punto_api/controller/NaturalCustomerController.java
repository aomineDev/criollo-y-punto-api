package pe.edu.utp.criollo_y_punto_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;
import pe.edu.utp.criollo_y_punto_api.service.NaturalCustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/natural-customer")
public class NaturalCustomerController {
  @Autowired
  private NaturalCustomerService service;

  @GetMapping
  public ResponseEntity<List<NaturalCustomer>> getNaturalCustomerList() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<NaturalCustomer> getNaturalCustomer(@PathVariable Integer id) {
    return service.get(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<NaturalCustomer> createNaturalCustomer(@RequestBody NaturalCustomer naturalCustomer) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(naturalCustomer));
  }

  @PutMapping("/{id}")
  public ResponseEntity<NaturalCustomer> updateNaturalCustomer(@PathVariable Integer id,
      @RequestBody NaturalCustomer naturalCustomer) {
    return service.update(id, naturalCustomer)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNaturalCustomer(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
