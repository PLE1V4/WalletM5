package walletm5.cuenta.model.service;

import java.util.List;

import walletm5.cuenta.model.entidad.Cuenta;

public interface CuentaService {
	
	boolean guardar(Cuenta cuenta);
	boolean editar(Cuenta cuenta );
	Cuenta obtenerPorNumero(int numero);
	List<Cuenta> obtenerCuentas();

}
