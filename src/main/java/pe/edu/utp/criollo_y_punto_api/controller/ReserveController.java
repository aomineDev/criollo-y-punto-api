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

import pe.edu.utp.criollo_y_punto_api.model.Reserve;
import pe.edu.utp.criollo_y_punto_api.service.ReserveService;

@RestController
@RequestMapping("/api/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @GetMapping
    public ResponseEntity<List<Reserve>> getReserveList() {
        return ResponseEntity.ok(reserveService.getAll());
    }

    @PostMapping
    public ResponseEntity<Reserve> createReserve(@RequestBody Reserve reserve) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reserveService.save(reserve));
    }

}
