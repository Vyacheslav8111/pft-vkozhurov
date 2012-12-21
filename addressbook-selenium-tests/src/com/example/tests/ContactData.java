package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String hometelephone;
	public String mobiletelephone;
	public String worktelephone;
	public String email;
	public String email_2;
	public String secondary_address;
	public String secondary_phone;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	

	public ContactData() {
		
	}
	public ContactData(String firstname, String lastname, String address,
			String hometelephone, String mobiletelephone, String worktelephone,
			String email, String email_2, String birthday, String birthmonth,
			String birthyear, String secondary_address, String secondary_phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.hometelephone = hometelephone;
		this.mobiletelephone = mobiletelephone;
		this.worktelephone = worktelephone;
		this.email = email;
		this.email_2 = email_2;
		this.birthDay = birthyear;
		this.secondary_address = secondary_address;
		this.secondary_phone = secondary_phone;
	}

}