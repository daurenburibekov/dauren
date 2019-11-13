
public class LoyalUser extends PrimeUser {

	private double cashback;
	public LoyalUser(int id, String name, String surname, int balance, String status, double cashback) {
		super(id, name, surname, balance, status);
		// TODO Auto-generated constructor stub
		this.cashback=cashback;
	}
	public double getCashback() {
		return cashback;
	}
	public void setCashback(double cashback) {
		this.cashback = cashback;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" cashback: "+cashback;
	}

}
