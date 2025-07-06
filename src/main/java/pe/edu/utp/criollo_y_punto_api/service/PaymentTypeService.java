package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;

import pe.edu.utp.criollo_y_punto_api.model.PaymentType;

public interface PaymentTypeService {

    List<PaymentType> getAll();

    PaymentType get(Integer paymentTypeId);

    PaymentType save(PaymentType paymentType);

    PaymentType update(PaymentType paymentType);

    void delete(Integer paymentTypeId);

}
