package pe.edu.utp.criollo_y_punto_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;
import pe.edu.utp.criollo_y_punto_api.service.JuridicalCustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/juridical-customer")
public class JuridicalCustomerController {
    @Autowired
    private JuridicalCustomerService juridicalCustomerService;

    @GetMapping
    public ResponseEntity<List<JuridicalCustomer>> getJuridicalCustomerList() {
        return ResponseEntity.ok(juridicalCustomerService.getAll());
    }

    @PostMapping
    public ResponseEntity<JuridicalCustomer> createJuridicalCustomer(@RequestBody JuridicalCustomer juridicalCustomer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(juridicalCustomerService.save(juridicalCustomer));
    }

}