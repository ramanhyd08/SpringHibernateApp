package com.dineshonjava.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="LoginDetail")
public class LoginBean  implements Serializable{
	
	
	private static final long serialVersionUID = -723583058586873479L;
	 
	  @Column(name="userName")
	  private String userName;
	  @Column(name="password")
	  private String password;
	  @Column(name="userRole")
	  private String userRole;
	 
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "userID")
	  private int userID;
	  
	  
	  public int getUserID() {
			return userID;
		}

		public void setUserID(int userID) {
			this.userID = userID;
		}

	  public String getUserName() {
	    return userName;
	  }

	  public void setUserName(String userName) {
	    this.userName = userName;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	}