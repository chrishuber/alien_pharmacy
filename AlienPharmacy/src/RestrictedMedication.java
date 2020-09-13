/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

import java.util.ArrayList;

public class RestrictedMedication extends Medication {
	/*
	 * This is an umbrella class for all Regulated Medications.
	 */
	private int level;		// level of restriction: may require pharmacist auth key
	
	public RestrictedMedication(int inId, String inName, String inDescription, ArrayList<Medication> inContraindications, int inLevel) {
		super(inId, inName, inDescription, inContraindications);
		this.level = inLevel;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Restricted Medication " + getName() + " (ID: " + getId() + "): " + getDescription() + " Requires level " + getLevel() + " clearance.";
	}

	/* Would like to compare levels and then write a method to display all restricted medications by level sorted by alpha name
	@Override
	public int compareTo(Medication inMed) {
		if (inMed instanceof RestrictedMedication) {
			if (level > inMed.level) {
				return 1;
			}
			else if (level < inMed.level) {
				return -1;
			}
			return 0;
		}
		else {
			super.compareTo(inMed);
		}
	}
	*/
}
