
public class Species {
	private int id;
	private String name;
	private String description;

	public Species(int inId, String inName, String inDescription) {
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
		return "Species " + getName() + " " + " (ID: " + getId() + ") : " + getDescription();
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
	
	public void developImmunity(Disease inDisease) {
		System.out.println(getName() + " has developed immunity to " + inDisease.getName() + "!");
	}

	public void developVulnerability(Disease inDisease) {
		System.out.println(getName() + " has developed vulnerability to " + inDisease.getName() + "!");
	}

	public void goExtinct() {
		System.out.println(getName() + " has gone extinct!");
	}
}