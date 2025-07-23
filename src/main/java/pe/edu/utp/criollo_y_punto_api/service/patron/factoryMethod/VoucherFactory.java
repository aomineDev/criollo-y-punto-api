package pe.edu.utp.criollo_y_punto_api.service.patron.factoryMethod;

import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.model.Voucher;

public abstract class VoucherFactory {
    public abstract Voucher createVoucher(Order order);
}
