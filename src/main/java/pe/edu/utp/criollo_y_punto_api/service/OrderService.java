package pe.edu.utp.criollo_y_punto_api.service;

import pe.edu.utp.criollo_y_punto_api.model.Order;

/*Esta interfaz extiende el servicio genérico ApiService<Order>, reutilizando métodos comunes 
*como guardar, actualizar o eliminar pedidos. Además, define operaciones específicas para gestionar el ciclo de vida de una orden,
*como iniciar su preparación, marcarla como lista, entregarla o cancelarla, siguiendo el patrón State aplicado en la entidad Order.
*Esto permite controlar el flujo del pedido según su estado actual.*/
public interface OrderService extends ApiService<Order> {
    Order startPreparation(Integer orderId);

    Order markAsReady(Integer orderId);

    Order deliverOrder(Integer orderId);

    Order cancelOrder(Integer orderId);
}
