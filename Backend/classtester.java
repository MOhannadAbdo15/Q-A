package Backend;

import Backend.Account;
import java.util.*;
import java.lang.*;
import java.io.*;

class classtester {

	public static void main(String[] args) {
		System.out.println("classtester");
		Account bob = new Account("00001", "Robert", "A", 100.00, 0, true);
		bob.printAccount();
		// bob.setName("bob");
		// System.out.println(bob.getName());
	}
	
}