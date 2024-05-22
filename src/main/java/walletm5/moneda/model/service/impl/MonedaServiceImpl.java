package walletm5.moneda.model.service.impl;

import java.util.List;

import walletm5.moneda.model.dao.MonedaDao;
import walletm5.moneda.model.entidad.Moneda;
import walletm5.moneda.model.service.MonedaService;

public class MonedaServiceImpl implements MonedaService {
	
	private MonedaDao monedaDao;
	
	

	public MonedaServiceImpl(MonedaDao monedaDao) {
		this.monedaDao = monedaDao;
	}

	@Override
	public boolean guardar(Moneda moneda) {
		return monedaDao.guardar(moneda);
	}

	@Override
	public boolean editar(Moneda moneda) {
		if(moneda.getCurrency_id() > 0 ) {
			monedaDao.editar(moneda);
			return true;
		}
		return false;
	}

	@Override
	public Moneda obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return monedaDao.obtenerPorId(id);
	}

	@Override
	public List<Moneda> obtenerMonedas() {
		return monedaDao.obtenerMonedas();
	}

}
