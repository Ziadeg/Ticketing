import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class queue {

	public static void main(String[] args) {
		//instance for list
		CreateQueue<Passenger> list = new CreateQueue<>();

		char choice;
		//String s;
		do {

			System.out.println("Enter A(dd), R(emove), S(can), or Q(uit)");
			Scanner in = new Scanner(System.in);

			choice = in.next().charAt(0);
			String name = null;
			String ticket = null;
			int num = 0;

			switch (Character.toUpperCase(choice)) {

			case 'A': // ADD PASSENGERS TO THE QUEUE
				in = new Scanner(System.in);
				System.out.println("Enter passenger name");
				name = in.nextLine();

				System.out.println("Enter ticket type");
				ticket = in.nextLine();

				System.out.println("Enter Seat number:");
				num = in.nextInt();
				//calling the class responsible of 
				Passenger added = new Passenger(name,ticket,num);
				list.enqueue(added);
				break;

			case 'R':
				// REMOVE PASSENGER FROM THE QUEUE
				Passenger rem = list.dequeue();
				System.out.println("Passenger removed is:" + rem);

				break;

			case 'S':
				// SCAN AND DISPLAY DETAILS OF A PARTICULAR PASSENGER
				in = new Scanner(System.in);
				System.out.println("Enter the passenger whose details are needed");
				name = in.nextLine();
				//creating copy of the list to take data from it
				CreateQueue<Passenger> listCopy = list;
				//while loop  search for details
				int size = listCopy.size();
				while (size>0) {
					//temp variable to throw data in
					Passenger temp = listCopy.dequeue();

					//to compare if the name is the 1 i am searching for
					if (temp.Name.equals(name)) {
						System.out.println(temp.Name + " " + temp.ticket_type + " " + temp.seat_no);
					}

					Passenger addedd = new Passenger(temp.Name,temp.ticket_type,temp.seat_no);
					list.enqueue(addedd);
					size--;
				}

				//Passenger scan = list.
				break;

			case 'Q':
				// DISPLAY CONTENTS IN QUEUE AND QUIT THE LOOP
				CreateQueue<Passenger> listCopy2 = list;
				while (listCopy2.hasItems()) {
					//temp variable to throw data in
					System.out.println("Leaving queue with 2 passengers");
					System.out.println("The passengers' names are:");
					while (listCopy2.size() !=0) {
						//i need the list in order dequeu everytime and prints the passengers	
						Passenger temp = listCopy2.dequeue();
						System.out.println( temp.Name + " " + temp.ticket_type + " " + temp.seat_no);

					}
					;
					System.exit(0);

				}	
				break;

			default:
				System.out.println("Invalid choice ---try again\n");
			}



			//System.out.println(added.Name);
		} while (Character.toUpperCase(choice) != 'Q');
		// return;
	}

	// class to create queue
	static class CreateQueue<E> {
		private LinkedList<E> list = new LinkedList<E>();

		public void enqueue(E item) { // SAME AS PUSH IN STACK
			list.addLast(item);
		}

		// method to remove queue
		public E dequeue() { // SAME AS POP IN STACK
			return list.poll();
		}

		public boolean hasItems() { // CHECKS IF THE QUEUE IS EMPTY OR NOT
			return !list.isEmpty();
		}

		public int size() { // DETERMINES THE SIZE OF QUEUE
			return list.size();
		}

		public void addItems(CreateQueue<? extends E> q) { // ADDS ITEMS
			// TOLINKED LIST

			while (q.hasItems())
				list.addLast(q.dequeue());
		}
	}

	// classes used to implement the queue
	static class Passenger {
		public String Name;
		public String ticket_type;
		public int seat_no;

		public Passenger() {
		}

		public Passenger(String name, String type, int num) {
			this.Name = name;
			this.ticket_type = type;
			this.seat_no = num;
		}

		public String toString() {
			return Name + " " + ticket_type + " " + seat_no;
		}
	}

	class PassengerData extends Passenger {
		public PassengerData(String name, String type, int num) {
			super(name, type, num);
		}
	}


}
