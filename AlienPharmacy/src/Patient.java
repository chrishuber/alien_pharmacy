/* 
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

import java.util.ArrayList;

public class Patient extends Alien {
	/*
	 * Patients are a subclass of Alien that do not work at Pharmacies.
	 * They can be diagnosed with Diseases by a Doctor and be written Prescriptions.
	 * They can check in at Pharmacies with Prescriptions, buy Medications, and take Medications.
	 */
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
	
	public void checkIn(Pharmacy inPharmacy) {
		System.out.println(getFirstName() + " " + getLastName() + " has checked in at " + inPharmacy.getLocalName());
	}
	
	public void buyMedication(Medication inMedication, int quantity) {
		System.out.println(getFirstName() + " " + getLastName() + " has bought " + quantity + " units of " + inMedication.getName());
	}
	
	public void takeMedication(Medication inMedication) {
		System.out.println(getFirstName() + " " + getLastName() + " has taken " + inMedication.getName());
	}
}
