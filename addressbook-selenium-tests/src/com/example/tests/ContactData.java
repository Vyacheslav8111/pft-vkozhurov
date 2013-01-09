package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	
	
    private String firstname;
    private  String lastname;
    private  String address;
    private  String hometelephone;
    private  String mobiletelephone;
    private  String worktelephone;
    private  String email;
    private  String email_2;
    private  String secondary_address;
    private  String secondary_phone;
    private  String birthyear;
    
        
    public ContactData() {
                
        }  
        
        
    public ContactData(String firstname, String lastname, String address,
            String hometelephone, String mobiletelephone, String worktelephone,
            String email, String email_2,String birthyear, String secondary_address, String secondary_phone) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.hometelephone = hometelephone;
    this.mobiletelephone = mobiletelephone;
    this.worktelephone = worktelephone;
    this.email = email;
    this.email_2 = email_2;
    this.birthyear = birthyear;
    this.secondary_address = secondary_address;
    this.secondary_phone = secondary_phone;
        }



	


	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", hometelephone=" + hometelephone
				+ ", mobiletelephone=" + mobiletelephone + ", worktelephone="
				+ worktelephone + ", email=" + email + ", email_2=" + email_2
				+ ", secondary_address=" + secondary_address
				+ ", secondary_phone=" + secondary_phone + ", birthyear="
				+ birthyear + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result	+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}


	@Override
	public int compareTo(ContactData other) {
		return 	
	this.lastname.compareTo(other.lastname);
	

	}


	public ContactData withFirstname(String Firstname) {
		this.firstname = Firstname;
		return this;
	}


	public ContactData withLastname(String Lastname) {
		this.lastname = Lastname;
		return this;
	}


	public ContactData withAddress(String Address) {
		this.address = Address;
		return this;
	}


	public ContactData withHometelephone(String Hometelephone) {
		this.hometelephone = Hometelephone;
		return this;
	}


	public ContactData withMobiletelephone(String Mobiletelephone) {
		this.mobiletelephone = Mobiletelephone;
		return this;
	}


	public ContactData withWorktelephone(String Worktelephone) {
		this.worktelephone = Worktelephone;
		return this;
	}


	public ContactData withEmail(String Email) {
		this.email = Email;
		return this;
	}
	public ContactData withEmail_2(String Email_2) {
		this.email_2 = Email_2;
		return this;
	}

	public ContactData withSecondary_address(String Secondary_address) {
		this.secondary_address = Secondary_address;
		return this;
	}


	public ContactData withSecondary_phone(String Secondary_phone) {
		this.secondary_phone = Secondary_phone;
		return this;
	}


	public ContactData withBirthyear(String Birthyear) {
		this.birthyear = Birthyear;
		return this;
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public String getAddress() {
		return address;
	}


	public String getHometelephone() {
		return hometelephone;
	}


	public String getMobiletelephone() {
		return mobiletelephone;
	}


	public String getWorktelephone() {
		return worktelephone;
	}


	public String getEmail() {
		return email;
	}


	public String getEmail_2() {
		return email_2;
	}


	public String getSecondary_address() {
		return secondary_address;
	}


	public String getSecondary_phone() {
		return secondary_phone;
	}


	public String getBirthyear() {
		return birthyear;
	}


	


	
    
    












}
