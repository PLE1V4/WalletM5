package walletm5.transaction.model.service.impl;

import java.util.List;

import walletm5.transaction.model.dao.TransactionDao;
import walletm5.transaction.model.entidad.Transaction;
import walletm5.transaction.model.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
	
	TransactionDao transactionDao;

	public TransactionServiceImpl(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Override
	public boolean guardar(Transaction transaction) {
		return transactionDao.guardar(transaction);
	}

	@Override
	public List<Transaction> getTransactionsByUser(int id) {
		return transactionDao.getTransactionsByUser(id);
	}

}
