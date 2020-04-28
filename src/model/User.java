package model;

public class User {
private String fname;
private String lname;
private String psw;
private String occupation;
private String events;
private String email;
private Long contact;

public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
public String getEvents() {
	return events;
}
public void setEvents(String events) {
	this.events = events;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getContact() {
	return contact;
}
public void setContact(Long contact) {
	this.contact = contact;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}

}
