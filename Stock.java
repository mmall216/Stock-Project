
public class Stock{
			String stockName;
			String stockSymbol;
			double stockPrice;
			    
			 Stock(String stockName, String stockSymbol, double stockPrice){
				this.stockName = stockName;
				this.stockSymbol = stockSymbol;
				this.stockPrice = stockPrice;
			}

			    public String getstockName() {
					return stockName;
				}
				
				public String getstockSymbol() {
					return stockSymbol;
				}
				
				public double getstockPrice() {
					return stockPrice;
				}

			
			public void setstockName(String stockName) {
				this.stockName = stockName;
			}
			
			public void setstockSymbol(String stockSymbol) {
				this.stockSymbol = stockSymbol;
			}
			public void setstockPrice(double stockPrice) {
				this.stockPrice = stockPrice;
			}
}
		
	