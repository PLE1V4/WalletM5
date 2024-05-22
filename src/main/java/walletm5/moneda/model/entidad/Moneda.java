package walletm5.moneda.model.entidad;

public class Moneda {
	
	private int currency_id;
	private String currency_name;
	private String currency_symbol;
	private double exchange_rate;
	
	public Moneda() {
	}

	public Moneda(int currency_id, String currency_name, String currency_symbol, double exchange_rate) {
		this.currency_id = currency_id;
		this.currency_name = currency_name;
		this.currency_symbol = currency_symbol;
		this.exchange_rate = exchange_rate;
	}

	public int getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(int currency_id) {
		this.currency_id = currency_id;
	}

	public String getCurrency_name() {
		return currency_name;
	}

	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}

	public String getCurrency_symbol() {
		return currency_symbol;
	}

	public void setCurrency_symbol(String currency_symbol) {
		this.currency_symbol = currency_symbol;
	}

	public double getExchange_rate() {
		return exchange_rate;
	}

	public void setExchange_rate(double exchange_rate) {
		this.exchange_rate = exchange_rate;
	}
	
	

}
