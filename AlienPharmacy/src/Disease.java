import java.util.ArrayList;

public class Disease {
	private int id;
	private String name;
	private String description;
	private ArrayList<Species> affectedSpecies;
	
	public Disease(int inId, String inName, String inDescription, ArrayList<Species> inAffectedSpecies) {
		this.id = inId;
		this.name = inName;
		this.description = inDescription;
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
	
	@Override
	public String toString() {
		return "Disease " + getName() + " " + " (ID: " + getId() + ") : " + getDescription();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Species) {
			Species otherSpecies = (Species) obj;
			return getId()==otherSpecies.getId() && getName()==otherSpecies.getName();
		}
		else {
			return false;
		}
	}
	
	public void spread() {
		System.out.println(getName() + " has spread!");
	}
	
	public void goDormant() {
		System.out.println(getName() + " has gone dormant!");
	}
	
	public void goActive() {
		System.out.println(getName() + " has gone active!");
	}
}
