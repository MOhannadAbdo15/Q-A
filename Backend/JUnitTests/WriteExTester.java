/*
* Writer Tester:
*  
* A series of Junit tests designed to test write function
* in Writer.java. Specifically tests the exception catch 
* for this test, the file "NewMasterBankAccounts.txt"
* had locked write privleges, so the write function
* throws an exception. This test will still pass
* if that file's permissions are normal.
*/

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.*;
import Backend.*;
import java.lang.*;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class WriteExTester {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before 
    public void init(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));   
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

	@Test
    public void writeextest() {
    	String[] args = new String[3];
    	args[0] = "MasterBankAccounts.txt";
    	args[1] = "Deposit1.out.txt";
    	args[2] = "Withdrawal1.out.txt";

    	Writer w = new Writer(args);

    	w.write();

    	assertEquals("Error reading file\n", outContent.toString());

    }

	public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(WriteExTester.class);
    }

}