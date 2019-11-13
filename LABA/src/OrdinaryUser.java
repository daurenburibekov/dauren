
public class OrdinaryUser extends User implements Comparable<OrdinaryUser>{
	private int balance;
	public OrdinaryUser(int id, String name, String surname, int balance) {
		super(id, name, surname);
		this.balance=balance;
		// TODO Auto-generated constructor stub
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int compareTo(OrdinaryUser user) {
		// TODO Auto-generated method stub
		return this.balance-user.balance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User details: id: "+getId()+" name: "+getName()+" surname: "+getSurname()+" balance: "+balance;
	}

}
