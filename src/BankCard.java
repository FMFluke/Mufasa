
public class BankCard {
	String cardName;
	String cardNumber;
	int indexCardType;
	int expMonth;
	int expYear;
	String cvv;
	
	public BankCard(String cardName, String cardNumber, int indexCardType, int expMonth, int expYear, String cvv) {
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.indexCardType = indexCardType;
		this.expYear = expYear;
		this.expMonth = expMonth;
		this.cvv = cvv;
	}
	
}
