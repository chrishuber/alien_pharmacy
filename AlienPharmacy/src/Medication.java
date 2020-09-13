/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

import java.util.*;

public class Medication implements Comparable<Medication> {
	/*
	 * Medication is a generic class for all medications which is used for most drugs.
	 * Each medication contains an ArrayList of other medications it is contraindicated against.
	 */
	private int id;
	private String name;
	private ArrayList<Medication> contraindications;
	private String description;
	
	public Medication(int inId, String inName, String inDescription, ArrayList<Medication> inContraindications) {
		this.id = inId;
		this.name = inName;
		this.description = inDescription;
		this.contraindications = inContraindications;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Medication> getContraindications() {
		return contraindications;
	}
	public void setContraindications(ArrayList<Medication> contraindications) {
		this.contraindications = contraindications;
	}
	
	@Override
	public String toString() {
		return "Medication " + getName() + " (ID: " + getId() + "): " + getDescription();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Medication) {
			Medication otherMedication = (Medication) obj;
			return getId()==otherMedication.getId() && getContraindications().equals(otherMedication.getContraindications());
		}
		else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Medication inMed) {
		if (id > inMed.id) {
			return 1;
		}
		else if (id < inMed.id) {
			return -1;
		}
		return 0;
	}
}
