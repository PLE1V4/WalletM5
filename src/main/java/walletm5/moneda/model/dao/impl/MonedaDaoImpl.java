package walletm5.moneda.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import walletm5.moneda.model.dao.MonedaDao;
import walletm5.moneda.model.entidad.Moneda;
import walletm5.shared.dao.DAO;

public class MonedaDaoImpl extends DAO implements MonedaDao {

	@Override
	public boolean guardar(Moneda moneda) {
		
		String nombre = moneda.getCurrency_name();
		String symbol = moneda.getCurrency_symbol();
		double exchangeRate = moneda.getExchange_rate();
		
		String query="insert into monedas (currency_name,currency_symbol,currency_exchangeRate)";
		query+=" values('"+nombre+"','"+symbol+"',"+exchangeRate;
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public boolean editar(Moneda moneda) {
		String nombre = moneda.getCurrency_name();
		String symbol = moneda.getCurrency_symbol();
		double exchangeRate = moneda.getExchange_rate();
		
		String query="update monedas ";
		query+=" set currency_name='"+nombre+"', currency_symbol='"+symbol+"',currency_exchangeRate="+exchangeRate;
		query+=" where currency_id="+moneda.getCurrency_id();
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public Moneda obtenerPorId(int id) {
		try {
			Moneda moneda=null;
		
		
			String query="select currency_id, currency_name, currency_symbol, currency_exchangeRate from monedas where currency_id="+id;
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
					
				int currencyId = rsl.getInt("currency_id");
				String currencyName = rsl.getString("currency_name");
				String currencySymbol = rsl.getString("currency_symbol");
				double exchangeRate = rsl.getDouble("currency_exchangeRate");
				
				moneda= new Moneda(currencyId,currencyName,currencySymbol,exchangeRate);
				
			}
			
			return moneda;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Moneda> obtenerMonedas() {
		try {
			List<Moneda> listado= new ArrayList<>();
		
		
			String query="select currency_id, currency_name, currency_symbol, currency_exchangeRate from monedas";
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
				
					int id = rsl.getInt("currency_id");
					String name = rsl.getString("currency_name");
					String symbol = rsl.getString("currency_symbol");
					double exchangeRate = rsl.getDouble("currency_exchangeRate");
				
					Moneda moneda= new Moneda(id,name,symbol,exchangeRate);
					listado.add(moneda);
				
			}
			
			return listado;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
