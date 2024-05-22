package walletm5.contact.model.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import walletm5.contact.model.dao.ContactoDao;
import walletm5.contact.model.entidad.Contacto;
import walletm5.shared.dao.DAO;


public class ContactoDaoImpl extends DAO implements ContactoDao {

	@Override
	public boolean guardar(Contacto contacto) {
		
		int wallet = contacto.getWalletId();
		String nombre = contacto.getName();
		int cuenta = contacto.getAccountNum();
		
		String query="insert into contactos (wallet_id,contact_name,acc_number)";
		query+=" values("+wallet+",'"+nombre+"',"+cuenta+")";
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public boolean editar(Contacto contacto) {
		
		String nombre = contacto.getName();
		int cuenta = contacto.getAccountNum();
		
		String query="update contactos ";
		query+=" set contact_name='"+nombre+"', acc_number="+cuenta;
		query+=" where contact_id="+contacto.getContactId();
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public boolean eliminar(int id) {
		
		String query="delete from contactos where contact_id ="+id;
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}
		
	

	@Override
	public List<Contacto> obtenerContactosPorWallet(int walletId) {
		
		try {
			List<Contacto> listado= new ArrayList<>();		
		
			String query="select contact_id, wallet_id, contact_name, acc_number from contactos where wallet_id="+walletId;
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
				
					int id = rsl.getInt("contact_kid");
					int wallet = rsl.getInt("wallet_id");
					String name = rsl.getString("contact_name");
					int acc = rsl.getInt("acc_number");
									
					Contacto  contacto= new Contacto(id, wallet, name, acc);
					listado.add(contacto);
				
			}
			
			return listado;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
		
	}

}
