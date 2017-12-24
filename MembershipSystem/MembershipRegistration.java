import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MembershipRegistration {
	
	public static Members[] members_array = new Members[51];	// members array
	static int membership_number=1;								//membership number count
	int registered_members;					//number of registered members
	
	/*----------main method to register members----------*/
	public void registration() {
		
		//if out of availability
		if(availability()<=0) {
			System.out.println("Membership slots are currently full.");
		}
		
		//enter details of member and add to array
		Members new_member = enter_details();
		register_member(new_member);

		printMembershipList();
	}
	
	/*----------main method to update member purchase amount----------*/
	public void update_purchase() {
		int newPurchaseAmount=0;
		
		//user search for member to have purchase amount to be updated
		int member = member_search();
		
		//enter new purchase amount
		System.out.println("Please enter the new purchase amount for member with membership #"+member);
		boolean success=false;
		while(!success) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("Updated purchase amount:");
				newPurchaseAmount = scan.nextInt();
				success = true;
			}catch(InputMismatchException i) {
				System.out.println("Error. Input mismatch exception. Please enter again");
			}
		}
		
		members_array[member].updatePurchase(newPurchaseAmount);
		
		printMembershipList();
	}
	
	// checks and returns array availability
	private int availability() {
		int i;
		int availability=0;
		for(i=50; i>0; i--) {
			if(members_array[i]==null) {
				availability++;
			}
		}		
		registered_members = 50-availability;
		return availability;
	}
	
	// adds members to array
	private void register_member(Members new_member) {
		members_array[membership_number] = new_member;
		membership_number+=1;
		
		availability();
	}
	
	// prompts for new member details
	private Members enter_details() {
		String name="";
		String NRIC="";
		String contact="";
		int purchase=0;
		
		System.out.println("To add member, please provide:");
		
		boolean success=false;
		while(!success) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("Name:");
				name = scan.nextLine();
				success = true;
			}catch(InputMismatchException i) {
				System.out.println("Error. Input mismatch exception. Please enter again");
			}
			
		}
		
		success=false;
		while(!success) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("IC number");
				NRIC = scan.nextLine();
				success = true;
			}catch(InputMismatchException i) {
				System.out.println("Error. Input mismatch exception. Please enter again");
			}			
		}
		
		success=false;
		while(!success) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("Contact number");
				contact = scan.nextLine();
				success = true;
			}catch(InputMismatchException i) {
				System.out.println("Error. Input mismatch exception. Please enter again");
			}			
		}
		
		success=false;
		while(!success) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("Purchase amount");
				purchase = scan.nextInt();
				success = true;
			}catch(InputMismatchException i) {
				System.out.println("Error. Input mismatch exception. Please enter again");
			}			
		}
		Members new_member = new Members(membership_number, name, NRIC, contact, purchase);
		
		
		return new_member;
	}
	
	/*----------main method to print membership list----------*/
	public void printMembershipList(){
		System.out.println("==========================================================Membership Listing=========================================================");
		System.out.format("%-15s%-30s%-15s%-15s%-15s%-15s%-30s\n", "Membership#", "Name", "NRIC", "Contact", "Purchase", "Points", "Expiry_date");
		int i=1;
		while(members_array[i]!=null && i!=50) {
			Members member = members_array[i];
			member.getRecord();
			i++;
		}
		System.out.println("=====================================================================================================================================");
	}
		
	private int member_search() {
		int searched_member=-1;
		boolean success=false;
		
		do {
			while(!success) {
				try {
					System.out.println("To update a member's purchase amount, first insert member's membership number:");
					System.out.println("Membership number:");
					Scanner scan = new Scanner(System.in);
					
					searched_member = scan.nextInt();
					success = true;
				}catch(InputMismatchException i) {
					System.out.println("Error. Input mismatch exception. Please enter again");
				}
			}
			
			// loop through member array to see if membership number exists
			success = false;
			System.out.println("Registered members: "+registered_members);
			for(int i=1; i<=registered_members; i++) {
				if(members_array[i].membership_number==searched_member) {
					success=true;
				}
			}			
			if(success==false) {
				System.out.println("Number not found. Try again");
			}
			
		}while(!success);
		
		return searched_member;		
	}

}
