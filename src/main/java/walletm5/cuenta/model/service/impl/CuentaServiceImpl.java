package walletm5.cuenta.model.service.impl;

import java.util.List;

import walletm5.cuenta.model.dao.CuentaDao;
import walletm5.cuenta.model.entidad.Cuenta;
import walletm5.cuenta.model.service.CuentaService;

public class CuentaServiceImpl implements CuentaService {
	
	private CuentaDao cuentaDao;
	
	

	public CuentaServiceImpl(CuentaDao cuentaDao) {
		this.cuentaDao = cuentaDao;
	}

	@Override
	public boolean guardar(Cuenta cuenta) {
		if(!Double.isNaN(cuenta.getSaldo())
			&& cuenta.getId_moneda() <= 1) {
			return cuentaDao.guardar(cuenta);
		}else {
			return false;
		}
	}

	@Override
	public boolean editar(Cuenta cuenta) {
		
		if(cuenta.getNumeroCuenta() > 0 ) {
			cuentaDao.editar(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public Cuenta obtenerPorNumero(int numero) {
		return cuentaDao.obtenerPorNumero(numero);
	}

	@Override
	public List<Cuenta> obtenerCuentas() {
		return cuentaDao.obtenerCuentas();
	}

}
