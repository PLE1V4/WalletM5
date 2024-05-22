package walletm5.transaction.model.dao;

import java.util.List;

import walletm5.transaction.model.entidad.Transaction;

public interface TransactionDao {
	
	boolean guardar(Transaction transaction);
	List<Transaction> getTransactionsByUser(int id);

}
