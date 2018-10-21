
public interface BankSystem {
	public boolean deduct(BankCard card, double amount);
	public boolean refund(BankCard card, double amount);
}
