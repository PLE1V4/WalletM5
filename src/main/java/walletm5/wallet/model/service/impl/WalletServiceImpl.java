package walletm5.wallet.model.service.impl;

import walletm5.wallet.model.dao.WalletDao;
import walletm5.wallet.model.entidad.Wallet;
import walletm5.wallet.model.service.WalletService;

public class WalletServiceImpl implements WalletService {
	
	WalletDao walletDao;
	
	

	public WalletServiceImpl(WalletDao walletDao) {
		this.walletDao = walletDao;
	}

	@Override
	public Wallet getWalletByUser(int userId) {
		return walletDao.getWalletByUser(userId);
	}

	@Override
	public Wallet getWalletById(int id) {
		return walletDao.getWalletById(id);
	}

}
