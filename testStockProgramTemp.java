import java.util.ArrayList;
import java.util.Scanner;


public class testStockProgramTemp {
	
	// these are global arraylists which can be accessed anywhere
	public static ArrayList<Stock> Stocks = new ArrayList<Stock>();
	public static ArrayList<User> person = new ArrayList<User>();
	
	static Scanner userInput = new Scanner(System.in);
	
	public static void printStock() {
		System.out.printf( "%-10s %25s %23s %20s %n", "Symbol", "Stock Name", "Stock Price", "Stock Number");
		System.out.println(" ");
	
		for (int i = 0; i<Stocks.size();i++) {
		System.out.printf( "%-15s %25s %15s %20s %n", Stocks.get(i).getstockSymbol(), Stocks.get(i).getstockName(), Stocks.get(i).getstockPrice(), i);
		}
		System.out.println(" ");
	}
	
	public static void printPersonInfo(int i) {
		System.out.println(" ");	
		System.out.println("Name: " + person.get(i).getName());
		System.out.println("ID: " + person.get(i).getId());
		System.out.println("Funds: " + person.get(i).getFunds());	
	}
	
	public static void createAccount () {	
		String firstName = null;
		String lastName = null;
		String Id = null;
		String Password = null;
		double Funds = 0;
		
		System.out.println(" ");
		System.out.println("Creating Account...");
		
		System.out.println("Enter Your First Name: ");
		if (userInput.hasNext()) {
			firstName = userInput.next();
		}
		System.out.println("Enter Your Last Name: ");
		if (userInput.hasNext()) {
			lastName = userInput.next();
		}
		System.out.println("Enter Your userId: ");
		if (userInput.hasNext()) {
			Id = userInput.next();	
		}
		System.out.println("Enter Your Password: ");
		if (userInput.hasNext()) {
			Password = userInput.next();
		}
		System.out.println("Enter The Amount of Funds You Want in Account: ");
		if (userInput.hasNextDouble()) {
			Funds = userInput.nextDouble();
		}
			
		String fullName = firstName + " " + lastName;		
		User newUser = new User(fullName, Id, Password, Funds);
		person.add(newUser);
		
	}	
	
	public static int login() {
		int account = -1;
		System.out.println("Please type in your login ID: ");
		String loginAccount = userInput.next();
		System.out.println("Please type in your password: ");
		String loginPassword = userInput.next();
		
		for (int i=0; i<person.size();i++) {
			if (person.get(i).getId().equals(loginAccount) && person.get(i).getPassword().equals(loginPassword)) {
				printPersonInfo(i);
				account =i;
				return i;		
			}	
		} 
		System.out.println("Account Does Not Exist. Please Create An Account! ");
		return -1;
	}
	
