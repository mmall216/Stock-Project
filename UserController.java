
public class UserController {
	private User model;
	private UserView view;
	
	public UserController(User model, UserView view) {
		this.model = model;
		this.view = view;
	}
	
	public String getUserName() {
		 return model.getName();
	}
	
	public String getUserId() {
		return model.getId();
	}
	
	public String getUserPassword() {
		return model.getPassword();
	}
	
	public void setUsername(String name) {
		 model.setUserName(name);
	}
	
	public void setUserId(String userId) {
		model.setUserId(userId);
	}
	
	public void setUserPassword(String userPassword) {
		model.setUserPassword(userPassword);
	}
	
	public double getUserFunds() {
		return model.getFunds();
	}
	
	public void setUserFunds(double userFunds) {
		model.setFunds(userFunds);
	}
	
	public void updateView() {
		view.printUserDetails(model.getName(), model.getId(), model.getPassword(), model.getFunds());
	}
	
}