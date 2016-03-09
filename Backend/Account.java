package Backend;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Account {
	private String num;
	private String name;
	private String status;
	private double balance;
	private int transactions;
	private boolean createdtoday;

	public Account(String newnum,String newname, String newstatus, double newbalance, int newtransactions){
		num = newnum;
		name = newname;
		status = newstatus;
		balance = newbalance;
		transactions = newtransactions;
	}

	//test function that prints out this object's entire member variables;
	public void printAccount(){
		System.out.println("===Account===");
		System.out.println("Number:" + num);
		System.out.println("Name:" + name);
		System.out.println("Status:" + status);
		System.out.println("Balance:" + balance);
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
}