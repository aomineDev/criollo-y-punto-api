package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Reserve;
import pe.edu.utp.criollo_y_punto_api.repository.ReserveRepository;
import pe.edu.utp.criollo_y_punto_api.service.ReserveService;

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveRepository reserveRepository;

    @Override
    public List<Reserve> getAll() {
        return reserveRepository.findAll();
    }

    @Override
    public Optional<Reserve> get(Integer reserveid) {
        return reserveRepository.findById(reserveid);
    }

    @Override
    public Reserve save(Reserve reserve) {
        return reserveRepository.save(reserve);
    }

    @Override
    public Optional<Reserve> update(Integer id, Reserve reserve) {
        return reserveRepository.findById(id).map(existingReserve -> {
            reserve.setReserveId(id);

            return reserveRepository.save(reserve);
        });
    }

    @Override
    public void delete(Integer reserveid) {
        reserveRepository.deleteById(reserveid);
    }

}
