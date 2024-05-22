package walletm5.cuenta.model.dao;

import java.util.List;

import walletm5.cuenta.model.entidad.Cuenta;

public interface CuentaDao {
	
	boolean guardar(Cuenta cuenta);
	boolean editar(Cuenta cuenta );
	Cuenta obtenerPorNumero(int numero);
	List<Cuenta> obtenerCuentas();

}
