import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;

public class MufasaTest {
	Mufasa mufasaSystem;
	BankSystem bank;
	Account acc;
	//BankCard card;
	
	@Before
	public void setup() throws InvalidInputException {
		mufasaSystem = new Mufasa();
		//set system
		bank = EasyMock.createMock(BankSystem.class);
		mufasaSystem.setBank(bank);
		//create a valid test account
		acc = new Account("Name", "Surname", "username", "password1", 0, 12, 10, 1990, "0222222222", "some@mail.fi");
	}
	
	@Test
	public void testAttachBankAccountSuccess() {
		//Arrange
		BankCard card = mufasaSystem.tryCreateCard("Name", "54213131999999999", 1, 11, 18, "888");
		
		//Mock set expectations
		EasyMock.expect(bank.deduct(card, 0.01)).andReturn(true);
		EasyMock.expect(bank.refund(card, 0.01)).andReturn(true);
		EasyMock.replay(bank);
		//Act
		boolean result = mufasaSystem.tryAttachBankAccount(acc, "Yliopistokatu 3 9 Oulu Finland 99999", "password2", card);
		//Assert
		assertTrue(result);
	}
	
	@Test
	public void testAttachBankAccountDeductFail() {
		//Arrange
		BankCard card = mufasaSystem.tryCreateCard("Name", "54213131999999999", 1, 11, 18, "888");
		
		//Mock set expectations
		EasyMock.expect(bank.deduct(card, 0.01)).andReturn(false);
		EasyMock.expect(bank.refund(card, 0.01)).andReturn(true);
		EasyMock.replay(bank);
		//Act
		boolean result = mufasaSystem.tryAttachBankAccount(acc, "Yliopistokatu 3 9 Oulu Finland 99999", "password2", card);
		//Assert
		assertFalse(result);
	}
	
	@Test
	public void testAttachBankAccountRefundFail() {
		//Arrange
		BankCard card = mufasaSystem.tryCreateCard("Name", "54213131999999999", 1, 11, 18, "888");
		
		//Mock set expectations
		EasyMock.expect(bank.deduct(card, 0.01)).andReturn(true);
		EasyMock.expect(bank.refund(card, 0.01)).andReturn(false);
		EasyMock.replay(bank);
		//Act
		boolean result = mufasaSystem.tryAttachBankAccount(acc, "Yliopistokatu 3 9 Oulu Finland 99999", "password2", card);
		//Assert
		assertFalse(result);
	}
	
	@Test
	public void testAttachBankAccountAllFail() {
		//Arrange
		BankCard card = mufasaSystem.tryCreateCard("Name", "54213131999999999", 1, 11, 18, "888");
		
		//Mock set expectations
		EasyMock.expect(bank.deduct(card, 0.01)).andReturn(false);
		EasyMock.expect(bank.refund(card, 0.01)).andReturn(false);
		EasyMock.replay(bank);
		//Act
		boolean result = mufasaSystem.tryAttachBankAccount(acc, "Yliopistokatu 3 9 Oulu Finland 99999", "password2", card);
		//Assert
		assertFalse(result);
	}
}
