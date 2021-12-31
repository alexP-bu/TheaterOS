package theaterCLI;

import java.util.ArrayList;
import java.util.List;

public class Account{
	private String username;
	private String password;
	private String type;
	private double balance;
	private int rewardsPoints;
	private List<Ticket> purchaseHistory;

	//default constructor for an account is a builder
	private Account(AccountBuilder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.balance = builder.balance;
		this.type = builder.type;
		this.rewardsPoints = builder.rewardsPoints;
		this.purchaseHistory = builder.purchaseHistory;
	}
	public static class AccountBuilder{
		private String username;
		private String password;
		private String type;
		private double balance = 0.0;
		private int rewardsPoints = 0;
		private List<Ticket> purchaseHistory = new ArrayList<Ticket>();

		public AccountBuilder(String username, String password){
			this.username = username;
			this.password = password;
		}

		public AccountBuilder(){
			this.username = "Guest";
			this.password = "Guest";
			this.type = "Guest";
		}

		public AccountBuilder type(String type){
			this.type = type;
			return this;
		}

		public AccountBuilder balance(int bal){
			this.balance = bal;
			return this;
		}

		public Account build(){
			return new Account(this);
		}
	}
	/*
	 * add ticket to account
	 */
	public void addTicket(Ticket ticket) {
		purchaseHistory.add(ticket);
	}
	//get account password
	public String getPassword(){
		return password;
	}
	public String getType(){
		return type;
	}

	public String getUsername(){
		return username;
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
