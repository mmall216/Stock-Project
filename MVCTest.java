
public class MVCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User model = retrievesUserFromDatabase();
		
		UserView view = new UserView();
		
		UserController controller = new UserController(model, view);
		
		controller.updateView();

	}
	
	private static User retrievesUserFromDatabase() {
		User user = new User("John Doe", "TestId99", "12345", 1000);
		
		return user;
	}

}
