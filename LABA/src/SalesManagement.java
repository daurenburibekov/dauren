import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SalesManagement {
	List<Product> products;
	List<User> users;
	List<Order> orders;
	Queue<Integer> orderQueue;
	HashMap<User, Order> mp;
	
	public SalesManagement() {
		products=new ArrayList<>();
		users=new ArrayList<>();
		orders=new ArrayList<>();
		orderQueue = new LinkedList<>();
		mp=new HashMap<User, Order>();
	}

	public void addProduct(Product product) {
		/*boolean a=true;
		if(products.size()==0) {
			products.add(product);
		}else {
			for(int i=0; i<products.size();i++) {
				if(products.get(i).getName().equals(product.getName())) {
					System.out.println("Choose another name for product!");
					a=true;
				}else {
					a=false;
				}
			}
			if(a=false) {
				products.add(product);
			}
		}*/
		ArrayList<String> names=allNames();
		if(names.contains(product.getName())) {
			System.out.println("Choose another name for product!");
		}else {
			products.add(product);
		}
	}
	
	public void addUser(User user) {
		int c=0;
		if(users.size()==0) {
			users.add(user);
		} else {
			for(int i=0; i<users.size();i++) {
				if(users.get(i).getId()==user.getId()) {
					System.out.println("Choose another id for user!");
					c++;
				}
			}
			if(c==0) {
				users.add(user);
			}
		}
	}

	public void decreaseProductQuantity(int id) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId()==id) {
				if(products.get(i).getQuantity()==0) {
					System.out.println("Out of stock!");
				}else {
					products.get(i).setQuantity(products.get(i).getQuantity()-1);
				}
			}
		}
	}
	public void increaseProductQuantity(int id) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId()==id) {
				products.get(i).setQuantity(products.get(i).getQuantity()+1);
			}
		}
	}
	
	public void decreaseBalance(int id, int price) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId()==id) {
				if(((OrdinaryUser) users.get(i)).getBalance()<price) {
					System.out.println("Not enough money!");
				} else {
					((OrdinaryUser) users.get(i)).setBalance(((OrdinaryUser)users.get(i)).getBalance()-price);
				}
			}
		}
	}
	public void increaseBalance(int id, int price) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId()==id) {
				((LoyalUser)users.get(i)).setBalance(((LoyalUser)users.get(i)).getBalance()
						+(int)(((LoyalUser)users.get(i)).getCashback()*price));
			}
		}
	}
	public void addOrder(int uid, String pname) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId()==uid) { 
				for (int j = 0; j < products.size(); j++) {
					if (products.get(j).getName().equals(pname)) {
						Order o = new Order(products.get(j).getName(),products.get(j).getPrice());
						mp.put(users.get(i), o);
						orderQueue.add(users.get(i).getId());
						decreaseProductQuantity(products.get(j).getId());
						decreaseBalance(users.get(i).getId(),products.get(j).getPrice());
						if(users.get(i) instanceof LoyalUser) {
							increaseBalance(users.get(i).getId(),products.get(j).getPrice());
						}
					} else {
						System.out.println("Product doesn't exist!");
					}
				} 
			} else {
				System.out.println("User doesn't exist!");
			}
		}
	}
	
	public void initialQueue() {
		System.out.println(orderQueue);
	}
	
	public void printUsersInfo(int uid) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId()==uid) { 
				System.out.println(((OrdinaryUser)users.get(i)).toString());
			} else {
				System.out.println("User doesn't exist!");
			}
		}
	}
	
	public void reorderQueue() {
		Queue<Integer> tempQueueOU= new LinkedList<>();
		Queue<Integer> tempQueuePU= new LinkedList<>();
		Queue<Integer> tempQueueLU= new LinkedList<>();
		while(!orderQueue.isEmpty()) {
			for(User key:mp.keySet()) {
				if(orderQueue.peek()==key.getId()) {
					if(key instanceof OrdinaryUser && key instanceof LoyalUser) {
						tempQueueLU.offer(orderQueue.poll());
					}
					else if(key instanceof OrdinaryUser && key instanceof PrimeUser) {
						tempQueuePU.offer(orderQueue.poll());
					}
					else if(key instanceof OrdinaryUser) {
						tempQueueOU.offer(orderQueue.poll());
					}
				}
			}
		}
		System.out.println(tempQueueLU);
		System.out.println(tempQueuePU);
		System.out.println(tempQueueOU);
        while(!tempQueueLU.isEmpty()){
            orderQueue.offer(tempQueueLU.poll());
        }
        while (!tempQueuePU.isEmpty()){
            orderQueue.offer(tempQueuePU.poll());
        }
        while(!tempQueueOU.isEmpty()){
            orderQueue.offer(tempQueueOU.poll());
        }
		/*Iterator<Integer> itl=tempQueueLU.iterator();
		while(itl.hasNext()) {
			orderQueue.add(itl.next());
		}
		Iterator<Integer> itp=tempQueuePU.iterator();
		while(itp.hasNext()) {
			orderQueue.add(itp.next());
		}
		Iterator<Integer> ito=tempQueueOU.iterator();
		while(ito.hasNext()) {
			orderQueue.add(ito.next());
		}*/
		
		System.out.println(orderQueue);
	}
	
	public void dropMQ() {
		mp.clear();
		orderQueue.clear();
	}
	
	public void printUserInformation() {
		System.out.println("There are  " + users.size() + " users registered in our system");
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
	}
	public void printProductInformation() {
		System.out.println("There are  " + products.size() + " different product(s) in our stock");
		for(int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i).toString());
		}
	}
	/*public void computeCashback(List<User> other, List<Order> orders) {
		
		//int cashback=0;
		double cb=0;
		for(int i=0;i<orders.size();i++) {
			for(User o: other) {
				if(o.equals(orders.get(i).getUser())&&orders.get(i).getUser() instanceof LoyalUser)
					cb=((LoyalUser) orders.get(i).getUser()).getCashback()*orders.get(i).getPrice();
			}
			//cashback=(int)cb;
		}
		System.out.println(orders);
		System.out.println((int)cb);
	}*/
	public void sortProductByPrice() {
		Collections.sort(products);
		System.out.println("Products after sorting : "); 
		for (Product p: products) 
		{ 
			System.out.println(p.getId() + " " + 
					p.getName() + " " + 
					p.getPrice() + " " + 
					p.getQuantity()); 
		} 
		// TODO Auto-generated method stub
		
	}
	public ArrayList<String> allNames(){
		ArrayList<String> result= new ArrayList<String>();
		for(Product p: products) {
			result.add(p.getName());
		}
		return result;
				
	}

	/*public void sortUsersByBalance() {
		Collections.sort((List<T>) users);
		// TODO Auto-generated method stub
		System.out.println("Users after sorting : "); 
		for (User o: users) 
		{ 
			System.out.println(o.getId() + " " + 
					o.getName() + " " + 
					o.getSurname() + " " + 
					((OrdinaryUser) o).getBalance()); 
		} 
	}*/
}
