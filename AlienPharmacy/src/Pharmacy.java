/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

import java.util.*;

// TO DO: add queue for customers in line to be attended to (possibly with a timer)
public class Pharmacy {
	/*
	 * Pharmacies are where Presciptions are filled and where Pharmacists and Employees work.
	 * They exist on a specific Planet and have an ArrayList of employees.
	 * They can hire and fire employees and have sales.
	 */
	private int id;
	private String localName;
	private String address;
	private String city;
	private Planet planet;
	private int commDeviceCode;
	private String galaxyMail;
	private ArrayList<Employee> employees;
	
	public Pharmacy(int inID, String inLocalName, String inAddress, String inCity, Planet inPlanet, ArrayList<Employee> inEmployees) {
		id = inID;
		localName = inLocalName;
		address = inAddress;
		city = inCity;
		planet = inPlanet;
		employees = inEmployees;
	}
	
	
	public int getId() {
		return id;
	}
	public int setId(int id) {
		this.id = id;
		return id;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public int getCommDeviceCode() {
		return commDeviceCode;
	}
	public void setCommDeviceCode(int commDeviceCode) {
		this.commDeviceCode = commDeviceCode;
	}
	public String getGalaxyMail() {
		return galaxyMail;
	}
	public void setGalaxyMail(String galaxyMail) {
		this.galaxyMail = galaxyMail;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		return "Pharmacy " + getLocalName() + " is located at " + getAddress() + " in " + getCity();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pharmacy) {
			Pharmacy otherPharmacy = (Pharmacy) obj;
			return getId()==otherPharmacy.getId() && getAddress() == otherPharmacy.getAddress() && getPlanet() == otherPharmacy.getPlanet();
		}
		else {
			return false;
		}
	}

	// need to look at scope so people off the street aren't hiring pharmacists for places
	public void hire(Employee inEmployee) {
		employees = getEmployees();
		employees.add(inEmployee);
		inEmployee.setPharmacy(this);
		System.out.println(getLocalName() + " has hired " + inEmployee.getClass().getName() + " " + inEmployee.getFirstName() + " " + inEmployee.getLastName());
		// M2 HOMEWORK STATIC
		if (inEmployee.getClass().getName() == "Pharmacist") {
			Pharmacist.decreaseAvailablePharmacistCount();
		}
	}
	
	// TO DO: implement functionality
	public void fire(Employee inEmployee) {
		System.out.println(getLocalName() + " has fired " + inEmployee.getClass().getName() + " " + inEmployee.getFirstName() + " " + inEmployee.getLastName());
		// M2 HOMEWORK STATIC
		if (inEmployee.getClass().getName() == "Pharmacist") {
			Pharmacist.increaseAvailablePharmacistCount();
		}
	}
	
	public void haveSale() {
		System.out.println(getLocalName() + " is having a sale! All medications 20% off!");
	}
}





