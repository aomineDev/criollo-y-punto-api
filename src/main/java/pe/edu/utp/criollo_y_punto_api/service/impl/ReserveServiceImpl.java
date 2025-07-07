package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.utp.criollo_y_punto_api.model.Reserve;
import pe.edu.utp.criollo_y_punto_api.repository.ReserveRepository;
import pe.edu.utp.criollo_y_punto_api.service.ReserveService;

public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveRepository reserveRepository;

    @Override
    public List<Reserve> getAll() {
        return reserveRepository.findAll();
    }

    @Override
    public Reserve get(Integer reserveid) {
        return reserveRepository.findById(reserveid).orElse(null);
    }

    @Override
    public Reserve save(Reserve reserve) {
    return reserveRepository.save(reserve);

    }

    @Override
    public Reserve update(Reserve reserve) {
    return reserveRepository.save(reserve);

    }

    @Override
    public void delete(Integer reserveid) {
    reserveRepository.deleteById(reserveid);

    }

}
