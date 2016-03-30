// package Backend;

/*
* A test for the create function.
*/

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.*;
import java.util.*;
import Backend.*;
import java.text.*;
import java.io.*;

public class createtest {
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
    Account a10 = new Account("00010","newtest", "A", 300, 0, false);

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
        alist.add(a10); 

        // System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));   
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    //Test the create function
    @Test
    public void createtest(){
        Backend b2 = new Backend();
        String[] args = new String[1];
        args[0] = "MasterBankAccounts.txt";

        Transaction t = new Transaction();
        t.setCode("10");
        t.setMisc("A");
        t.setName("");

        tlist.add(t);

        Transaction t2 = new Transaction();
        t2.setCode("05");
        t2.setName("newtest");
        t2.setAmount(300);

        tlist.add(t2);

        Transaction t3 = new Transaction();
        t3.setCode("00");

        tlist.add(t3);

        b2.load(args);
        b2.setTransactions(tlist);
        b2.handletransactions();

        // Assert all the variables of all the accounts
        for (int i = 0;i < alist.size(); i++) {
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

    public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(createtest.class);
    }
}