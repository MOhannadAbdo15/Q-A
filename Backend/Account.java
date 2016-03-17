package Backend;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Account {

	private String num;
	private String name;
	//Status is either "A" for active or "D" for disabled
	private String status;
	private double balance;
	private double frozenbalance;
	private int transactions;
	private boolean createdtoday;
	//student is TRUE if the account is a student account
	private boolean student;

	public Account(String newnum,String newname, String newstatus, double newbalance, int newtransactions, boolean newstudent){
		num = newnum;
		name = newname;
		status = newstatus;
		balance = newbalance;
		frozenbalance = 0;
		transactions = newtransactions;
		student = newstudent;
		createdtoday = true;
	}

	//test function that prints out this object's entire member variables;
	public void printAccount(){
		System.out.println("===Account===");
		System.out.println("Number:" + num);
		System.out.println("Name:" + name);
		System.out.println("Status:" + status);
		System.out.println("Balance:" + balance);
		System.out.println("Frozen balance:" + frozenbalance);
		System.out.println("Transactions:" + transactions);
	}

	public String getNum(){
		return num;
	}

	public void setNum(String newnum){
		num = newnum;
	}

	public String getName(){
		return name;
	}

	public void setName(String newname){
		name =newname;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String newstatus){
		status = newstatus;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double newbalance){
		balance = newbalance;
	}

	public int getTransactions(){
		return transactions;
	}

	public void setTransactions(int newtransactions){
		transactions = newtransactions;
	}

	public void incTransactions(){
		if (transactions < 9999){
			transactions++;
		}
	}

	public boolean getStudent(){
		return student;
	}

	public void setStudent(boolean newstudent){
		student = newstudent;
	}

	public boolean getCreated(){
		return createdtoday;
	}

	public void flipCreated(){
		if (createdtoday){
			createdtoday = false;
		}else{
			createdtoday = true;
		}
	}
	
	public void setCreated(boolean newcreatedtoday){
		createdtoday = newcreatedtoday;
	}	

	public double getFrozen(){
		return frozenbalance;
	}

	public void setFrozen(double newfrozen){
		frozenbalance = newfrozen;
	}

}