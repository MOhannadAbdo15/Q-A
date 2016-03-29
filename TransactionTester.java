// package Backend;

/*
* Transaction Tester:
*  
* A series of Junit tests designed to test the functions
* in Transaction.java
*/

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import Backend.*;


public class TransactionTester {

    //Test the getCode function
    @Test
    public void codetest() {
        Transaction t = new Transaction();
        t.setCode("01");
        assertEquals(t.getCode(),"01");
    }

    //Test the getName function
    @Test
    public void nametest() {
        Transaction t = new Transaction();
        t.setName("Alice");
        assertEquals(t.getName(),"Alice");
    }

    //Test the getNum function
    @Test
    public void numtest() {
        Transaction t = new Transaction();
        t.setNum("12345");
        assertEquals(t.getNum(),"12345");
    }

    //Test the getAmount function
    @Test
    public void amounttest() {
        Transaction t = new Transaction();
        t.setAmount(678.99);
        assertEquals(t.getAmount(),678.99,0.001);
    }

    //Test the getMisc function
    @Test
    public void misctest() {
        Transaction t = new Transaction();
        t.setMisc("00");
        assertEquals(t.getMisc(),"00");
    }

    //Test the getStudent function
    @Test
    public void studenttest() {
        Transaction t = new Transaction();
        t.setStudent(true);
        assertEquals(t.getStudent(),true);
    }

    public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(TransactionTester.class);
    }
}