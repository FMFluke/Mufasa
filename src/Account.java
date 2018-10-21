

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
	String address;
	
	String secondPassword;
	BankCard card;
	
	static String[] country = {"USA", "UK", "Finland", "Canada", "Singapore"}; //just example

	public Account(String firstName, String lastName, String userName, String password, int indexCountry, int bDay, int bMonth, int bYear, String phoneNumber, String email) throws InvalidInputException {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUserName(userName);
		this.setPassword(password);
		this.setIndexCountry(indexCountry);
		this.setbDay(bDay);
		this.setbMonth(bMonth);
		this.setbYear(bYear);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}
	
	private boolean validateName(String input) {
		int i;
		char c;
		for(i=0;i<input.length();i++) {
			c = input.charAt(i);
			if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
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
			else if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
				return false;
			}
			if (underscore > 1) return false;
		}
		return true;
	}
	
	public void attachAccount(String address, String secondPassword, BankCard card) throws InvalidInputException {
		this.setSecondPassword(secondPassword);
		this.setAddress(address);
		this.setCard(card);		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws InvalidInputException{
		if (validateName(firstName)) {
			this.firstName = firstName;
		}
		else {
			throw new InvalidInputException();
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws InvalidInputException{
		if (validateName(lastName)) {
			this.lastName = lastName;
		}
		else {
			throw new InvalidInputException();
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) throws InvalidInputException {
		if (validateUserName(userName)) {
			this.userName = userName;
		}
		else {
			throw new InvalidInputException();
		}
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws InvalidInputException {
		if (password.length() >= 8) {
			this.password = password;
		}
		else {
			throw new InvalidInputException();
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BankCard getCard() {
		return card;
	}

	public void setCard(BankCard card) {
		this.card = card;
	}

	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) throws InvalidInputException {
		if (secondPassword.length() >= 8 && secondPassword != this.password) {
			this.secondPassword = secondPassword;
		}
		else {
			throw new InvalidInputException();
		}
	}

	public int getIndexCountry() {
		return indexCountry;
	}

	public void setIndexCountry(int indexCountry) throws InvalidInputException {
		if(indexCountry >= 0 && indexCountry < country.length) {
			this.indexCountry = indexCountry;

		}
		else {
			throw new InvalidInputException();
		}
	}

	public int getbDay() {
		return bDay;
	}

	public void setbDay(int bDay) {
		this.bDay = bDay;
	}

	public int getbMonth() {
		return bMonth;
	}

	public void setbMonth(int bMonth) {
		this.bMonth = bMonth;
	}

	public int getbYear() {
		return bYear;
	}

	public void setbYear(int bYear) {
		this.bYear = bYear;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
