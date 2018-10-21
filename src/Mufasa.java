
public class Mufasa {
	BankSystem bank;
	
	private boolean tryDeduct(BankCard card, double amount) {
		return this.bank.deduct(card, amount);
	}
	
	private boolean tryRefund(BankCard card, double amount) {
		return this.bank.refund(card, amount);
	}
	
	public BankCard tryCreateCard(String cardName, String cardNumber, int indexCardType, int expMonth, int expYear, String cvv) {
		//validate card information here
		//skip for now
		BankCard card = new BankCard(cardName, cardNumber, indexCardType, expMonth, expYear, cvv);
		
		return card;
	}
	
	public boolean tryAttachBankAccount(Account acc, String address, String secPassword, BankCard card) {
		if ((!tryDeduct(card, 0.01)) || (!tryRefund(card, 0.01))) {
			return false;
		}
		try {
			acc.attachAccount(address, secPassword, card);
		} catch (InvalidInputException e) {
			return false;
		}
		return true;
	}

	public BankSystem getBank() {
		return bank;
	}

	public void setBank(BankSystem bank) {
		this.bank = bank;
	}
	
	
}
