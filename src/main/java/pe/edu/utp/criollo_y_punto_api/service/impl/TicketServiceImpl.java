package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Ticket;
import pe.edu.utp.criollo_y_punto_api.repository.TicketRepository;
import pe.edu.utp.criollo_y_punto_api.service.TicketService;

/*
 * Este servicio implementa la lógica de negocio para la entidad Ticket, permitiendo gestionar sus operaciones básicas
 *  como listar, obtener, guardar, actualizar y eliminar entradas de Ticket. Utiliza TicketRepository para interactuar
 *  con la base de datos, delegando las operaciones CRUD a través de métodos proporcionados por JpaRepository, 
 * lo que facilita el acceso a los datos sin necesidad de escribir consultas manuales.
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> get(Integer ticketid) {
        return ticketRepository.findById(ticketid);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> update(Integer id, Ticket ticket) {
        return ticketRepository.findById(id).map(existingTicket -> {
            ticket.setVoucherId(id);

            return ticketRepository.save(ticket);
        });
    }

    @Override
    public void delete(Integer ticketid) {
        ticketRepository.deleteById(ticketid);
    }

}
