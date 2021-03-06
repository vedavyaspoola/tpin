package com.cts.tpin.dbo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="tpin")
public class TpinDbo {
	
	@Id
	@Column(name="Mobile_Number")
	private String mobileNumber;
	
	@Column(name="Email")
	private String email;
	
	
	@Column(name="Tpin")
	private String tpin;
	
	@Column(name="Comments")
	private String Comments;
	
	@Column(name="TimeStamp")
	private Timestamp startDate;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTpin() {
		return tpin;
	}

	public void setTpin(String tpin) {
		this.tpin = tpin;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "TpinDbo [mobileNumber=" + mobileNumber + ", email=" + email + ", tpin=" + tpin + ", Comments="
				+ Comments + ", startDate=" + startDate + "]";
	}
	
	

}
