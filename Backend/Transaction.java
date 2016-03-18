//Transaction class.
//Each instance of this class should represent one line in a transaction file.
package Backend;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Transaction {

	private String code;
	private String accname;
	private String accnum;
	private double amount;
	private String misc;
	private boolean student;

	//Test method
	public void printTransaction(){
		System.out.println("===Transaction===");
		System.out.println("Code:" + code + ";");
		System.out.println("Accname:" + accname + ";");
		System.out.println("Accnum:" + accnum);
		System.out.println("Amount:" + amount);
		System.out.println("Misc:" + misc);
		System.out.println("Student:" + student);
	}

	public String getCode(){
		return code;
	}

	public void setCode(String newcode){
		code = newcode;
	}

	public String getName(){
		return accname;
	}

	public void setName(String newname){
		accname = newname;
	}

	public String getNum(){
		return accnum;
	}

	public void setNum(String newnum){
		accnum = newnum;
	}

	public double getAmount(){
		return amount;
	}

	public void setAmount(double newamt){
		amount = newamt;
	}

	public String getMisc(){
		return misc;
	}

	public void setMisc(String newmisc){
		misc = newmisc;
	}

	public Boolean getStudent(){
		return student;
	}

	public void setStudent(Boolean newstudent){
		student = newstudent;
	}
}
