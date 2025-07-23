package pe.edu.utp.criollo_y_punto_api.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private TicketService ticketService;

    @GetMapping()
    public ResponseEntity<List<Ticket>> getTicket() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket nuevoTicket = voucherService.generarTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTicket);
    }
}
