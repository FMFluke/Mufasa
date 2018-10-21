import static org.junit.Assert.*;

import org.junit.Test;

public class Person {

	@Test
	public void testCreatAccountSuccess() {
		//Arrange
		String name = "Name";
		String lastname = "Lastname";
		String username = "dummyUsername";
		String password = "zxcvasdfqwer";
		int index = 2;
		int bDay = 12, bMonth = 2, bYear = 1977;
		String pNumber = "0990990999";
		String email = "some@mail.com";
		boolean success = true;
		//Act
		try {
			Account acc = new Account(name, lastname, username, password, index, bDay, bMonth, bYear, pNumber, email);
		} catch (InvalidInputException e) {
			success = false;
		}
		//Assert
		assertTrue(success);
	}
	
	@Test
	public void testCreatAccountInvalidName() {
		//Arrange
		String name = "Nam$e";
		String lastname = "Lastname";
		String username = "dummyUsername";
		String password = "zxcvasdfqwer";
		int index = 2;
		int bDay = 12, bMonth = 2, bYear = 1977;
		String pNumber = "0990990999";
		String email = "some@mail.com";
		boolean success = true;
		//Act
		try {
			Account acc = new Account(name, lastname, username, password, index, bDay, bMonth, bYear, pNumber, email);
		} catch (InvalidInputException e) {
			success = false;
		}
		//Assert
		assertFalse(success);
	}
	
	@Test
	public void testCreatAccountInvalidPasswordTooShort() {
		//Arrange
		String name = "Name";
		String lastname = "Lastname";
		String username = "dummyUsername";
		String password = "23";
		int index = 2;
		int bDay = 12, bMonth = 2, bYear = 1977;
		String pNumber = "0990990999";
		String email = "some@mail.com";
		boolean success = true;
		//Act
		try {
			Account acc = new Account(name, lastname, username, password, index, bDay, bMonth, bYear, pNumber, email);
		} catch (InvalidInputException e) {
			success = false;
		}
		//Assert
		assertFalse(success);
	}
	
	@Test
	public void testCreatAccountInvalidUsernameTooLong() {
		//Arrange
		String name = "Name";
		String lastname = "Lastname";
		String username = "dummyuser123456789";
		String password = "23sdsdsdsd";
		int index = 2;
		int bDay = 12, bMonth = 2, bYear = 1977;
		String pNumber = "0990990999";
		String email = "some@mail.com";
		boolean success = true;
		//Act
		try {
			Account acc = new Account(name, lastname, username, password, index, bDay, bMonth, bYear, pNumber, email);
		} catch (InvalidInputException e) {
			success = false;
		}
		//Assert
		assertFalse(success);
	}
	
	@Test
	public void testCreatAccountInvalidCountry() {
		//Arrange
		String name = "Name";
		String lastname = "Lastname";
		String username = "dummyuser123456789";
		String password = "23sdsdsdsd";
		int index = -1;
		int bDay = 12, bMonth = 2, bYear = 1977;
		String pNumber = "0990990999";
		String email = "some@mail.com";
		boolean success = true;
		//Act
		try {
			Account acc = new Account(name, lastname, username, password, index, bDay, bMonth, bYear, pNumber, email);
		} catch (InvalidInputException e) {
			success = false;
		}
		//Assert
		assertFalse(success);
	}

}
