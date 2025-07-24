package pe.edu.utp.criollo_y_punto_api.service;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;
import pe.edu.utp.criollo_y_punto_api.model.Ticket;

/*Esta interfaz define un contrato para la generación de comprobantes (Voucher) específicos en el sistema,
 *permitiendo crear tanto boletas (Ticket) como facturas (Invoice). A diferencia de un servicio genérico, esta interfaz está enfocada
 *únicamente en la lógica de generación de estos dos tipos de documentos,
 *ofreciendo un punto centralizado para su creación según la lógica del negocio.
*/
public interface VoucherService {
    Ticket generarTicket(Ticket ticket);

    Invoice generarInvoice(Invoice invoice);
}
