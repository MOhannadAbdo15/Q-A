/*
* Writer Tester:
*  
* A series of Junit tests designed to test write function
* in Writer.java
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

public class WriteTester {


	@Test
    public void writeconstructortest() {
    	String[] args = new String[3];
    	args[0] = "MasterBankAccounts.txt";
    	args[1] = "Deposit1.out.txt";
    	args[2] = "Withdrawal1.out.txt";

    	Writer w = new Writer(args);

    	w.write();

    	try{

	    	FileReader fileReader = new FileReader("NewMasterBankAccounts.txt");
	    	BufferedReader bufferedReader = new BufferedReader(fileReader);

	    	String line;
	    	assertEquals("00001 testaccount1        A 00123.00 0000 N",bufferedReader.readLine());
	    	assertEquals("00002 testaccount2        A 00999.45 0000 N",bufferedReader.readLine());
	    	assertEquals("00003 testaccount3        A 05999.45 0000 N",bufferedReader.readLine());
	    	assertEquals("00004 testdisabled        D 02000.00 0000 N",bufferedReader.readLine());
	    	assertEquals("00005 teststudent         A 03000.00 0000 S",bufferedReader.readLine());
	    	assertEquals("00006 testexact           A 00400.00 0000 N",bufferedReader.readLine());
	    	assertEquals("00007 teststudentexact    A 00400.00 0000 S",bufferedReader.readLine());
	    	assertEquals("00008 testenough          A 00300.10 0000 N",bufferedReader.readLine());
	    	assertEquals("00009 testenoughstudent   A 00300.05 0000 S",bufferedReader.readLine());
	    	System.out.println(line);
    	}catch (IOException ex){
    		System.out.println("IOException");
    	}

    }

	public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(WriteTester.class);
    }

}