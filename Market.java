
public class Market {

	String stockSymbol;
	double stockShares;
	double stockValue;
	
	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	public Market(String buyingStock, double shareAmount, double stockValue) {
		this.stockSymbol = buyingStock;
		this.stockShares = shareAmount;
		this.stockValue = stockValue;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public double getStockShares() {
		return stockShares;
	}

	public void setStockShares(double stockShares) {
		this.stockShares = stockShares;
	}	
	
}
