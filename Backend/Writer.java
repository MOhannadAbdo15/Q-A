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
	static ArrayList<String> ls = new ArrayList<String>();

	//holds an array of strings containing each line from the Current Bank Account Transaction File
	static ArrayList<String> cb = new ArrayList<String>();

	//holds an array of Strings containing each line from the MasterBankAccounts File
	static ArrayList<String> mb = new ArrayList<String>();
	
	/*public ArrayList getMaster(){
		return ls;
	}

	public void setMaster(ArrayList name){
		 ls = name;
	}

	public ArrayList getMaster(){
		return mb;
	}

	public void setMaster(ArrayList list){
		mb = list;
	}
	*/
	
	//String file1 = "mergedtransactions.txt";
	//String file2 = "MasterBankAccounts.txt";

	public static void main(String[] args) {
		
		//declare student plan 	
		boolean student;
		
		//Accept multiple transaction files
		String MasterBankAccounts ="";
		String BankAccountTransactions = "";
		
		MasterBankAccounts = args[0];
		//BankAccountTransactions = args[1];
		
		for(int i= 1; i < args.length; i++)
		{
			BankAccountTransactions = args[i];
			try{

			//System.out.println(args[i]);
			FileReader fileReader2 = new FileReader(BankAccountTransactions);

			BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
	        
			String line = "";
			line = bufferedReader2.readLine();
			while(line!=null)
			{
				//System.out.println(line);
				ls.add(line+ "\n");
				System.out.println(ls);
				

				String balance = line.substring(30, 38);
				//System.out.println(balance);
				float newBalance = Float.parseFloat(balance);
				System.out.println(balance);

				String plan = line.substring(42,43);
				System.out.println(plan);
				
				if(plan.equals("N"))
				{
					student=true;
					System.out.println("Plan : Non-Student Plan");
				}
				else if(plan.equals("S"))
				{
					student=false;
					System.out.println("Plan : Student Plan");
				}
				else
					System.out.println("Error found in Master Bank Accounts File");

				
				line = bufferedReader2.readLine();
				}

			
			}
			catch(IOException ex) {

		    	System.out.println("Error reading file '" + BankAccountTransactions + "'");
			} 
		} 

		
		

	    try {
	    	
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader1 = new FileReader(MasterBankAccounts);
	        
	        //Scanner in = new Scanner(fileReader1);
	        
	    
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
	
		String line1 = "";
		line1 = bufferedReader1.readLine();
		while(line1!=null)
		{

			String to_remove = line1.substring(37,41);
			mb.add(line1);
			String newString = line1.replace(to_remove, "");
			System.out.println(newString);
			//System.out.println(line1.substring(37,41));
			cb.add(newString);
			//System.out.println(cb);

			String balance = line1.substring(28, 37);
			//System.out.println(balance);
			float newBalance = Float.parseFloat(balance);
			System.out.println(balance);

			String plan = line1.substring(42,43);
			System.out.println(plan);
			
			if(plan.equals("N"))
			{
				student=true;
				System.out.println("Plan : Non-Student Plan");
			}
			else if(plan.equals("S"))
			{
				student=false;
				System.out.println("Plan : Student Plan");
			}
			else
				System.out.println("Error found in Master Bank Accounts File");

			line1 = bufferedReader1.readLine();

			String newList = "";
			for (String s : mb)
			{
				newList += s + "\n";
			}

			PrintWriter writer = new PrintWriter("NewMasterBankAccounts.txt","UTF-8");
			writer.println(newList);
			writer.close();

			String currentBank = "";
			for (String s : cb)
			{
				currentBank += s + "\n";
			}

			PrintWriter writer2 = new PrintWriter("NewCurrentBankAccounts.txt","UTF-8");
			writer2.println(currentBank);
			writer2.close();
		
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
