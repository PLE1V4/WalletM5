package walletm5.cuenta.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import walletm5.cuenta.model.dao.CuentaDao;
import walletm5.cuenta.model.entidad.Cuenta;
import walletm5.shared.dao.DAO;



public class CuentaDaoImpl extends DAO implements CuentaDao {

	@Override
	public boolean guardar(Cuenta cuenta) {
		
		double saldo = cuenta.getSaldo();
		int moneda = cuenta.getId_moneda();
		
		String query="insert into cuentas (acc_balance,acc_currecy)";
		query+=" values("+saldo+","+moneda+")";
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public boolean editar(Cuenta cuenta) {
		
		double saldo = cuenta.getSaldo();
		int moneda = cuenta.getId_moneda();
		
		String query="update  usuarios ";
		query+=" set acc_balance="+saldo+", acc_currency="+moneda;
		query+=" where acc_number="+cuenta.getNumeroCuenta();
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
		
	}

	@Override
	public Cuenta obtenerPorNumero(int numero) {
		
		try {
			Cuenta cuenta=null;
		
		
			String query="select acc_number,acc_balance,acc_currency from cuentas where acc_number="+numero;
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
					int numeroCuenta=rsl.getInt("acc_number");
					double saldo=rsl.getDouble("acc_balance");
					int moneda= rsl.getInt("acc_currency");
					
				
					cuenta= new Cuenta(numeroCuenta,saldo,moneda);
				
			}
			
			return cuenta;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Cuenta> obtenerCuentas() {
		try {
			List<Cuenta> listado= new ArrayList<>();
		
		
			String query="select acc_number, acc_balance,acc_currency from cuentas";
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
				
					int numero = rsl.getInt("acc_number");
					double saldo=rsl.getDouble("acc_balance");
					int moneda= rsl.getInt("acc_currency");
					
				
					Cuenta cuenta= new Cuenta(numero,saldo,moneda);
					listado.add(cuenta);
				
			}
			
			return listado;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
