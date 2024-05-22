package walletm5.wallet.model.dao;

import walletm5.wallet.model.entidad.Wallet;

public interface WalletDao {
	
	Wallet getWalletByUser(int userId);
	Wallet getWalletById (int id);
	

}
