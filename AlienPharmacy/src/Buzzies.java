/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

import java.util.ArrayList;

public class Buzzies extends RestrictedMedication {
	/*
	 * Buzzies are known to form dependency and are thus a regulated medication.
	 * Buzzies can cause an overdose, but do have an antidote.
	 */
	private Medication antidote;
	
	public Buzzies(int inId, String inName, String inDescription, ArrayList<Medication> inContraindications, int inLevel, Medication inAntidote) {
		super(inId, inName, inDescription, inContraindications, inLevel);
		this.antidote = inAntidote;
	}
		
	public Medication getAntidote() {
		return antidote;
	}
	public void setAntidote(Medication antidote) {
		this.antidote = antidote;
	}

	@Override
	public String toString() {
		return "Buzzy " + super.getName() + " (ID: " + super.getId() + "): " + super.getDescription();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Medication) {
			Buzzies otherBuzzies = (Buzzies) obj;
			return super.equals(obj) && getAntidote()==otherBuzzies.getAntidote();
		}
		else {
			return false;
		}
	}

	// TO DO: make these methods unique, possibly cause side effects, etc.
	public void causeAddiction() {
		System.out.println("This patient is now dependent on Buzzies!");
	}

	public void causeOverdose() {
		System.out.println("This patient has overdosed on Buzzies!");
	}
	
	public void becomeNeutralized() {
		System.out.println("This patient has been brought back from the brink by an antidote!");
	}
	
	
}
