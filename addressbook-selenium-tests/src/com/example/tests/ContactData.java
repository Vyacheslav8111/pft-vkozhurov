package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
	public String birthyear;
	
	
	
	
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
    
    
public ContactData() {
		
	}

@Override
public String toString() {
	return "ContactData [firstname=" + firstname + ", lastname=" + lastname
			+ ", email=" + email + ", birthyear=" + birthyear + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	//result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
	//result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
	if (firstname == null) {
		if (other.firstname != null)
			return false;
	} else if (!firstname.equals(other.firstname))
		return false;
	if (lastname == null) {
		if (other.lastname != null)
			return false;
	} else if (!lastname.equals(other.lastname))
		return false;
	return true;
}


@Override
public int compareTo(ContactData other) {
	return this.firstname.compareTo(other.firstname);
}










}



