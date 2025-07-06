package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.utp.criollo_y_punto_api.model.PaymentType;
import pe.edu.utp.criollo_y_punto_api.repository.PaymentTypeRepository;
import pe.edu.utp.criollo_y_punto_api.service.PaymentTypeService;

public class PaymentTypeServiceImpl implements PaymentTypeService {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> getAll() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType get(Integer paymentTypeId) {
        return paymentTypeRepository.findById(paymentTypeId).orElse(null);
    }

    @Override
    public PaymentType save(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public PaymentType update(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public void delete(Integer paymentTypeId) {
        paymentTypeRepository.deleteById(paymentTypeId);
    }
}
