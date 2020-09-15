/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

import java.util.Random;

public class Planet {
	// M2 HOMEWORK ENUM
	public enum PlanetMass {
		DENSE("D"), NORMAL("N"), LOOSE("L");
		
		private String pMass;
		
		private PlanetMass(String pMass) {
			this.pMass = pMass;
		}
		
		public String getPmass() {
			return pMass;
		}
	};
	public enum Terraform {VOLCANIC("VLC"), AQUATIC("AQC"), ARBOREAL("ARB"), NAXXOUS("NAX"), ETHEREAL("ETH");
		
		private String tForm;
		
		private Terraform(String tForm) {
			this.tForm = tForm;
		}
		
		public String getTform() {
			return tForm;
		}
	};
	
	private int id;
	private String name;
	private String description;
	// M2 HOMEWORK ENUM
	private PlanetMass planetMass;
	private Terraform terraform;

	// M2 HOMEWORK ENUM
	public Planet(int inId, String inName, String inDescription, PlanetMass inPlanetMass, Terraform inTerraform) {
		/*
		 * Planets are entities which help identify the location of Pharmacies and Aliens.
		 * They have names and descriptions.
		 */
		this.id = inId;
		this.name = inName;
		this.description = inDescription;
		this.planetMass = inPlanetMass;
		this.terraform = inTerraform;
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
	// M2 HOMEWORK ENUM
	public PlanetMass getPlanetMass() {
		return planetMass;
	}
	public Terraform getTerraform() {
		return terraform;
	}

	
	// M2 HOMEWORK ENUM USE
	@Override
	public String toString() {
		return "Planet " + getName() + " CLASS " + planetMass.getPmass() + terraform.getTform() + getId() + " : " + getDescription();
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
