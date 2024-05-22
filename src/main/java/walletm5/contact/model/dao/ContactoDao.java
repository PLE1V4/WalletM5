package walletm5.contact.model.dao;

import java.util.List;

import walletm5.contact.model.entidad.Contacto;

public interface ContactoDao {
	
	boolean guardar(Contacto contacto);
	boolean editar(Contacto contacto);
	boolean eliminar(int id);
	List<Contacto> obtenerContactosPorWallet(int walletId);

}
