package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class StudentDTO {
	
	
	private String studentName;
	private String batchCode;
	private int totalClass;
	private int attendedClass;
	private Timestamp timestamp;
	private String divison;
	private int studentId;
	private int userID;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getDivison() {
		return divison;
	}
	public void setDivison(String divison) {
		this.divison = divison;
	}
	//this keyword is used to avoid confirmation
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	

	
	public int getTotalClass() {
		return totalClass;
	}
	public void setTotalClass(int totalClass) {
		this.totalClass = totalClass;
	}
	
	public int getAttendedClass() {
		return attendedClass;
	}
	public void setAttendedClass(int attendedClass) {
		this.attendedClass = attendedClass;
	}
}
