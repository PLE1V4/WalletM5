package walletm5.contact.model.entidad;

public class Contacto {
	
	private int contactId;
	private int walletId;
	private String name;
	private int accountNum;
	
	public Contacto() {
	}
	
	public Contacto(int contactId, int walletId, String name, int accountNum) {
		this.contactId = contactId;
		this.walletId = walletId;
		this.name = name;
		this.accountNum = accountNum;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	
	

}
