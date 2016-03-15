package Backend;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Transaction {

	private String code;
	private String accname;
	private String accnum;
	private float amount;
	private String misc;
	private boolean student;

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

	public Float getAmount(){
		return amount;
	}

	public void setAmount(String newamt){
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
		code = newcode;
	}
}
