import java.util.ArrayList;

public class Patient extends Alien {
	private int insuranceId;
	private int[] medAllergies;
	
	public Patient(int inID, String inFirstName, String inLastName, String inAddress, String inCity, Planet inPlanet, Species inSpecies, int inInsuranceId, int[] inMedAllergies) {
		super(inID, inFirstName, inLastName, inAddress, inCity, inPlanet);
		super.setSpecies(inSpecies);
		this.insuranceId = inInsuranceId;
		this.medAllergies = inMedAllergies;
	}
		
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public int[] getMedAllergies() {
		return medAllergies;
	}
	public void setMedAllergies(int[] medAllergies) {
		this.medAllergies = medAllergies;
	}
	
	@Override
	public String toString() {
		return "Patient " + super.getLastName() + ", " + super.getFirstName() + " (ID: " + getId() + ") is from " + getPlanet().getName() + " and has insurance number " + getInsuranceId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Alien) {
			Patient otherPatient = (Patient) obj;
			return super.equals(obj) && getInsuranceId()==otherPatient.getInsuranceId();
		}
		else {
			return false;
		}
	}
	
	public void check_in(Pharmacy inPharmacy) {
		System.out.println(getFirstName() + " " + getLastName() + " has checked in at " + inPharmacy.getLocalName());
	}
	
	public void buy_medication(Medication inMedication, int quantity) {
		System.out.println(getFirstName() + " " + getLastName() + " has bought " + quantity + " units of " + inMedication.getName());
	}
	
	public void take_medication(Medication inMedication) {
		System.out.println(getFirstName() + " " + getLastName() + " has taken " + inMedication.getName());
	}
}
