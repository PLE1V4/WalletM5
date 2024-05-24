package walletm5.transaction.model.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import walletm5.shared.dao.DAO;
import walletm5.transaction.model.dao.TransactionDao;
import walletm5.transaction.model.entidad.Transaction;

public class TransactionDaoImpl extends DAO implements TransactionDao {

	@Override
	public boolean guardar(Transaction transaction) {
		
		int sender = transaction.getSernderId();
		int receiver = transaction.getReceiverId();
		double amount = transaction.getAmount();
		int tipo = transaction.getTipo();
		
		String query="insert into transactions (sender_id,receiver_id,amount,fecha_ts,ts_type)";
		query+=" values("+sender+","+receiver+","+amount+",curdate(),"+tipo+")";
		
		int registrosAfectados=ejecutarSql(query);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public List<Transaction> getTransactionsByUser(int id) {
		try {
			List<Transaction> listado= new ArrayList<>();
		
		
			String query="select ts_number, sender_id, receiver_id, amount, fecha_ts, ts_type from transactions where sender_id="+id;
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
				
					int num = rsl.getInt("ts_number");
					int sender = rsl.getInt("sender_id");
					int receiver = rsl.getInt("receiver_id");
					double amount = rsl.getDouble("amount");
					Date fecha = rsl.getDate("fecha_ts");
					int tipo = rsl.getInt("ts_type");
									
					Transaction  ts= new Transaction(num, sender, receiver, amount, fecha, tipo);
					listado.add(ts);
				
			}
			
			return listado;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
