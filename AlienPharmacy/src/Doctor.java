/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Doctor extends Alien {
	/*
	 * Doctors are a subclass of Alien that do not work at Pharmacies.
	 * They can diagnose patients and write prescriptions.
	 * Some doctors have been known to write prescriptions for restricted medications for unsavory reasons. 
	 * If this occurs and a patient has adverse affects, they may become banned.
	 */
	private String areaofPractice;
	private boolean isBanned; 
	private Random rand = new Random();
	
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
		// need to make PxId a static incrementing var, for now use Random
		int randPxNum = rand.nextInt(9999-1000)+1000;
		System.out.println("Doctor " + getLastName() + " has written a prescription for " + inPatient.getFirstName() + " " + inPatient.getLastName());
		return new Prescription(randPxNum, stardate, inPatient, this, medications);
	}
	
	public void becomeBanned(Medication inMedication) {
		isBanned = true;
		System.out.println("Doctor " + getLastName() + " has been banned for illicit prescription of " + inMedication.getName() + "!");
	}
	
}