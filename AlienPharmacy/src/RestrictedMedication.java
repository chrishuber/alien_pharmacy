import java.util.ArrayList;

public class RestrictedMedication extends Medication {
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
}
