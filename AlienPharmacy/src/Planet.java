import java.util.Random;

public class Planet {
	private int id;
	private String name;
	private String description;
	
	public Planet(int inId, String inName, String inDescription) {
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
		return "Planet " + getName() + " " + " (ID: " + getId() + ") : " + getDescription();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Planet) {
			Planet otherPlanet = (Planet) obj;
			return getId()==otherPlanet.getId() && getName()==otherPlanet.getName();
		}
		else {
			return false;
		}
	}
	
	public void haveOutbreak(Disease inDisease) {
		System.out.println("Planet " + getName() + " is having an outbreak of " + inDisease.getName() + "!");
	}
		
	public void produceEmployee() {
		System.out.println("Planet " + getName() + " has just produced a new Employee! They are ready for hire.");
	}

	public void graduatePharmacist() {
		Random rand = new Random();
		int auth_level = rand.nextInt(4) + 1;
		System.out.println("Planet " + getName() + " has just graduated a new Pharmacist! They have auth level " + auth_level + " and are ready for hire!");
	}
	
}
