// package Backend;

/*
* Acconut Tester:
*  
* A series of Junit tests designed to test the functions
* in Account.java
*/

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import Backend.*;


public class AccountTester {

    //Test the getNum function
    @Test
    public void numtest() {
        Account a = new Account();
        a.setNum("12345");
        assertEquals(a.getNum(),"12345");
    }

    //Test the getName function
    @Test
    public void nametest() {
        Account a = new Account();
        a.setName("Alice");
        assertEquals(a.getName(),"Alice");
    }

    //Test the getStatus function
    @Test
    public void statustest() {
        Account a = new Account();
        a.setStatus("D");
        assertEquals(a.getStatus(),"D");
    }

    //Test the getBalance function
    @Test
    public void balancetest() {
        Account a = new Account();
        a.setBalance(678.99);
        assertEquals(a.getBalance(),678.99,0.001);
    }

    //Test the getFrozen function
    @Test
    public void frozentest() {
        Account a = new Account();
        a.setFrozen(678.99);
        assertEquals(a.getFrozen(),678.99,0.001);
    }

    //Test the getCreated function
    @Test
    public void createdtest() {
        Account a = new Account();
        a.setCreated(true);
        assertEquals(a.getCreated(),true);
    }

    //Test the getStudent function
    @Test
    public void studenttest() {
        Account a = new Account();
        a.setStudent(true);
        assertEquals(a.getStudent(),true);
    }

    //Test the getTransactions function
    @Test
    public void transactionstest() {
        Account a = new Account();
        a.setTransactions(11);
        assertEquals(a.getTransactions(),11);
    }

    public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(AccountTester.class);
    }
}