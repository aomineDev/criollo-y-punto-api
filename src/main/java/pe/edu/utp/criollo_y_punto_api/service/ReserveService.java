package pe.edu.utp.criollo_y_punto_api.service;

import pe.edu.utp.criollo_y_punto_api.model.Reserve;

/*
 * Esta interfaz extiende ApiService especificando la entidad Reserve, lo que significa que hereda todos los métodos genéricos 
 * definidos en ApiService (como getAll, get, save, update y delete), pero aplicados exclusivamente a objetos de tipo Reserve.
 *  Esto permite definir una capa de servicio clara y reutilizable para la entidad sin necesidad de reescribir las operaciones
 *  CRUD básicas.
 */
public interface ReserveService extends ApiService<Reserve> {

}
