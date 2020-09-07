
public class Pharmacist extends Employee {
	private Pharmacy pharmacy;
	private int authorizationLevel;

	public Pharmacist(int inID, String inFirstName, String inLastName, String inAddress, String inCity, Planet inPlanet, int inSalary, Pharmacy inPharmacy, int inAuthorizationLevel) {
		super(inID, inFirstName, inLastName, inAddress, inCity, inPlanet);
		super.setSalary(inSalary);
		this.pharmacy = inPharmacy;
		this.authorizationLevel = inAuthorizationLevel;
	}
	
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	
	public int getAuthorizationLevel() {
		return authorizationLevel;
	}

	public void setAuthorizationLevel(int authorizationLevel) {
		this.authorizationLevel = authorizationLevel;
	}
	
	@Override
	public String toString() {
		// using ternary clause to get around non-declaration error caused by if-else statement
		String local_name = pharmacy == null ? "a location near you soon" : pharmacy.getLocalName();
		return "Pharmacist " + super.getLastName() + ", " + super.getFirstName() + " (ID: " + getId() + ") works at " + local_name + " and has authorization level " + getAuthorizationLevel();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Alien) {
			Pharmacist otherPharmacist = (Pharmacist) obj;
			return super.equals(obj) && getAuthorizationLevel()==otherPharmacist.getAuthorizationLevel();
		}
		else {
			return false;
		}
	}
	
}
