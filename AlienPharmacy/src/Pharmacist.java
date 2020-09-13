/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

public class Pharmacist extends Employee {
	/*
	 * Pharmacists are a specialized Employee class that work at Pharmacies.
	 * They can fill prescriptions and check patient records for contraindications.
	 * They have authorization levels which allow them to prescibe certain restricted 
	 * meds and which affect their salary.
	 */
	private Pharmacy pharmacy;
	private int authorizationLevel;
	
	// M2 HOMEWORK STATIC
	private static int availablepharmacistCount;

	public Pharmacist(int inID, String inFirstName, String inLastName, String inAddress, String inCity, Planet inPlanet, int inSalary, Pharmacy inPharmacy, int inAuthorizationLevel) {
		super(inID, inFirstName, inLastName, inAddress, inCity, inPlanet);
		super.setSalary(inSalary);
		this.pharmacy = inPharmacy;
		this.authorizationLevel = inAuthorizationLevel;
		if (inPharmacy == null)
			availablepharmacistCount++;
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

	// M2 HOMEWORK STATIC
	public static void increaseAvailablePharmacistCount() {
		availablepharmacistCount++;
	}

	public static void decreaseAvailablePharmacistCount() {
		availablepharmacistCount--;
	}
	
	public static void displayAvailablePharmacistCount() {
		if (availablepharmacistCount == 0) {
			System.out.println("There are no pharmacists available for hire.");
		}
		else if (availablepharmacistCount == 1) {
			System.out.println("There is one pharmacist available for hire.");
		}
		else {
			System.out.println("There are " + availablepharmacistCount + " pharmacists available for hire.");
		}
	}
	
	// TO DO: implement logic to check contraindications
	public void verifyPxMeds(Prescription inPx) {
		System.out.println("Pharmacist " + getLastName() + " is checking Prescription " + inPx.getPxId() + " for contraindications...");
	}
	
	public void fillPx(Prescription inPx) {
		System.out.println("Pharmacist " + getLastName() + " has filled Prescription " + inPx.getPxId());
	}
	
	public void rejectPx(Prescription inPx) {
		System.out.println("Pharmacist " + getLastName() + " has declined to fill Prescription " + inPx.getPxId());
	}
}
