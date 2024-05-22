package walletm5.moneda.model.dao;

import java.util.List;

import walletm5.moneda.model.entidad.Moneda;

public interface MonedaDao {

	boolean guardar(Moneda moneda);
	boolean editar(Moneda moneda );
	Moneda obtenerPorId(int id);
	List<Moneda> obtenerMonedas();
}
