package com.alamincsme.springboot;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
    @Column(name = "programmer_name")
	private String pName;
	private String pLan;

	public Programmer() {

	}

	public Programmer(int pId, String pName, String pLan) {
		this.pId = pId;
		this.pName = pName;
		this.pLan = pLan;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpLan() {
		return pLan;
	}

	public void setpLan(String pLan) {
		this.pLan = pLan;
	}

	@Override
	public String toString() {
		return "Programmer [pId=" + pId + ", pName=" + pName + ", pLan=" + pLan + "]";
	}

}
