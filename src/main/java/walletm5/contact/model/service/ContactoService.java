package walletm5.contact.model.service;

import java.util.List;

import walletm5.contact.model.entidad.Contacto;

public interface ContactoService {

	boolean guardar(Contacto contacto);
	boolean editar(Contacto contacto);
	boolean eliminar(int id);
	List<Contacto> obtenerContactosPorWallet(int walletId);
	Contacto obtenerPorId(int id);
}
