package Backend;

// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.PrintWriter;
// import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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
				
				//currentAccount will be written to the current bank accounts file
				String currentAccount = newAccount;

				newAccount += mb.get(i).getTransactions() + " ";
				if (mb.get(i).getStudent() == true){
					newAccount += "S";
					currentAccount += "S"; 
				}else{
					newAccount += "N"; 
					currentAccount += "N"; 
				}

				System.out.println(newAccount);

				newAccount += "\n";
				currentAccount += "\n";

				writer.write(newAccount);
				writer2.write(currentAccount);

				newAccount = "";
				currentAccount = "";
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
		
		//Accept multiple transaction files
		String MasterBankAccounts ="";
		String BankAccountTransactions = "";
		
		//Bank Accounts file is the first argument
		MasterBankAccounts = args[0];

		//BankAccountTransactions = args[1];
		try{

			PrintWriter mergewriter = new PrintWriter(new FileOutputStream(new File("MergedBankAccountTransactionFile.txt"),true));
			
			//Loading transactions
			for(int i= 1; i < args.length; i++){
				BankAccountTransactions = args[i];
				try{

					//System.out.println(args[i]);
					FileReader fileReader2 = new FileReader(BankAccountTransactions);
					BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
	    			
	    			// mergewriter.write("hello world");

					String line = "";
					line = bufferedReader2.readLine();
					while(line!=null){

						//write to merged file
						// System.out.println("Writing to Merge: " + line);
						mergewriter.write(line + "\n");

						//System.out.println(line);
						Transaction newtransaction = new Transaction();

						//*******Need to trim whitespace;*********

						newtransaction.setCode(line.substring(0,2));
						newtransaction.setName(line.substring(3,23).trim());
						newtransaction.setNum(line.substring(24,29));

						String balance = line.substring(30, 38);
						//System.out.println(balance);

						//*******Need to change to decimal precison of 2*******
						float newBalance = Float.parseFloat(balance);

						newtransaction.setAmount(newBalance);

						String plan = line.substring(39, 41);
						newtransaction.setMisc(line.substring(39, 41));

						String linestudent = line.substring(42,43);
						
						if(plan.equals("N ")){
							newtransaction.setStudent(false);
						}else if(plan.equals("S ")){
							newtransaction.setStudent(true);
						}else{
							// System.out.println("Error found in Master Bank Accounts File");
						}

						//add to the arraylist
						ls.add(newtransaction);
						line = bufferedReader2.readLine();
					}
					mergewriter.close();
				}catch(IOException ex) {
			    	System.out.println("Error reading file '" + BankAccountTransactions + "'");
				} 
			}
		}catch(IOException ex) {
	    	System.out.println("Error reading file");
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
			while(line1!=null){

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
