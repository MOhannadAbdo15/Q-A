/*
* Writer Tester:
*  
* A series of Junit tests designed to test the functions
* in Writer.java
*
* Specfically, this tests the constructor's exception
* when it tries to read the master bank accounts.
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
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class WriterEx1 {
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
    public void writerex1test() {
    	String[] args = new String[3];
        //This file does not exist
    	args[0] = "MasterBankAccountNOTREAL.txt";
    	args[1] = "Deposit1.out.txt";
    	args[2] = "Withdrawal1.out.txt";

    	Writer w = new Writer(args);

    	w.write();

    	assertEquals("Error reading file 'MasterBankAccountNOTREAL.txt'\n", outContent.toString());

    }

	public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(WriterEx1.class);
    }

}