package pe.edu.utp.criollo_y_punto_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;
import pe.edu.utp.criollo_y_punto_api.service.JuridicalCustomerService;

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
@RequestMapping("/api/juridical-customer")
public class JuridicalCustomerController {
    @Autowired
    private JuridicalCustomerService service;

    @GetMapping
    public ResponseEntity<List<JuridicalCustomer>> getJuridicalCustomerList() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuridicalCustomer> getJuridicalCustomer(@PathVariable Integer id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JuridicalCustomer> createJuridicalCustomer(@RequestBody JuridicalCustomer juridicalCustomer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(juridicalCustomer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JuridicalCustomer> updateJuridicalCustomer(@PathVariable Integer id,
            @RequestBody JuridicalCustomer juridicalCustomer) {
        return service.update(id, juridicalCustomer)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJuridicalCustomer(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}