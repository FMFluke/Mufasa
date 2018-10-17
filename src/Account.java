

public class Account {
	String firstName;
	String lastName;
	String userName;
	String password;
	
	int indexCountry;
	int bDay;
	int bMonth;
	int bYear;
	
	String phoneNumber;
	String email;

	public Account() {
		
	}
	
	private boolean validateName(String input) {
		int i;
		char c;
		for(i=0;i<input.length();i++) {
			c = input.charAt(i);
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'B'))) {
				return false;
			}
		}
		return true;
	}
	
	private boolean validateUserName(String input) {
		int underscore = 0;
		int i;
		char c;
		if(input.length() > 15) return false;
		for(i=0;i<input.length();i++) {
			c = input.charAt(i);
			if (c == '_') underscore++;
			else if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'B'))) {
				return false;
			}
			if (underscore > 1) return false;
		}
		return true;
	}
	
	private boolean attachAccount(String address, String password, String cardHolder, String cardType, int cardNumber, String expireDate) {
		return false;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (validateName(firstName)) {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (validateName(lastName)) {
			this.lastName = lastName;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if (validateUserName(userName)) {
			this.userName = userName;
		}
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() >= 8) {
			this.password = password;
		}
	}
}
