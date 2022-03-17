import java.util.ArrayList;
import java.util.Scanner;

public class User {

		String userName;
		String userId;
		String userPassword;
		double userFunds;
		
		User(String userName, String userId, String userPassword, double userFunds){
			this.userName = userName;
			this.userId = userId;
			this.userPassword = userPassword;
			this.userFunds = userFunds;	
		}	

		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}

		/**
		 * @param userId the userId to set
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
		 * @param userPassword the userPassword to set
		 */
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

		/**
		 * @param userFunds the userFunds to set
		 */
		public void setUserFunds(double userFunds) {
			this.userFunds = userFunds;
		}

		public String getName() {
			return userName;
		}
		
		public String getId() {
			return userId;
		}
		
		public String getPassword() {
			return userPassword;
		}
		
		public double getFunds() {
			return userFunds;
		}
		
		public void setFunds(double userFunds) {
			this.userFunds = userFunds;
		}
		
		ArrayList <Market> accList = new ArrayList<Market>();
		ArrayList <Bank> bankList = new ArrayList <Bank>();
		Scanner userInput = new Scanner(System.in);
		
	public void createBankAcc(){		
		String bankAccNum = null;
		String bankAccPassword = null;
		double bankAccBalance = 0;
		
		System.out.println("Add Your Personal Bank Information: ");
		System.out.println("Enter your Bank Account Number: ");
		if (userInput.hasNext()) {
			bankAccNum = userInput.next();
		}
		System.out.println("Enter your Bank Account Password: ");
		if (userInput.hasNext()) {
			bankAccPassword = userInput.next();
		}
		System.out.println("Enter your Bank Account Balance: ");
		if (userInput.hasNextDouble()) {
			bankAccBalance = userInput.nextDouble();
		}
		
		Bank createdBankAcc = new Bank (bankAccNum, bankAccPassword, bankAccBalance);
		bankList.add(createdBankAcc);
	}
		
	public void loadBankAcc() {
		Bank preloadedBankAcc0 = new Bank ("testbankid0", "testpassword0", 31000);
		Bank preloadedBankAcc1 = new Bank ("testbankid1", "testpassword1", 22000);
		Bank preloadedBankAcc2 = new Bank ("testbankid2", "testpassword2", 30400);
		Bank preloadedBankAcc3 = new Bank ("testbankid3", "testpassword3", 40070);	
		Bank preloadedBankAcc4 = new Bank ("testbankid4", "testpassword4", 500);
		Bank preloadedBankAcc5 = new Bank ("testbankid5", "testpassword5", 600);
		Bank preloadedBankAcc6 = new Bank ("testbankid6", "testpassword6", 8000);
		Bank preloadedBankAcc7 = new Bank ("testbankid7", "testpassword7", 800);
		Bank preloadedBankAcc8 = new Bank ("testbankid8", "testpassword8", 900);
		Bank preloadedBankAcc9 = new Bank ("testbankid9", "testpassword9", 100900);
		Bank preloadedBankAcc10 = new Bank ("testbankid10", "testpassword10", 191000);
		Bank preloadedBankAcc11 = new Bank ("testbankid11", "testpassword11", 2000);
		Bank preloadedBankAcc12 = new Bank ("testbankid12", "testpassword12", 31700);
		Bank preloadedBankAcc13 = new Bank ("testbankid13", "testpassword13", 41007);
		Bank preloadedBankAcc14 = new Bank ("testbankid14", "testpassword14", 5107);
		Bank preloadedBankAcc15 = new Bank ("testbankid15", "testpassword15", 61070);
		Bank preloadedBankAcc16 = new Bank ("testbankid16", "testpassword16", 7100);
		Bank preloadedBankAcc17 = new Bank ("testbankid17", "testpassword17", 8000);
		Bank preloadedBankAcc18 = new Bank ("testbankid18", "testpassword18", 9000);
		Bank preloadedBankAcc19 = new Bank ("testbankid19", "testpassword19", 1700);
		Bank preloadedBankAcc20 = new Bank ("testbankid20", "testpassword20", 6070);
		Bank preloadedBankAcc21 = new Bank ("testbankid21", "testpassword21", 426800);
		Bank preloadedBankAcc22 = new Bank ("testbankid22", "testpassword22", 3213800);
		Bank preloadedBankAcc23 = new Bank ("testbankid23", "testpassword23", 12308);
		Bank preloadedBankAcc24 = new Bank ("testbankid24", "testpassword24", 142080);
		
		bankList.add(preloadedBankAcc0);
		bankList.add(preloadedBankAcc1);
		bankList.add(preloadedBankAcc2);
		bankList.add(preloadedBankAcc3);
		bankList.add(preloadedBankAcc4);
		bankList.add(preloadedBankAcc5);
		bankList.add(preloadedBankAcc6);
		bankList.add(preloadedBankAcc7);
		bankList.add(preloadedBankAcc8);
		bankList.add(preloadedBankAcc9);
		bankList.add(preloadedBankAcc10);
		bankList.add(preloadedBankAcc11);
		bankList.add(preloadedBankAcc12);
		bankList.add(preloadedBankAcc13);
		bankList.add(preloadedBankAcc14);
		bankList.add(preloadedBankAcc15);
		bankList.add(preloadedBankAcc16);
		bankList.add(preloadedBankAcc17);
		bankList.add(preloadedBankAcc18);
		bankList.add(preloadedBankAcc19);
		bankList.add(preloadedBankAcc20);
		bankList.add(preloadedBankAcc21);
		bankList.add(preloadedBankAcc22);
		bankList.add(preloadedBankAcc23);
		bankList.add(preloadedBankAcc24);	
	}
			
	public void displayBankAcc(int i) {
		System.out.println(" ");
		System.out.println("Bank Account Id: " + bankList.get(i).getbankId());
		System.out.println("Account Balance: " + bankList.get(i).getBalance());
	}
	
	public double transferFunds() {
		int user = -1;
		int beta = -1;
		
		if (user == -1) {
			System.out.println("Logging into Bank Account...");
			System.out.println("Please Enter Your Bank Account ID: ");
			String bankId = null;
			String bankPassword = null;
			
			bankId = userInput.next();
			System.out.println("Enter Your Bank Password");
			bankPassword = userInput.next();	
			
			for(int i=0; i<bankList.size();i++) {
				if (bankList.get(i).getbankId().equals(bankId) && bankList.get(i).getPassword().equals(bankPassword)){
				displayBankAcc(i);
				user = i;
				beta = i;
				}
		}
		
			if (beta == -1) {
				System.out.println("Account Does Not Exist. Please create an account ");
				createBankAcc();
				return 0;
			}
			
		}
		
		System.out.println("Please Enter the Amount of Funds You Would Like To Transfer Over to the App: ");
		if (userInput.hasNextDouble()) {
			double funds = userInput.nextDouble();
			double personalBalance = bankList.get(user).getBalance();
			if (funds <= personalBalance) {
				bankList.get(user).setBalance(personalBalance - funds);
				System.out.println("Updated Balance: ");
				displayBankAcc(user);
				return funds;
			}
			else {
				System.out.println("Insuffcient Funds!");
			}
			
		} return 0;
	} 
		
			
	
		
		public void buyStock (String stockSymbol, double stockShares, double stockValue) {	
			Market userAccount = new Market(stockSymbol, stockShares, stockValue);
			accList.add(userAccount);
		}
		
		public void displaypersonalStocks(){		
			for (int i=0; i<accList.size(); i++) {
				System.out.println("Stock Number: " + i);
				System.out.println("Stock Symbol: " + accList.get(i).getStockSymbol());
				System.out.println("Shares: " + accList.get(i).getStockShares());	
				System.out.println("Value: " + accList.get(i).getStockValue());
				System.out.println(" ");
				
			}
		}
		
		
	//where the user will sell the stock	
		public void sellStock (int i) {
			accList.remove(i);
		}
	}