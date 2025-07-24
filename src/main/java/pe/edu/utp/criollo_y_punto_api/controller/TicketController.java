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

import pe.edu.utp.criollo_y_punto_api.model.Ticket;
import pe.edu.utp.criollo_y_punto_api.service.TicketService;
import pe.edu.utp.criollo_y_punto_api.service.VoucherService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private TicketService service;

    @GetMapping()
    public ResponseEntity<List<Ticket>> getTicket() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Integer id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket nuevoTicket = voucherService.generarTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Integer id,
            @RequestBody Ticket ticket) {
        return service.update(id, ticket)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
