import java.util.*;

public class Main_menu {

	public static void main(String[] args) {
		
		//welcoming prompt
		//user choose between register member, update purchase, or member listing
		int option=0;
		boolean success=false;
		MembershipRegistration session = new MembershipRegistration();
		
		do {
			do{
				success=false;
				
				System.out.println("*****************************");
				System.out.println("Devil chan membership system");
				System.out.println("*****************************");
				System.out.println("What would you like to do next?");
				
				while(!success){
					try {
						Scanner scan = new Scanner(System.in);
					
						System.out.println("1. Register new members");
						System.out.println("2. Update purchase");
						System.out.println("3. Display membership listing");
						System.out.println("4. Quit");
						System.out.println("Key in your option (1, 2, 3, 4)");
						System.out.println("*****************************");
						System.out.println("Option:");
									
						option = scan.nextInt();
						success = true;
					}catch(InputMismatchException i ) {
						System.out.println("Error. Please key in only 1, 2, or 3 as options");
					}	
				}
			}while(option<1||option>4);
			
			
			//redirect to respective methods
			switch(option){
				case 1:
					System.out.println("****************************");
					System.out.println("   1. Register New Member  ");
					System.out.println("****************************");
					session.registration();
					break;
				case 2:
					System.out.println("*****************************");
					System.out.println("  2. Update Purchase Amount   ");
					System.out.println("*****************************");
					session.update_purchase();
					break;
				case 3:
					System.out.println("*****************************");
					System.out.println("3. Print Full Membership List ");
					System.out.println("*****************************");
					session.printMembershipList();
					break;
				case 4:
					System.out.println("*****************************");
					System.out.println("       Exiting System        ");
					System.out.println("*****************************");
					System.exit(0);
					System.out.println("");
					System.out.println("Thank you!");
			}
		}while(option!=4);
		
		
	}
}
