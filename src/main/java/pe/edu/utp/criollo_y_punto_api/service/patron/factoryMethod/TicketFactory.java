package pe.edu.utp.criollo_y_punto_api.service.patron.factoryMethod;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;
import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.model.OrderItem;
import pe.edu.utp.criollo_y_punto_api.model.Ticket;
import pe.edu.utp.criollo_y_punto_api.model.Voucher;

public class TicketFactory extends VoucherFactory {

    private NaturalCustomer customer;

    public TicketFactory(NaturalCustomer customer) {
        this.customer = customer;
    }

    @Override
    public Voucher createVoucher(Order order) {
        Ticket ticket = new Ticket();
        ticket.setOrder(order);
        ticket.setNaturalCustomer(customer);

        double total = getOrderTotal(order.getOrderItemList());
        double taxed = total / 1.18;
        double igv = total - taxed;

        ticket.setDate(LocalDate.now());
        ticket.setTime(LocalTime.now());
        ticket.setTaxed(taxed);
        ticket.setIgv(igv);
        ticket.setTotalPrice(total);

        return ticket;
    }

    public Double getOrderTotal(List<OrderItem> orderItemList) {
        double total = 0;

        for (OrderItem orderItem : orderItemList) {
            total += orderItem.getQuantity() * orderItem.getMenuItem().getPrice();
        }

        return total;
    }

}
