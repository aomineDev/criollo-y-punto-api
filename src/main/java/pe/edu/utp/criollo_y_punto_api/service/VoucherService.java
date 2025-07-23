package pe.edu.utp.criollo_y_punto_api.service;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;
import pe.edu.utp.criollo_y_punto_api.model.Ticket;

public interface VoucherService {
    Ticket generarTicket(Ticket ticket);

    Invoice generarInvoice(Invoice invoice);
}
