package model;

/**
 * The <code>AbstractPerson</code> class represents an abstract person entity.
 * It contains common attributes and methods for customers and employees.
 * 
 * @author Jonas
 * @version 15/12/2023
 * @since 07/12/2023
 */
public abstract class AbstractPerson {
	private String name;
	private String address;
	private String phone;
	private String email;
	
	/**
	 * This method constructs an <code>AbstractPerson</code> object with the provided person <code>name</code>, 
	 * <code>address</code>, <code>phone</code> and <code>email</code>.
	 * 
	 * @param name 		The name associated with the customer or employee.
	 * @param address	The address associated with the customer or employee.
	 * @param phone 	The phone number associated with the customer or employee.
	 * @param email 	The email associated with the customer or employee.
	 */
	public AbstractPerson(String name, String address, String phone, String email) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * This method gets <code>phone</code>.
	 * @return a <code>string</code> representing a phone number.
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * This method sets the phone number associated with this person.
	 * @param phone The <code>phone</code> object linked to this person.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * This method gets <code>name</code>.
	 * @return a <code>string</code> representing an employees or a customers name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method gets <code>address</code>.
	 * @return a <code>string</code> representing an employees or a customers address.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * This method gets <code>email</code>.
	 * @return a <code>string</code> representing an employees or a customers email address.
	 */
	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
