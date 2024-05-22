package walletm5.wallet.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;


import walletm5.shared.dao.DAO;
import walletm5.wallet.model.dao.WalletDao;
import walletm5.wallet.model.entidad.Wallet;

public class WalletDaoImpl extends DAO implements WalletDao {

	@Override
	public Wallet getWalletByUser(int userId) {
		
		try {
			Wallet wallet = null;
		
		
			String query="select wallet_id, wallet_user_id, wallet_acc_num from wallets where wallet_user_id="+userId;
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
					
				int id = rsl.getInt("wallet_id");
				int user = rsl.getInt("wallet_user_id");
				int account = rsl.getInt("wallet_acc_num");
				
				
				wallet= new Wallet(id,user,account);
				
			}
			
			return wallet;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
		
	}

	@Override
	public Wallet getWalletById(int id) {
		try {
			Wallet wallet = null;
		
		
			String query="select wallet_id, wallet_user_id, wallet_acc_num from wallets where wallet_id="+id;
			
			ResultSet rsl= this.consultar(query);
			
			while(rsl.next()) {
					
				int walletId = rsl.getInt("wallet_id");
				int user = rsl.getInt("wallet_user_id");
				int account = rsl.getInt("wallet_acc_num");
				
				
				wallet= new Wallet(walletId,user,account);
				
			}
			
			return wallet;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	

}
