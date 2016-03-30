/*
* Validator Tester:
*  
* A series of Junit tests designed to test the functions
* in Validator.java
*/


import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import Backend.*;
import java.util.*;

public class ValidatorTester {

    //Test the sessionLoggedIn function
    @Test
    public void sessionloggedtest() {
        //Test both true and false returns
        Validator v = new Validator();
        assertEquals(v.sessionLoggedIn(true), true);
        assertEquals(v.sessionLoggedIn(false), false);
    }

    //Test the findAccount function
    @Test
    public void findaccounttest() {
        //Test multiple loops through findAccount
        Validator v = new Validator();
        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();
        ArrayList<Account> alist = new ArrayList<Account>();

        a1.setNum("1");
        a2.setNum("10");
        a3.setNum("25");

        alist.add(a1);
        alist.add(a2);
        alist.add(a3);

        assertEquals(v.findAccount("1",alist),a1);
        assertEquals(v.findAccount("10",alist),a2);
        assertEquals(v.findAccount("25",alist),a3);
        assertEquals(v.findAccount("26",alist),null);
    }


    //Test 0 loops through findAccount
    @Test
    public void findaccounttestzeroloops() {
        Validator v = new Validator();
        ArrayList<Account> alist = new ArrayList<Account>();

        assertEquals(v.findAccount("1",alist),null);
    }

    //Test single loop through findAccount
    @Test
    public void findaccounttestsingleloop() {
        Validator v = new Validator();
        Account a1 = new Account();
        ArrayList<Account> alist = new ArrayList<Account>();

        a1.setNum("1");

        alist.add(a1);

        assertEquals(v.findAccount("1",alist),a1);
    }

    //Test two loops through findAccount
    @Test
    public void findaccounttesttwoloops() {
        Validator v = new Validator();
        Account a1 = new Account();
        Account a2 = new Account();
        ArrayList<Account> alist = new ArrayList<Account>();

        a1.setNum("1");
        a2.setNum("10");

        alist.add(a1);
        alist.add(a2);

        assertEquals(v.findAccount("10",alist),a2);
    }

    //Test many loops through findAccount
    @Test
    public void findaccounttestmanyloops() {
        Validator v = new Validator();
        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();
        ArrayList<Account> alist = new ArrayList<Account>();

        a1.setNum("1");
        a2.setNum("10");
        a3.setNum("5");

        alist.add(a1);
        alist.add(a2);
        alist.add(a3);

        assertEquals(v.findAccount("10",alist),a2);
    }

    //Test the findNextNumber function
    @Test
    public void findnextnumbertest() {
        //Test multiple loops through findNextNumber
        Validator v = new Validator();
        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();
        ArrayList<Account> alist = new ArrayList<Account>();

        a1.setNum("1");
        a2.setNum("10");
        a3.setNum("25");

        alist.add(a1);
        alist.add(a2);
        alist.add(a3);

        assertEquals(v.findNextNumber(alist),"26");
    }


    //Test 0 loops through findNextNumber
    @Test
    public void findnextnumbertestzeroloops() {
        Validator v = new Validator();
        ArrayList<Account> alist = new ArrayList<Account>();

        assertEquals(v.findNextNumber(alist),"1");
    }

    //Test single loop through findNextNumber
    @Test
    public void findnextnumbertestsingleloop() {
        Validator v = new Validator();
        Account a1 = new Account();
        ArrayList<Account> alist = new ArrayList<Account>();

        a1.setNum("1");

        alist.add(a1);

        assertEquals(v.findNextNumber(alist),"2");
    }

    //Test two loops through findNextNumber
    @Test
    public void findnextnumbertesttwoloops() {
        Validator v = new Validator();
        Account a1 = new Account();
        Account a2 = new Account();
        ArrayList<Account> alist = new ArrayList<Account>();

        a1.setNum("1");
        a2.setNum("10");

        alist.add(a1);
        alist.add(a2);

        assertEquals(v.findNextNumber(alist),"11");
    }

    //Test the accountJustCreated function
    @Test
    public void accountjustcreatedtest() {
        Validator v = new Validator();
        Account a = new Account();
        Account a2 = new Account();
        a.setCreated(false);
        a2.setCreated(true);
        assertEquals(v.accountJustCreated(a),false);
        assertEquals(v.accountJustCreated(a2),true);
    }

    //Test the accountMatchName function
    //Testing both true and false sides
    @Test
    public void accountmatchnametest() {
        Validator v = new Validator();
        Account a = new Account();
        a.setName("Alice");
        assertEquals(v.accountMatchName("Alice", a), true);
        assertEquals(v.accountMatchName("Bob", a), false);
    }

    //Test the enoughBalance function
    //Testing both true and false sides
    @Test
    public void enoughbalancetest() {
        Validator v = new Validator();
        Account a = new Account();
        a.setBalance(123.00);
        assertEquals(v.enoughBalance(120.00,a),true);
        assertEquals(v.enoughBalance(123.00,a),true);
        assertEquals(v.enoughBalance(124.00,a),false);
    }

    //Test the checkCompany function
    @Test
    public void checkcompanytest() {
        Validator v = new Validator();
        //Check all the ways we can return true plus 
        //one false
        assertEquals(v.checkCompany("EC"),true);
        assertEquals(v.checkCompany("CQ"),true);
        assertEquals(v.checkCompany("TV"),true);
        assertEquals(v.checkCompany("AL"),false);
    }

    public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(ValidatorTester.class);
    }
}