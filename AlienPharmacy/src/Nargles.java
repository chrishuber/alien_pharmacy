import java.util.ArrayList;

public class Nargles extends RestrictedMedication {
	private Medication antidote;
	
	public Nargles(int inId, String inName, String inDescription, ArrayList<Medication> inContraindications, int inLevel, Medication inAntidote) {
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
		return "Nargles " + super.getName() + " (ID: " + super.getId() + "): " + super.getDescription();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Medication) {
			Nargles otherNargles = (Nargles) obj;
			return super.equals(obj) && getAntidote()==otherNargles.getAntidote();
		}
		else {
			return false;
		}
	}
	
	public void causeAddiction() {
		System.out.println("This patient is now addicted to Nargles!");
	}

	public void causeOverdose() {
		System.out.println("This patient has overdosed on Nargles!");
	}
	
	public void becomeNeutralized() {
		System.out.println("This patient has been brought back from the brink by an antidote!");
	}
}