package walletm5.contact.model.service.impl;

import java.util.List;

import walletm5.contact.model.dao.ContactoDao;
import walletm5.contact.model.entidad.Contacto;
import walletm5.contact.model.service.ContactoService;

public class ContactoServiceImpl implements ContactoService {

	ContactoDao contactoDao;
	
	public ContactoServiceImpl(ContactoDao contactoDao) {
		this.contactoDao = contactoDao;
	}

	@Override
	public boolean guardar(Contacto contacto) {
		return contactoDao.guardar(contacto);
	}

	@Override
	public boolean editar(Contacto contacto) {
		return contactoDao.editar(contacto);
	}

	@Override
	public boolean eliminar(int id) {
		return contactoDao.eliminar(id);
	}

	@Override
	public List<Contacto> obtenerContactosPorWallet(int walletId) {
		return contactoDao.obtenerContactosPorWallet(walletId);
	}

}
