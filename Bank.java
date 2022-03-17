
public class Bank {
	
	private String id;
	private String password;
	private double balance;
	
	
	public Bank (String id, String password, double balance){
		this.id = id;
		this.password = password;
		this.balance = balance;
	}
	
	public String getbankId() {
		return id;
	}

	public void setName(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
}

