/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

public abstract class Alien {
	/*
	 * Abstract class for all creatures containing base information that all inherit.
	 * All aliens are from a planet and are a species using composition.
	 */
	
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private Planet planet;
	private Species species;
	private int commDeviceCode;
	private String galaxyMail;
	
	public Alien(int inID, String inFirstName, String inLastName, String inAddress, String inCity, Planet inPlanet) {
		id = inID;
		firstName = inFirstName;
		lastName = inLastName;
		address = inAddress;
		city = inCity;
		planet = inPlanet;
	}
	
	public int getId() {
		return id;
	}
	public int setId(int id) {
		this.id = id;
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String setFirstName(String firstName) {
		this.firstName = firstName;
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String setLastName(String lastName) {
		this.lastName = lastName;
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String setAddress(String address) {
		this.address = address;
		return address;
	}
	public String getCity() {
		return city;
	}
	public String setCity(String city) {
		this.city = city;
		return city;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public int getCommDeviceCode() {
		return commDeviceCode;
	}
	public int setCommDeviceCode(int commDeviceCode) {
		this.commDeviceCode = commDeviceCode;
		return commDeviceCode;
	}
	public String getGalaxyMail() {
		return galaxyMail;
	}
	public String setGalaxyMail(String galaxyMail) {
		this.galaxyMail = galaxyMail;
		return galaxyMail;
	}

	@Override
	public String toString() {
		return "Alien " + getLastName() + ", " + getFirstName() + " (ID: " + getId() + ")";
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Alien) {
			Alien otherAlien = (Alien) obj;
			return getId()==otherAlien.getId() && getFirstName().equals(otherAlien.getFirstName()) && getLastName().equals(otherAlien.getLastName());
		}
		else {
			return false;
		}
	}
	
}
