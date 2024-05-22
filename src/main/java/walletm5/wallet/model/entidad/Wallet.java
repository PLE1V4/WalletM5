package walletm5.wallet.model.entidad;

public class Wallet {
	
	private int idWallet;
	private int userId;
	private int accNumber;
	
	public Wallet() {
	}

	public Wallet(int idWallet, int userId, int accNumber) {
		this.idWallet = idWallet;
		this.userId = userId;
		this.accNumber = accNumber;
	}

	public int getIdWallet() {
		return idWallet;
	}

	public void setIdWallet(int idWallet) {
		this.idWallet = idWallet;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	
	
}
