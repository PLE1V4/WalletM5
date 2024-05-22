package walletm5.transaction.model.service;

import java.util.List;

import walletm5.transaction.model.entidad.Transaction;

public interface TransactionService {
	
	boolean guardar(Transaction transaction);
	List<Transaction> getTransactionsByUser(int id);

}
