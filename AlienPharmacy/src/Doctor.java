import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Alien {
	private String areaofPractice;
	private boolean isBanned; 

	public Doctor(int inID, String inFirstName, String inLastName, String inAddress, String inCity, Planet inPlanet, String areaofPractice, boolean isBanned) {
		super(inID, inFirstName, inLastName, inAddress, inCity, inPlanet);
		this.areaofPractice = areaofPractice;
		this.isBanned = isBanned;
	}
	
	public String getAreaofPractice() {
		return areaofPractice;
	}
	public void setAreaofPractice(String areaofPractice) {
		this.areaofPractice = areaofPractice;
	}
	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	@Override
	public String toString() {
		return "Doctor " + super.getLastName() + ", " + super.getFirstName() + " (ID: " + getId() + ") treats " + getAreaofPractice();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Alien) {
			Doctor otherDoctor = (Doctor) obj;
			return super.equals(obj) && getAreaofPractice()==otherDoctor.getAreaofPractice();
		}
		else {
			return false;
		}
	}

	public void diagnosePatient(Patient inPatient, Disease inDisease) {
		System.out.println("Patient " + inPatient.getLastName() + " has been diagnosed with " + inDisease.getName() + " by Dr. " + getLastName());
	}
	
	public Prescription writePx(Patient inPatient, ArrayList<Medication> medications) {
		Date stardate = new Date();
		// need to make PxId a static incrementing var
		System.out.println("Doctor " + getLastName() + " has written a prescription for " + inPatient.getFirstName() + " " + inPatient.getLastName());
		return new Prescription(5678, stardate, inPatient, this, medications);
	}
	
	public void getBanned(Medication inMedication) {
		isBanned = true;
		System.out.println("Doctor " + getLastName() + " has been banned for illicit prescription of " + inMedication.getName() + "!");
	}
	
}