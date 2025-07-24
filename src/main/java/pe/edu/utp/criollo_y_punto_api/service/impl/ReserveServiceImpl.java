package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Reserve;
import pe.edu.utp.criollo_y_punto_api.repository.ReserveRepository;
import pe.edu.utp.criollo_y_punto_api.service.ReserveService;

/*
 * Este servicio implementa la lógica de negocio para la entidad Reserve, permitiendo gestionar sus operaciones básicas
 *  como listar, obtener, guardar, actualizar y eliminar entradas de Reserve. Utiliza ReserveRepository para interactuar
 *  con la base de datos, delegando las operaciones CRUD a través de métodos proporcionados por JpaRepository, 
 * lo que facilita el acceso a los datos sin necesidad de escribir consultas manuales.
 */
@Service
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
