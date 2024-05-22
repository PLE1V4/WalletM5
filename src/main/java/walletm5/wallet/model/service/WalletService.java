package walletm5.wallet.model.service;

import walletm5.wallet.model.entidad.Wallet;

public interface WalletService {
	
	Wallet getWalletByUser(int userId);
	Wallet getWalletById (int id);

}
