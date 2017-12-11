import java.util.*;

public class Members {
	public int membership_number;
	private String name;
	private String NRIC;
	private String contact;
	private int purchase;
	private int points;
	private String start_date;
	private String expiry_date;
	
	public Members(int membership_number, String name, String NRIC, String contact, int purchase) {
		Calendar today = Calendar.getInstance();
		
		this.membership_number = membership_number;
		this.name = name;
		this.NRIC = NRIC;
		this.contact = contact;
		this.purchase = purchase;
		points = purchase/10;
		
		start_date = today.getTime().toString();
		today.add(Calendar.YEAR, 1);
		expiry_date = today.getTime().toString();
		
	}
	
	public void updatePurchase(int newPurchaseAmount) {
		purchase = newPurchaseAmount;
	}
	
	public void getRecord() {
		System.out.format("%-15d%-30s%-15s%-15s%-15d%-15d%-30s\n", membership_number, name, NRIC, contact, purchase, points, expiry_date);
	}
}
