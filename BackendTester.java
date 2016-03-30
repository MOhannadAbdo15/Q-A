// package Backend;

/*
* Backend Tester:
*  
* A series of Junit tests designed to test the functions
* in Backend.java
*/

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.*;
import java.util.*;
import Backend.*;
import java.text.*;
import java.io.*;

public class BackendTester {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    Account a1 = new Account("00001","testaccount1", "A", 123.00, 0, false);
    Account a2 = new Account("00002","testaccount2", "A", 999.45, 0, false);
    Account a3 = new Account("00003","testaccount3", "A", 5999.45, 0, false);
    Account a4 = new Account("00004","testdisabled", "D", 2000.00, 0, false);
    Account a5 = new Account("00005","teststudent", "A", 3000.00, 0, true);
    Account a6 = new Account("00006","testexact", "A", 400.00, 0, false);
    Account a7 = new Account("00007","teststudentexact", "A", 400.00, 0, true);
    Account a8 = new Account("00008","testenough", "A", 300.10, 0, false);
    Account a9 = new Account("00009","testenoughstudent", "A", 300.05, 0, true);

    ArrayList<Account> alist = new ArrayList<Account>();
    ArrayList<Transaction> tlist = new ArrayList<Transaction>();

    @Before 
    public void init(){
        alist.add(a1);    
        alist.add(a2);    
        alist.add(a3);    
        alist.add(a4);    
        alist.add(a5);    
        alist.add(a6);    
        alist.add(a7);    
        alist.add(a8);    
        alist.add(a9); 

        // System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));   
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    //Tests a instantiation of the backend without any transactions
    //to be applied.
    //init will call handletransactions and fully cover the load function.

    @Test
    public void backendtest(){
        Backend b2 = new Backend();
        String[] args = new String[1];
        args[0] = "MasterBankAccounts.txt";
        // args[1] = "Deposit1.out.txt";
        // args[2] = "Withdrawal1.out.txt";

        // tlist.clear();
        // b2.setTransactions(tlist);
        // b2.setAccounts(alist);
        b2.init(args);

        //Assert all the variables of all the accounts
        for (int i = 0;i < 9; i++) {
            assertEquals(b2.getAccounts().get(i).getNum(),alist.get(i).getNum());
            assertEquals(b2.getAccounts().get(i).getName(),alist.get(i).getName());
            assertEquals(b2.getAccounts().get(i).getStatus(),alist.get(i).getStatus());
            assertEquals(b2.getAccounts().get(i).getBalance() , alist.get(i).getBalance(), 0.001);
            assertEquals(b2.getAccounts().get(i).getTransactions(),alist.get(i).getTransactions());
            assertEquals(b2.getAccounts().get(i).getStudent(),alist.get(i).getStudent());
            assertEquals(b2.getAccounts().get(i).getCreated(),false);
            assertEquals(b2.getAccounts().get(i).getFrozen(),alist.get(i).getFrozen(), 0.001);
        }
    }

    //Test the apply login transaction when not logged in
    // @Test
    // public void notlogintest() { 
    //     Backend b = new Backend();
    //     String[] args = new String[1];
    //     args[0] = "MasterBankAccounts.txt";

    //     tlist.clear();

    //     Transaction t = new Transaction();
    //     t.setCode("10");
    //     t.setMisc("S");
    //     t.setName("");

    //     Transaction t2 = new Transaction();
    //     t2.setCode("10");
    //     t2.setMisc("S");
    //     t2.setName("");

    //     tlist.add(t);
    //     tlist.add(t2);

    //     b.load(args,b.getAccounts());
    //     b.setTransactions(tlist);
    //     b.handletransactions(b.getAccounts());
    //     assertEquals("ERROR: Log in transaction when logged in already\n", outContent.toString());
    // }

    public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(BackendTester.class);
    }
}