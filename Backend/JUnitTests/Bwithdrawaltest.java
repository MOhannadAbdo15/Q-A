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

public class Bwithdrawaltest {
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

    //Test the apply login transaction when not logged in
    @Test
    public void withdrawaltest() { 
        Backend b = new Backend();
        String[] args = new String[1];
        args[0] = "MasterBankAccounts.txt";
        b.load(args);

        tlist.clear();

        Transaction t = new Transaction();
        t.setCode("10");
        t.setMisc("A");
        t.setName("");

        Transaction t2 = new Transaction();
        t2.setCode("01");
        t2.setMisc("S");
        t2.setName("testaccount1");
        t2.setNum("00001");
        t2.setAmount(100.00);

        Transaction t3 = new Transaction();
        t3.setCode("00");

        tlist.add(t);
        tlist.add(t2);
        tlist.add(t3);

        b.setTransactions(tlist);
        b.handletransactions();

        assertEquals(b.getAccounts().get(0).getBalance(),23.00,0.001);
    }

    public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(BackendTester.class);
    }
}