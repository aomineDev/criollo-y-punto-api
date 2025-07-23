package pe.edu.utp.criollo_y_punto_api.service.patron.factoryMethod;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;
import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;
import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.model.OrderItem;
import pe.edu.utp.criollo_y_punto_api.model.Voucher;

public class InvoiceFactory extends VoucherFactory {

    private JuridicalCustomer customer;

    public InvoiceFactory(JuridicalCustomer customer) {
        this.customer = customer;
    }

    @Override
    public Voucher createVoucher(Order order) {
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setJuridicalCustomer(customer);

        double total = getOrderTotal(order.getOrderItemList());
        double taxed = total / 1.18;
        double igv = total - taxed;

        invoice.setDate(LocalDate.now());
        invoice.setTime(LocalTime.now());
        invoice.setTaxed(taxed);
        invoice.setIgv(igv);
        invoice.setTotalPrice(total);

        return invoice;
    }

    public Double getOrderTotal(List<OrderItem> orderItemList) {
        double total = 0;

        for (OrderItem orderItem : orderItemList) {
            total += orderItem.getQuantity() * orderItem.getMenuItem().getPrice();
        }

        return total;
    }
}