	public static void start() {
		int choice = 0;
		int test = 0;
		person.get(test).loadBankAcc();
		do {
			System.out.println("Hello, Welcome to BuyNSellStocks! Please login or create an account if you do not have one.");
			System.out.println("Login - 1");
			System.out.println("Create an Account - 2");
			System.out.println("Close - 3");
			
			System.out.println("Enter your choice: ");
			choice = userInput.nextInt();
			
			
			switch(choice) {
			//logging in
			case 1: 	
				int userChoice = 0;
				System.out.println("Logging in...");
				int account = login();
				if (account == -1) {
					break;
				}
				System.out.println(" ");
				
				do {
					System.out.println(" ");
					System.out.println("Welcome " + person.get(account).getName() + "! Please Select what you what like to do");
					System.out.println("View Account Information - 1");
					System.out.println("Transfer Funds - 2");
					System.out.println("Buy Stocks - 3");
					System.out.println("Sell Stocks - 4");
					System.out.println("Logout - 5");
					userChoice=userInput.nextInt();
					
					switch(userChoice) {	
						
					case 1:
						printPersonInfo(account);
						System.out.println(" ");
						person.get(account).displaypersonalStocks();
						break;
					
					case 2:
						//transfer funds to account
						double fundsAdded = person.get(account).transferFunds();
						double initialFunds = person.get(account).getFunds();
						person.get(account).setFunds(initialFunds + fundsAdded);
						printPersonInfo(account);						
						break;
						
					case 3:
						printStock();
						
						System.out.println("Enter the stock (Number) you want to buy from the list above.");
						int buyingStock = userInput.nextInt();
						
						double price = Stocks.get(buyingStock).getstockPrice();
						
						System.out.println("Enter the amount of shares you want to buy of that stock.");
						double shareAmount = userInput.nextDouble();
						
						double stockTotal = shareAmount * price;
						
						if (stockTotal <= person.get(account).getFunds()) {
							System.out.println("Purchasing... " + shareAmount + " Shares at " + price + " for a total of " + stockTotal);
								for (int i=0; i < person.get(account).accList.size(); i++) {
									if (Stocks.get(buyingStock).getstockSymbol().equals(person.get(account).accList.get(i).getStockSymbol()));{
										person.get(account).accList.get(i).setStockShares(person.get(account).accList.get(i).getStockShares() + shareAmount);
										person.get(account).accList.get(i).setStockValue(person.get(account).accList.get(i).getStockValue() + stockTotal);
										break;
									}
								}
								
								person.get(account).buyStock(Stocks.get(buyingStock).getstockSymbol(), shareAmount, stockTotal);
								double personalFundsTotal = person.get(account).getFunds();
								person.get(account).setFunds(personalFundsTotal-stockTotal);
								printPersonInfo(account);
								break;
					}
						else {
							System.out.println("Insufficient Funds");
						}
							break;
					
					
					case 4:
						
						person.get(account).displaypersonalStocks();
						
						System.out.println("Enter the stock number you want to sell");
						int sellingStock = userInput.nextInt();
						double sellingShares;
						double sellValuePerShare;
						
							System.out.println("How many shares do you want to sell?");	
							sellingShares = userInput.nextDouble();
							
							sellValuePerShare = person.get(account).accList.get(sellingStock).getStockValue()/person.get(account).accList.get(sellingStock).getStockShares();
							
								if (sellingShares< person.get(account).accList.get(sellingStock).getStockShares()) {
									
									person.get(account).accList.get(sellingStock).setStockShares(person.get(account).accList.get(sellingStock).getStockShares() - sellingShares);
									person.get(account).accList.get(sellingStock).setStockValue(person.get(account).accList.get(sellingStock).getStockValue() - (sellValuePerShare*sellingShares));
									person.get(account).setFunds(person.get(account).getFunds() + (sellValuePerShare*sellingShares));
									break;
								}
								if (sellingShares == person.get(account).accList.get(sellingStock).getStockShares()) {
									person.get(account).sellStock(sellingStock);
									person.get(account).setFunds(person.get(account).getFunds() + (sellValuePerShare*sellingShares));
									break;
								}
								else {
									System.out.println("You do not own any shares of this stock.");
									break;
								}								
								
					case 5:
						break;
					}
					
				} while (userChoice !=5);

			break;
			
			//creating account
			case 2:
				createAccount();	
			break;
			}	
		}while (choice != 3);
	}
		
	 
	public static void main(String args[]) {

//Preloaded Users	
		User preloadedUser0 = new User ("David Hoffner", "testid0", "testpassword0", 1000);
		User preloadedUser1 = new User ("Andrew Hoffner", "testid1", "testpassword1", 2000);
		User preloadedUser2 = new User ("Terron Davis", "testid2", "testpassword2", 3000);
		User preloadedUser3 = new User ("Zeth Anthony", "testid3", "testpassword3", 4000);	
		User preloadedUser4 = new User ("Matthew Haag", "testid4", "testpassword4", 5000);
		User preloadedUser5 = new User ("Marty Williams", "testid5", "testpassword5", 6000);
		User preloadedUser6 = new User ("Hector Rodriguez", "testid6", "testpassword6", 7000);
//same name is done intentionally because some people may have the same full name but not the same person.
		User preloadedUser7 = new User ("Michael Mallh", "testid7", "testpassword7", 8000);
		User preloadedUser8 = new User ("Michael Mallh", "testid8", "testpassword8", 9000);
		User preloadedUser9 = new User ("Christopher Fitzpatrik", "testid9", "testpassword9", 10000);
		User preloadedUser10 = new User ("Daniel Wallas", "testid10", "testpassword10", 11000);
		User preloadedUser11 = new User ("Seth Abner", "testid11", "testpassword11", 21000);
		User preloadedUser12 = new User ("Matthew Piper", "testid12", "testpassword12", 31000);
		User preloadedUser13 = new User ("Ian Porter", "testid13", "testpassword13", 41000);
		User preloadedUser14 = new User ("Damon Barlow", "testid14", "testpassword14", 51000);
		User preloadedUser15 = new User ("James Harden", "testid15", "testpassword15", 61000);
		User preloadedUser16 = new User ("Lebron James", "testid16", "testpassword16", 71000);
		User preloadedUser17 = new User ("Michael Jordan", "testid17", "testpassword17", 81000);
		User preloadedUser18 = new User ("Anthony Joshua", "testid18", "testpassword18", 91000);
		User preloadedUser19 = new User ("Floyd Mayweather", "testid19", "testpassword19", 100);
		User preloadedUser20 = new User ("John Soriano", "testid20", "testpassword20", 600);
		User preloadedUser21 = new User ("Bandna Badhan", "testid21", "testpassword21", 426000);
		User preloadedUser22 = new User ("Leslie Altimarano", "testid22", "testpassword22", 321300);
		User preloadedUser23 = new User ("Hitch Davis", "testid23", "testpassword23", 1230);
		User preloadedUser24 = new User ("Kevin Hart", "testid24", "testpassword24", 14200);
		
//Inputing user objects into arraylist of user.
		person.add(preloadedUser0);
		person.add(preloadedUser1);
		person.add(preloadedUser2);
		person.add(preloadedUser3);
		person.add(preloadedUser4);
		person.add(preloadedUser5);
		person.add(preloadedUser6);
		person.add(preloadedUser7);
		person.add(preloadedUser8);
		person.add(preloadedUser9);
		person.add(preloadedUser10);
		person.add(preloadedUser11);
		person.add(preloadedUser12);
		person.add(preloadedUser13);
		person.add(preloadedUser14);
		person.add(preloadedUser15);
		person.add(preloadedUser16);
		person.add(preloadedUser17);
		person.add(preloadedUser18);
		person.add(preloadedUser19);
		person.add(preloadedUser20);
		person.add(preloadedUser21);
		person.add(preloadedUser22);
		person.add(preloadedUser23);
		person.add(preloadedUser24);
		
		//Preloaded Stocks that people can buy.	
		Stock VNET = new Stock ("21Vlanet Group Inc. ADR", "VNET", 10);
		Stock AKAM = new Stock ("Akamai Technologies Inc.", "AKAM", 20);
		Stock BIDU = new Stock ("Vaidu Inc. ADR", "BIDU", 30);
		Stock XOM = new Stock ("ExxonMobil", "XOM", 40);
		Stock INTC = new Stock ("Intel", "INTC", 50);
		Stock TWX = new Stock ("Time Warner Cable", "TWX", 60);
		Stock BRK = new Stock ("Berksire Hathaway", "BRK-B", 70);
		Stock C = new Stock ("Citigroup", "C", 80);
		Stock FB = new Stock ("Facebook", "FB", 90);
		Stock ORCL = new Stock ("Oracle", "ORCL", 100);
		Stock BAC = new Stock ("Bank of America", "BAC", 110);
		Stock GOOG = new Stock ("Alphabet Inc.", "GOOG", 120);
		Stock HD = new Stock ("Home Depot", "HD", 130);
		Stock PFE = new Stock ("Pfizer", "PFE", 140);
		Stock APPL = new Stock ("Apple", "APPL", 150);
		Stock JPM = new Stock ("JPMorgan Chase", "JPM", 160);
		Stock AMZN = new Stock ("Amazon", "AMZN", 170);
		Stock T = new Stock ("AT&T", "T", 180);
		Stock WMT = new Stock ("Walmart", "WMT", 190);
		Stock WFC = new Stock ("Wells Fargo", "WFC", 200);
		Stock CHL = new Stock ("China Mobile", "CHL", 210);
		Stock TSLA = new Stock ("Tesla", "TSLA", 220);
		Stock FZRO = new Stock ("FlashZero Corp.", "FZRO", 230);
		Stock SINA = new Stock ("Sina Corp.", "SINA", 240);
		Stock TMMI = new Stock ("TMM Inc.", "TMMI", 250);
		Stock XNET = new Stock ("Xunlei Ltd. ADR", "XNET", 260);
		Stock YAHOY = new Stock ("Yahoo Japan Corp. ADR", "YAHOY", 270);
		Stock YIPI = new Stock ("Yippy Inc.", "YIPI", 280);
		
		Stocks.add((VNET));
		Stocks.add((AKAM));
		Stocks.add((BIDU));
		Stocks.add((XOM));
		Stocks.add((INTC));
		Stocks.add((TWX));
		Stocks.add((BRK));
		Stocks.add((C));
		Stocks.add((FB));
		Stocks.add((ORCL));
		Stocks.add((BAC));
		Stocks.add((GOOG));
		Stocks.add((HD));
		Stocks.add((PFE));
		Stocks.add((APPL));
		Stocks.add((JPM));
		Stocks.add((AMZN));
		Stocks.add((T));
		Stocks.add((WMT));
		Stocks.add((WFC));
		Stocks.add((CHL));
		Stocks.add((TSLA));
		Stocks.add((FZRO));
		Stocks.add((SINA));
		Stocks.add((TMMI));
		Stocks.add((XNET));
		Stocks.add((YAHOY));
		Stocks.add((YIPI));	
		
		start();
		
		//System.out.println("Enter a new user to add");
		//createAccount();
		//printPersonInfo();
		
		//printStock();
	
		
		//person.get(1).buyStock();
		//person.get(1).buyStock();
		//person.get(1).displaypersonalStocks();
			
		
		
	}
}