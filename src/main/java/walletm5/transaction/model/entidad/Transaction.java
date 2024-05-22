package walletm5.transaction.model.entidad;

import java.sql.Date;

public class Transaction {
	
	private int transactionNumber;
	private int sernderId;
	private int receiverId;
	private double amount;
	private Date fecha;
	private int tipo;
	
	public Transaction() {
	}

	public Transaction(int transactionNumber, int sernderId, int receiverId, double amount, Date fecha, int tipo) {
		this.transactionNumber = transactionNumber;
		this.sernderId = sernderId;
		this.receiverId = receiverId;
		this.amount = amount;
		this.fecha = fecha;
		this.tipo = tipo;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public int getSernderId() {
		return sernderId;
	}

	public void setSernderId(int sernderId) {
		this.sernderId = sernderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	

}
