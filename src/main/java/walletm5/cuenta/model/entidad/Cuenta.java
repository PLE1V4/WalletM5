package walletm5.cuenta.model.entidad;

public class Cuenta {
	
	private int numeroCuenta;
	private double saldo;
	private int id_moneda;
	
	public Cuenta() {
	}

	public Cuenta(int numeroCuenta, double saldo, int id_moneda) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.id_moneda = id_moneda;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(int id_moneda) {
		this.id_moneda = id_moneda;
	}
	
	

}
