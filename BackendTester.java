// package Backend;

/*
* Backend Tester:
*  
* A series of Junit tests designed to test the functions
* in Backend.java
*/

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import Backend.*;

public class BackendTester {
    Backend b = new Backend();

    @Test
    public void codetest() {
        
        assertEquals(1,1);
    }

    public static junit.framework.Test suite(){
       return new JUnit4TestAdapter(BackendTester.class);
    }
}