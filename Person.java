import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private int pNumber;
	private String dob;
	private String email;
	
	Person(String name, int pNumber, String dob, String email) {
		this.name = name;
		this.pNumber = pNumber;
		this.dob = dob;
		this.email = email;
	}
	
	// Getter/Setter for attributes
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getpNumber() {
	return pNumber;}
	public void setpNumber(int pNumber) {this.pNumber = pNumber;}
	public String getDob() {return dob;}
	public void setDob(String dob) {this.dob = dob;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;
	
	}
	@Override
	public String toString() {
		return "Person [Name:" + name + ", Phone number:" + pNumber + ", Date of birth:" + dob + ", E-mail=" + email + "]";
	}
}


