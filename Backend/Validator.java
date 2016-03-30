//Validator Class
//Handles various Validatation functions in our program
//In general, this class takes in some value, and either an account
//or the accounts list, and checks to see if the first value is valid.

package Backend;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Validator{

	//checks if the session is logged in
	public boolean sessionLoggedIn(boolean loggedin){
		if (loggedin) {
			return true;
		}else{
			System.out.println("ERROR: Attempting transaction when not logged in");
			return false;
		}
	}

	//find an account in the accounts list given the number
	//Checks if the given Account number exists in the given Array List of accounts
	public Account findAccount(String target, ArrayList<Account> accounts){
		// Iterate through the accounts list
		for (int i = 0; i < accounts.size();i++) {
			//If the name is equal return true
			if (target.equals(accounts.get(i).getNum())){
				return accounts.get(i);
			}
		}
		//If we've gotten this far return false, account number doesn't exist in our ArrayList
		System.out.println("ERROR: Account number does not exist");
		return null;
	}

	//finds the highest account number in the array, and returns the next number as a String
	public String findNextNumber(ArrayList<Account> accounts){
		int largest = 0;
		// Iterate through the accounts list
		for (int i = 0; i < accounts.size();i++) {
			if (largest < Integer.parseInt(accounts.get(i).getNum())) {
				largest = Integer.parseInt(accounts.get(i).getNum());
			}
		}

		String next = Integer.toString(largest+1);

		for (int i = 0;i < 7-(next.length());i++) {
			next = "0" + next;
		}
		return next;
	}

	//Checks if the given file was just created
	public boolean accountJustCreated(Account target){
		return target.getCreated();
	}

	//Checks to see if a given string matches the name of an account holder
	public boolean accountMatchName(String sourcename, Account target){
		if (sourcename.equals(target.getName())){
			return true;
		}else{
			System.out.println("ERROR: Name given does not match account holder name");
			return false;
		}
	}

	//Checks to see if the account has enough money 
	public boolean enoughBalance(double amount, Account target){
		if (target.getBalance() >= amount){
			return true;
		}
		System.out.println("ERROR: Account does not have enough funds");
		return false;
	}

	///checks to see if the company exists
	public boolean checkCompany(String company){
		if(company.equals("EC") || company.equals("CQ") || company.equals("TV")){
			return true;
		}
		return false;
	}
}