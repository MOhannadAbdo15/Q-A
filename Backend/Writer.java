package Backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Writer 
{
	
	//holds an array of strings containing each line from the BankAccountTransactions File
	static ArrayList<Transaction> ls = new ArrayList<Transaction>();

	//holds an array of strings containing each line from the Current Bank Account Transaction File
	static ArrayList<Account> cb = new ArrayList<Account>();

	//holds an array of Strings containing each line from the MasterBankAccounts File
	static ArrayList<Account> mb = new ArrayList<Account>();
	
	/*public ArrayList getMaster(){
		return ls;
	}

	public void setMaster(ArrayList name){
		 ls = name;
	}*/

	public ArrayList<Account> getAccounts(){
		return mb;
	}

	public void setAccounts(ArrayList<Account> list){
		mb = list;
	}

	public ArrayList<Transaction> getTransactions(){
		return ls;
	}

	public void setTransactions(ArrayList<Transaction> list){
		ls = list;
	}

	public void write(){
		try{

			PrintWriter writer = new PrintWriter("NewMasterBankAccounts.txt","UTF-8");
			PrintWriter writer2 = new PrintWriter("NewCurrentBankAccounts.txt","UTF-8");

			String newAccount = "";

			for (int i = 0; i < mb.size(); i++) {
				newAccount += mb.get(i).getNum() + " ";
				newAccount += mb.get(i).getName() + " ";
				newAccount += mb.get(i).getStatus() + " ";
				newAccount += mb.get(i).getBalance() + " ";
				newAccount += mb.get(i).getTransactions() + " ";
				if (mb.get(i).getStudent() == true){
					newAccount += "S"; 
				}else{
					newAccount += "N"; 
				}

				System.out.println(newAccount);
				
				newAccount += "\n";

				writer.write(newAccount);

				newAccount = "";
			}

			writer.close();
			writer2.close();
		}catch(IOException ex) {
		    	System.out.println("Error reading file");
		} 

	}
	
	//String file1 = "mergedtransactions.txt";
	//String file2 = "MasterBankAccounts.txt";

	public Writer(String[] args) {
		
		//declare student plan 	
		boolean student;
		
		//Accept multiple transaction files
		String MasterBankAccounts ="";
		String BankAccountTransactions = "";
		
		//Bank Accounts file is the first argument
		MasterBankAccounts = args[0];

		//BankAccountTransactions = args[1];
		
		//Loading transactions
		for(int i= 1; i < args.length; i++){
			BankAccountTransactions = args[i];
			try{

				//System.out.println(args[i]);
				FileReader fileReader2 = new FileReader(BankAccountTransactions);

				BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
		        
				String line = "";
				line = bufferedReader2.readLine();
				while(line!=null){
					//System.out.println(line);;
					Transaction newtransaction = new Transaction();

					//*******Need to trim whitespace;*********

					newtransaction.setCode(line.substring(0,2));
					newtransaction.setName(line.substring(3,23).trim());
					newtransaction.setNum(line.substring(24,29));

					String balance = line.substring(30, 38);
					//System.out.println(balance);
					float newBalance = Float.parseFloat(balance);

					newtransaction.setAmount(newBalance);

					// System.out.println(balance);

					String plan = line.substring(39, 41);
					newtransaction.setMisc(line.substring(39, 41));

					String linestudent = line.substring(42,43);

					
					if(plan.equals("N ")){
						student=false;
						newtransaction.setStudent(false);
						// System.out.println("Plan : Non-Student Plan");
					}else if(plan.equals("S ")){
						student=true;
						newtransaction.setStudent(true);
						// System.out.println("Plan : Student Plan");
					}else{
						// System.out.println("Error found in Master Bank Accounts File");
					}

					//add to the arraylist
					ls.add(newtransaction);
					line = bufferedReader2.readLine();
				}
			}catch(IOException ex) {
		    	System.out.println("Error reading file '" + BankAccountTransactions + "'");
			} 
		} 

		//Read Accounts
	    try {
	    	
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader1 = new FileReader(MasterBankAccounts);
	        
	        //Scanner in = new Scanner(fileReader1);
	    
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
	
			String line1 = "";
			line1 = bufferedReader1.readLine();
			// line1 = null;
			while(line1!=null){
				// private String num;
				// private String name;
				// //Status is either "A" for active or "D" for disabled
				// private String status;
				// private double balance;
				// private double frozenbalance;
				// private int transactions;
				// private boolean createdtoday;
				// //student is TRUE if the account is a student account
				// private boolean student;

				Account newaccount = new Account();

				newaccount.setNum(line1.substring(0,5));
				newaccount.setName(line1.substring(6,25).trim());
				newaccount.setStatus(line1.substring(26,27));

				String balance = line1.substring(28, 36);
				float newBalance = Float.parseFloat(balance);
				newaccount.setBalance(newBalance);

				String t = line1.substring(37, 41);
				int newt = Integer.parseInt(t);
				newaccount.setTransactions(newt);
				String newstudent = line1.substring(42,43);
				if (newstudent.equals("N")){
					newaccount.setStudent(false);
				}else{
					newaccount.setStudent(true);
				}
				newaccount.setCreated(false);
				newaccount.setFrozen(0);

				// String to_remove = line1.substring(37,41);
				// mb.add(line1);
				// String newString = line1.replace(to_remove, "");
				// System.out.println(newString);
				//System.out.println(line1.substring(37,41));
				// cb.add(newString);
				//System.out.println(cb);

				// String balance = line1.substring(28, 37);
				//System.out.println(balance);
				// float newBalance = Float.parseFloat(balance);
				// System.out.println(balance);

				// String plan = line1.substring(42,43);
				// System.out.println(plan);
				
				// if(plan.equals("N")){
				// 	student=true;
				// 	System.out.println("Plan : Non-Student Plan");
				// }else if(plan.equals("S")){
				// 	student=false;
				// 	System.out.println("Plan : Student Plan");
				// }else
				// 	System.out.println("Error found in Master Bank Accounts File");

				line1 = bufferedReader1.readLine();

				mb.add(newaccount);
			}
	    }
	    catch(FileNotFoundException ex) {
		System.out.println("Unable to open file '" + MasterBankAccounts + "'"); 
	    }
	    catch(IOException ex) {
	    	System.out.println("Error reading file '" + MasterBankAccounts + "'");  
	    }
	}

}
