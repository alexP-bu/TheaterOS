package theaterProjectCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
	private String username;
	private String password;
	private String type;
	private double balance;
	private int rewardsPoints;
	private List<Ticket> purchaseHistory;

	/*
	 * constructors
	 */
	public Account(String username, String password, String type) {
		this.username = username;
		this.password = password;
		this.balance = 0.00;
		this.type = type;
		this.rewardsPoints = 0;
		this.purchaseHistory = new ArrayList<Ticket>();
	}
	/*
	 * add ticket to account
	 */
	public void addTicket(Ticket ticket) {
		purchaseHistory.add(ticket);
	}

	@Override
	public String toString() {
		return username + "'s Account Data:"         + "\n" 
			   + "Current balance: " + balance       + "\n"
			   + "Rewards points: "  + rewardsPoints + "\n" 
			   + "Purchase history: "                + "\n"
			   + purchaseHistory                     + "\n";
	}
}
