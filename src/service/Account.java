package service;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Account implements Serializable{
	
	private int code;
	private double balance;
	private Date dateCreation;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int code, double balance, Date dateCreation) {
		super();
		this.code = code;
		this.balance = balance;
		this.dateCreation = dateCreation;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@JsonIgnore
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	

}
