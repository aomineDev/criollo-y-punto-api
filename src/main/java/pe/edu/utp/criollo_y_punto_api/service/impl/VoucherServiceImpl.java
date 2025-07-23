package pe.edu.utp.criollo_y_punto_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;
import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;
import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.model.Ticket;
import pe.edu.utp.criollo_y_punto_api.service.InvoiceService;
import pe.edu.utp.criollo_y_punto_api.service.NaturalCustomerService;
import pe.edu.utp.criollo_y_punto_api.service.OrderService;
import pe.edu.utp.criollo_y_punto_api.service.TicketService;
import pe.edu.utp.criollo_y_punto_api.service.VoucherService;
import pe.edu.utp.criollo_y_punto_api.service.patron.factoryMethod.InvoiceFactory;
import pe.edu.utp.criollo_y_punto_api.service.patron.factoryMethod.TicketFactory;
import pe.edu.utp.criollo_y_punto_api.service.patron.factoryMethod.VoucherFactory;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private NaturalCustomerService naturalCustomerService;

    @Override
    public Ticket generarTicket(Ticket ticket) {

        Order order = orderService.get(ticket.getOrder().getOrderId());
        NaturalCustomer customer = naturalCustomerService.get(ticket.getNaturalCustomer().getPersonId());

        VoucherFactory factory = new TicketFactory(customer);
        Ticket nuevoTicket = (Ticket) factory.createVoucher(order);

        double discount = ticket.getDiscount() != null ? ticket.getDiscount() : 0.0;
        double additional = ticket.getAdditionalPayments() != null ? ticket.getAdditionalPayments() : 0.0;

        nuevoTicket.setDiscount(discount);
        nuevoTicket.setAdditionalPayments(additional);

        double finalTotal = nuevoTicket.getTotalPrice() - discount + additional;
        nuevoTicket.setTotalPrice(finalTotal);

        return ticketService.save(nuevoTicket);
    }

    @Override
    public Invoice generarInvoice(Invoice invoice) {
        VoucherFactory factory = new InvoiceFactory(invoice.getJuridicalCustomer());
        Invoice nuevaFactura = (Invoice) factory.createVoucher(invoice.getOrder());

        // nuevaFactura.setDiscount(invoice.getDiscount());
        // nuevaFactura.setAdditionalPayments(invoice.getAdditionalPayments());
        // nuevaFactura.setTurned(invoice.getTurned());

        return invoiceService.save(nuevaFactura);
    }

}
