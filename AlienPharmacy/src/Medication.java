import java.util.*;

public class Medication {
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
			return getId()==otherMedication.getId() && getContraindications() == otherMedication.getContraindications();
		}
		else {
			return false;
		}
	}
}
