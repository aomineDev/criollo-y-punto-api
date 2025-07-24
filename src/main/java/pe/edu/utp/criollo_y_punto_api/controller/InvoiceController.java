package pe.edu.utp.criollo_y_punto_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private InvoiceService invoiceService;

    @GetMapping()
    public ResponseEntity<List<Invoice>> getInvoice() {
        return ResponseEntity.ok(invoiceService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice nuevoInvoice = voucherService.generarInvoice(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInvoice);
    }
}
