/*
* Writer Tester:
*  
* A series of Junit tests designed to test the functions
* in Writer.java
*/

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.*;
import Backend.*;
import java.lang.*;
import java.util.*;

public class WriterTester {

	//This test tests for a normal construction of a writer
	//reading accounts and transactions
	//the loading loop is done twice (two transaction files)
	//and the inner while in the loading loop is done many times
	//The while in the read accounts is done many times
	//Both student and non student accounts and transactions are loaded
	//so both sides of those two if statements are covered.
	@Test
    public void writerloadertest() {
    	String[] args = new String[3];
    	args[0] = "MasterBankAccounts.txt";
    	args[1] = "Deposit1.out.txt";
    	args[2] = "Withdrawal1.out.txt";

    	Account a = new Account("00001","testaccount1", "A", 123.00, 0, false);
    	Account a2 = new Account("00009","testenoughstudent", "A", 300.05, 0, true);

    	Writer w = new Writer(args);
        assertEquals(w.getAccounts().get(0).getNum(),a.getNum());
        assertEquals(w.getAccounts().get(0).getName(),a.getName());
        assertEquals(w.getAccounts().get(0).getStatus(),a.getStatus());
        assertEquals(w.getAccounts().get(0).getBalance(),a.getBalance(), 0.0001);
        assertEquals(w.getAccounts().get(0).getTransactions(),a.getTransactions());
        assertEquals(w.getAccounts().get(0).getStudent(),a.getStudent());

        assertEquals(w.getAccounts().get(8).getNum(),a2.getNum());
        assertEquals(w.getAccounts().get(8).getName(),a2.getName());
        assertEquals(w.getAccounts().get(8).getStatus(),a2.getStatus());
        assertEquals(w.getAccounts().get(8).getBalance(),a2.getBalance(), 0.0001);
        assertEquals(w.getAccounts().get(8).getTransactions(),a2.getTransactions());
        assertEquals(w.getAccounts().get(8).getStudent(),a2.getStudent());

        Transaction t[] = new Transaction[4]; 
        t[0] = new Transaction();
        t[1] = new Transaction();
        t[2] = new Transaction();
        t[3] = new Transaction();

        t[0].setCode("10");
        t[0].setName("test account1");
        t[0].setNum("00000");
        t[0].setAmount(0.00);
        t[0].setMisc("S ");
        t[0].setStudent(false);

        t[1].setCode("04");
        t[1].setName("test account1");
        t[1].setNum("00001");
        t[1].setAmount(100.00);
        t[1].setMisc("00");
        t[1].setStudent(false);

        t[2].setCode("10");
        t[2].setName("");
        t[2].setNum("00000");
        t[2].setAmount(0.00);
        t[2].setMisc("A ");
        t[2].setStudent(false);

        t[3].setCode("01");
        t[3].setName("test account1");
        t[3].setNum("00001");
        t[3].setAmount(100.00);
        t[3].setMisc("00");
        t[3].setStudent(false);

        assertEquals(w.getTransactions().get(0).getCode(), t[0].getCode());
        assertEquals(w.getTransactions().get(0).getName(), t[0].getName());
        assertEquals(w.getTransactions().get(0).getNum(), t[0].getNum());
        assertEquals(w.getTransactions().get(0).getAmount(), t[0].getAmount(), 0.0001);
        assertEquals(w.getTransactions().get(0).getMisc(), t[0].getMisc());
        assertEquals(w.getTransactions().get(0).getStudent(), t[0].getStudent());

        assertEquals(w.getTransactions().get(1).getCode(), t[1].getCode());
        assertEquals(w.getTransactions().get(1).getName(), t[1].getName());
        assertEquals(w.getTransactions().get(1).getNum(), t[1].getNum());
        assertEquals(w.getTransactions().get(1).getAmount(), t[1].getAmount(), 0.0001);
        assertEquals(w.getTransactions().get(1).getMisc(), t[1].getMisc());
        assertEquals(w.getTransactions().get(1).getStudent(), t[1].getStudent());

        assertEquals(w.getTransactions().get(3).getCode(), t[2].getCode());
        assertEquals(w.getTransactions().get(3).getName(), t[2].getName());
        assertEquals(w.getTransactions().get(3).getNum(), t[2].getNum());
        assertEquals(w.getTransactions().get(3).getAmount(), t[2].getAmount(), 0.0001);
        assertEquals(w.getTransactions().get(3).getMisc(), t[2].getMisc());
        assertEquals(w.getTransactions().get(3).getStudent(), t[2].getStudent());

        assertEquals(w.getTransactions().get(4).getCode(), t[3].getCode());
        assertEquals(w.getTransactions().get(4).getName(), t[3].getName());
        assertEquals(w.getTransactions().get(4).getNum(), t[3].getNum());
        assertEquals(w.getTransactions().get(4).getAmount(), t[3].getAmount(), 0.0001);
        assertEquals(w.getTransactions().get(4).getMisc(), t[3].getMisc());
        assertEquals(w.getTransactions().get(4).getStudent(), t[3].getStudent());
    }
    
	public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(WriterTester.class);
    }
}