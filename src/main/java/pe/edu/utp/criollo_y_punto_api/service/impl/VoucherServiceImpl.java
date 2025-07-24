package pe.edu.utp.criollo_y_punto_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;
import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;
import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;
import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.model.Ticket;
import pe.edu.utp.criollo_y_punto_api.model.Voucher;
import pe.edu.utp.criollo_y_punto_api.service.InvoiceService;
import pe.edu.utp.criollo_y_punto_api.service.JuridicalCustomerService;
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

    @Autowired
    private JuridicalCustomerService juridicalCustomerService;

    @Override
    public Ticket generarTicket(Ticket ticket) {

        Order order = orderService.get(ticket.getOrder().getOrderId());
        NaturalCustomer customer = naturalCustomerService.get(ticket.getNaturalCustomer().getPersonId());

        VoucherFactory factory = new TicketFactory(customer);
        Ticket nuevoTicket = (Ticket) factory.createVoucher(order);

        aplicarDescuentosYAdicionales(nuevoTicket, ticket);

        return ticketService.save(nuevoTicket);
    }

    @Override
    public Invoice generarInvoice(Invoice invoice) {

        Order order = orderService.get(invoice.getOrder().getOrderId());
        JuridicalCustomer customer = juridicalCustomerService.get(invoice.getJuridicalCustomer().getPersonId());

        VoucherFactory factory = new InvoiceFactory(customer);
        Invoice nuevaFactura = (Invoice) factory.createVoucher(order);

        aplicarDescuentosYAdicionales(nuevaFactura, invoice);

        return invoiceService.save(nuevaFactura);
    }

    public void aplicarDescuentosYAdicionales(Voucher base, Voucher entrada) {
        double discount = entrada.getDiscount() != null ? entrada.getDiscount() : 0.0;
        double additional = entrada.getAdditionalPayments() != null ? entrada.getAdditionalPayments() : 0.0;

        base.setDiscount(discount);
        base.setAdditionalPayments(additional);

        double finalTotal = base.getTotalPrice() - discount + additional;
        base.setTotalPrice(finalTotal);
    }

}
