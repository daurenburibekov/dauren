import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		SalesManagement sm = new SalesManagement();
		
		int choice = -1;
		
		while (choice != 0) {
			System.out.println("Welcome to the Sales Management System");
			System.out.println("1. Add product");
			System.out.println("2. Add user");
			System.out.println("3. Add a new order");
			System.out.println("4. Print initial queue");
			System.out.println("5. Print priority queue");
			System.out.println("6. Print list of users");
			System.out.println("7. Print user's info");
			System.out.println("8. Print product's info");
			System.out.println("9. Sort product's by price");
			System.out.println("10. Drop queue and hashmap");
			System.out.println("0. Exit");
			
			choice = in.nextInt();
			
			switch (choice) {
				case 1:
					System.out.println("Input product id: ");
					int pid = in.nextInt();
					System.out.println("Input product name: ");
					String pname = in.next();
					System.out.println("Input product quantity: ");
					int quantity = in.nextInt();
					System.out.println("Input product price: ");
					int price = in.nextInt();		
					Product product = new Product(pid, pname, quantity, price);
					sm.addProduct(product);
					break;
				case 2:
					System.out.println("Input user type: Ordinary -> 1; Prime -> 2; Loyal ->3; ");
					int type = in.nextInt();
					if(type==1) {
						System.out.println("Input user's id: ");
						int id = in.nextInt();
						System.out.println("Input user's name: ");
						String name = in.next();
						System.out.println("Input user's surname: ");
						String surname = in.next();
						System.out.println("Input user's initial balance: ");
						int balance = in.nextInt();
						User ou = new OrdinaryUser(id, name, surname, balance);
						sm.addUser(ou);
						break;
					} else if(type==2) {
						System.out.println("Input user's id: ");
						int id = in.nextInt();
						System.out.println("Input user's name: ");
						String name = in.next();
						System.out.println("Input user's surname: ");
						String surname = in.next();
						System.out.println("Input user's initial balance: ");
						int balance = in.nextInt();
						//System.out.println("Input user's status: ");
						//String status = in.next();
						User pu = new PrimeUser(id, name, surname, balance,"P");
						sm.addUser(pu);
						break;
					} else if(type==3) {
						System.out.println("Input user's id: ");
						int id = in.nextInt();
						System.out.println("Input user's name: ");
						String name = in.next();
						System.out.println("Input user's surname: ");
						String surname = in.next();
						System.out.println("Input user's initial balance: ");
						int balance = in.nextInt();
						//System.out.println("Input user's status: ");
						//String status = in.next();
						System.out.println("Input user's cashback is 0,05%");
						//Double cashback = in.nextDouble();
						User lu= new LoyalUser(id, name, surname, balance,"L",0.05);
						sm.addUser(lu);
						break;
					}
					break;
				case 3:
					System.out.println("Input user's id: ");
					int uid = in.nextInt();
					System.out.println("Input product name: ");
					pname = in.next();
					sm.addOrder(uid, pname);
					break;
				case 4:
					sm.initialQueue();
					break;
				case 5:
					sm.reorderQueue();
					break;
				case 6:
					sm.printUserInformation();
					break;
				case 7:
					System.out.println("Input user's ID: ");
					uid = in.nextInt();
					sm.printUsersInfo(uid);
					break;
				case 8:
					sm.printProductInformation();
					break;
				case 9:
					sm.sortProductByPrice();
					break;
				case 10:
					sm.dropMQ();
					break;
			}
		}
		in.close();
	}

}
