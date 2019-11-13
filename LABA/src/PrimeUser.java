
public class PrimeUser extends OrdinaryUser{
	private String status;
	public PrimeUser(int id, String name, String surname, int balance, String status) {
		super(id, name, surname, balance);
		this.status=status;
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" status: "+status;
	}

}
