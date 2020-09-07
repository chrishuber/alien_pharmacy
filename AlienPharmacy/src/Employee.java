
public class Employee extends Alien {
	private Pharmacy pharmacy;
	private int salary;
		
	public Employee(int inID, String inFirstName, String inLastName, String inAddress, String inCity, Planet inPlanet, int inSalary, Pharmacy inPharmacy) {
		super(inID, inFirstName, inLastName, inAddress, inCity, inPlanet);
		this.salary = inSalary;
		this.pharmacy = inPharmacy;
	}
	
	public Employee(int inID, String inFirstName, String inLastName, String inAddress, String inCity, Planet inPlanet) {
		super(inID, inFirstName, inLastName, inAddress, inCity, inPlanet);
	}
	
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		// using ternary clause to get around non-declaration error caused by if-else statement
		String local_name = pharmacy == null ? "a location near you soon" : pharmacy.getLocalName();
		return "Employee " + super.getLastName() + ", " + super.getFirstName() + " (ID: " + getId() + ") works at " + local_name + " and makes " + getSalary() + " credits per solar cycle";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Alien) {
			Employee otherEmployee = (Employee) obj;
			return super.equals(obj) && getSalary()==otherEmployee.getSalary();
		}
		else {
			return false;
		}
	}
	
	public void turnLightsOn() {
		System.out.println("Employee " + getFirstName() + " " + getLastName() + " has turned the lights on.");
	}
	
	public void sweepFloor() {
		System.out.println("Employee " + getFirstName() + " " + getLastName() + " has swept the floor.");
	}
	
	public void emptyTrash() {
		System.out.println("Employee " + getFirstName() + " " + getLastName() + " has emptied the trash.");
	}
}
