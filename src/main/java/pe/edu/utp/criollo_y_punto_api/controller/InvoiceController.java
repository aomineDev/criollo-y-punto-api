package pe.edu.utp.criollo_y_punto_api.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;
import pe.edu.utp.criollo_y_punto_api.service.InvoiceService;
import pe.edu.utp.criollo_y_punto_api.service.VoucherService;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private InvoiceService service;

    @GetMapping()
    public ResponseEntity<List<Invoice>> getInvoice() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Integer id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice nuevoInvoice = voucherService.generarInvoice(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInvoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Integer id,
            @RequestBody Invoice invoice) {
        return service.update(id, invoice)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
