package walletm5.moneda.model.service;

import java.util.List;

import walletm5.moneda.model.entidad.Moneda;

public interface MonedaService {

	boolean guardar(Moneda moneda);
	boolean editar(Moneda moneda );
	Moneda obtenerPorId(int id);
	List<Moneda> obtenerMonedas();

}
