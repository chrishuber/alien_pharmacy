/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/07/2020
 * Assignment One: Class Design
 */

import java.util.*;

public class AlienPharmacyDriver {
	public static void main(String[] args) {
		/* INITIALIZATIONS */
		System.out.println("------------------------");
		System.out.println("STARTING INITIALIZATIONS");
		System.out.println("------------------------");
		
		// instantiate a Planet
		// M2 HOMEWORK ENUM
		// "We all come from somewhere. We carry that place with us wherever we go." -Saru, Star Trek: Discovery
		Planet planet_01 = new Planet(1, "Iferysia", "A hot desert world populated with sandworms and rock creatures.", Planet.PlanetMass.NORMAL, Planet.Terraform.VOLCANIC);
		System.out.println(planet_01);
		
		// instantiate another Planet
		Planet planet_02 = new Planet(2, "Al'Samik", "An aquatic world teeming with hundreds of species and many cross-species diseases.", Planet.PlanetMass.DENSE, Planet.Terraform.AQUATIC);
		System.out.println(planet_02);
		
		// M3 USING BUILDER
		// instantiate a Species
		Species species_01 = new Species.SpeciesBuilder(1, "Greelock", "An intelligent form of moving carbonite.").language("Rumble").build();
		System.out.println(species_01);

		// instantiate another Species
		Species species_02 = new Species.SpeciesBuilder(2, "Thresher", "An aquatic lifeform with tentacles.").build();
		System.out.println(species_02);

		// instantiate another Species
		Species species_03 = new Species.SpeciesBuilder(3, "Wyveraxx", "A large flying creature with leathery wings and talons. Breathes fire when threatened.").build();
		System.out.println(species_03);

		// instantiate another Species
		Species species_04 = new Species.SpeciesBuilder(4, "Vookies", "Hulking furry bipeds preferring an arboreal habitat.").language("Oeuueau").build();
		System.out.println(species_04);
		
		// instantiate another Species
		Species species_05 = new Species.SpeciesBuilder(5, "Canpyres", "Parasitical nocturnal creatures with glowing blue eyes that feed on ichor.").language("Chitter").build();
		System.out.println(species_05);
		
		// instantiate Patient 1
		int[] allergies_01 = {1, 2};
		Patient patient_01 = new Patient(1, "Blarg", "Peters", "810 Main Floop", "Rockpile", planet_01, species_01, 238923, allergies_01);
		System.out.println(patient_01);

		// instantiate Patient 2
		int[] allergies_02 = {3, 4};
		Patient patient_02 = new Patient(2, "Squirg", "Jones", "42 Oak Blorp", "Rockpile", planet_01, species_02, 548291, allergies_02);
		System.out.println(patient_02);
		
		// instantiate a Doctor
		Doctor doctor_01 = new Doctor(834, "Xeno", "Chalmers", "700 Medical Plaza", "Stardust", planet_02, "Eyestalks and Vents", false);
		System.out.println(doctor_01);

		// instantiate a Pharmacy
		ArrayList<Employee> pharmacy_01_emps = new ArrayList<Employee>();
		Pharmacy pharmacy_01 = new Pharmacy(4001, "Rockpile Sundries", "301 Pulverizer Mrrp", "Rockpile", planet_01, pharmacy_01_emps);		
		System.out.println(pharmacy_01);
		
		// instantiate an Employee (child class of Alien)
		Employee emp_01 = new Employee(3001, "Zorg", "Smith", "123 Milky Way", "Stardust", planet_01, 5000, null);
		// testing toString() using a parent property and a child property
		System.out.println(emp_01);
		
		// instantiate a Pharmacist (grandfather class of Alien)
		Pharmacist pharmacist_01 = new Pharmacist(5001, "Uugla", "Johnson", "10 Granite Glarp", "Quarryton", planet_01, 10000, null, 4);
		System.out.println(pharmacist_01);

		// instantiate another couple Employees
		Employee emp_02 = new Employee(3002, "Glurp", "Adams", "23 Comet Voop", "Stardust", planet_01, 4500, null);
		Employee emp_03 = new Employee(3003, "Skork", "McGee", "10023 Spark Blurg", "Stardust", planet_01, 4300, null);
		Employee emp_04 = new Employee(3004, "Burpla", "McGee", "10023 Spark Blurg", "Stardust", planet_01, 4900, null);
		
		// instantiate a Medication
		ArrayList<Medication> contraindications_01 = new ArrayList<Medication>();
		Medication med_01 = new Medication(10006, "Squirrel Juice", "A distillate of a creature found on the forest planet Sturgos used to treat mild pain", contraindications_01);
		System.out.println(med_01);
		
		// instantiate a second Medication with an upcoming contraindication
		ArrayList<Medication> contraindications_02 = new ArrayList<Medication>();
		Medication med_02 = new Medication(10002, "Voo Nectar", "Refined from a flower found on planet Isika. Used for burns and mild radiation exposure", contraindications_01);
		System.out.println(med_02);

		// instantiate a third Medication with a contraindication against the last one
		ArrayList<Medication> contraindications_03 = new ArrayList<Medication>();
		contraindications_03.add(med_02);
		Medication med_03 = new Medication(10003, "Ithirax Slug Gland", "Gland from a sea slug found on Al'Samik. Lowers ichor pressure and eases valve clamp symptoms", contraindications_01);
		System.out.println(med_03);
		
		// add med_03 to med_02's contraindications list
		med_02.getContraindications().add(med_03);
		
		// instantiate an Antidote
		ArrayList<Medication> contraindications_04 = new ArrayList<Medication>();
		Medication med_04 = new Medication(30001, "Crushed Zithor Wing", "From an insect found on Bastaron. Antidote for Fuzzrak.", contraindications_04);
		System.out.println(med_04);
		
		// instantiate another Antidote
		ArrayList<Medication> contraindications_05 = new ArrayList<Medication>();
		Medication med_05 = new Medication(30002, "Shimmer Seeds", "Sourced from a rare iridescent flower found on Ifersysia. Antidote for Qbuzz.", contraindications_05);
		System.out.println(med_05);
		
		// instantiate a Restricted Medication child class
		ArrayList<Medication> contraindications_06 = new ArrayList<Medication>();
		Medication med_06 = new Fuzzies(20001, "Fuzzrak", "WARNING: Highly addictive. Treats unstable collagen syndrome and melting plague.", contraindications_06, 1, med_04);
		System.out.println(med_06);
		
		// instantiate another Restricted Medication child class
		ArrayList<Medication> contraindications_07 = new ArrayList<Medication>();
		Medication med_07 = new Buzzies(20002, "QBuzz", "WARNING: Abuse potential. Treats combustive temperature dysregulation.", contraindications_07, 2, med_05);
		System.out.println(med_07);
		
		// M3 USING FACTORY		
		// instantiate a Disease
		ArrayList<Species> species_list_01 = new ArrayList<Species>();
		species_list_01.add(species_01);
		species_list_01.add(species_02);
		Disease disease_01 = DiseaseFactory.newDisease(9001, "Sandies", "Causes sand to come through joints and exoskeleton plating causing irritation.", species_list_01);
		
		// instantiate another Disease
		ArrayList<Species> species_list_02 = new ArrayList<Species>();
		species_list_01.add(species_02);
		species_list_01.add(species_03);
		species_list_01.add(species_04);
		species_list_01.add(species_05);
		Disease disease_02 = DiseaseFactory.newDisease(9002, "Zyxxa Spots", "Characterized by high ichor temperature and fatigue and unmistakeable green and purple spots.", species_list_02);
		
		// instantiate another Disease
		ArrayList<Species> species_list_03 = new ArrayList<Species>();
		species_list_01.add(species_01);
		species_list_01.add(species_02);
		species_list_01.add(species_03);
		species_list_01.add(species_04);
		species_list_01.add(species_05);
		Disease disease_03 = DiseaseFactory.newDisease(9003, "Hopping Madness", "Causes infected alien to start hopping up and down and screaming uncontrollably in periodic bursts.", species_list_03);

		// instantiate another Disease
		ArrayList<Species> species_list_04 = new ArrayList<Species>();
		species_list_01.add(species_02);
		species_list_01.add(species_03);
		species_list_01.add(species_05);
		Disease disease_04 = DiseaseFactory.newDisease(9003, "Melting Plague", "Infected alien suddenly melts into a puddle of goo. Highly contagious. Fatal without prompt treatment.", species_list_04);

		// instantiate another Disease
		ArrayList<Species> species_list_05 = new ArrayList<Species>();
		species_list_01.add(species_01);
		species_list_01.add(species_02);
		species_list_01.add(species_04);
		species_list_01.add(species_05);
		Disease disease_05 = DiseaseFactory.newDisease(9003, "Combustive Temperature Dysregulation", "Causes alien to explode if ichor temperature gets too high. Fatal if not treated in time.", species_list_04);
		
		// instantiate a Prescription
		Date stardate = new Date();
		ArrayList<Medication> px_01_meds = new ArrayList<Medication>();
		px_01_meds.add(med_01);
		Prescription px_01 = new Prescription(123, stardate, patient_01, doctor_01, px_01_meds);
		// testing toString() method in Prescription using information from composite objects
		System.out.println(px_01);
		
		// instantiate another Prescription
		ArrayList<Medication> px_02_meds = new ArrayList<Medication>();
		px_02_meds.add(med_02);
		px_02_meds.add(med_03);
		Prescription px_02 = new Prescription(234, stardate, patient_02, doctor_01, px_02_meds);
		System.out.println(px_02);
		
		// testing equals() method in Prescription: true condition
		Prescription dup_Px_01 = new Prescription(123, stardate, patient_01, doctor_01, px_01_meds);
		System.out.println(px_01.equals(dup_Px_01));
		
		// testing equals() method in Prescription: false condition
		Prescription dup_Px_02 = new Prescription(123, stardate, patient_02, doctor_01, px_01_meds);
		System.out.println(px_01.equals(dup_Px_02));
		
		System.out.println("---------------------");
		System.out.println("STARTING METHOD TESTING");
		System.out.println("---------------------");
		
		/* METHOD TESTING */
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		// Alien >> Patient
		aliens.add(patient_01);
		aliens.add(patient_02);
		// Alien >> Doctor
		aliens.add(doctor_01);
		// Alien >> Employee
		aliens.add(emp_01);
		// Alien >> Employee >> Pharmacist
		aliens.add(pharmacist_01);
		aliens.add(emp_02);
		aliens.add(emp_03);
		aliens.add(emp_04);
		
		ArrayList<Disease> diseases = new ArrayList<Disease>();
		diseases.add(disease_01);
		diseases.add(disease_02);
		diseases.add(disease_03);
		diseases.add(disease_04);
		diseases.add(disease_05);

		ArrayList<Medication> test_meds = new ArrayList<Medication>();
		test_meds.add(med_01);
		test_meds.add(med_02);
		test_meds.add(med_03);
		test_meds.add(med_04);
		// Medication >> RestrictedMedication >> Fuzzies
		test_meds.add(med_06);
		
		// M2 HOMEWORK STATIC
		Pharmacist.displayAvailablePharmacistCount();
		
		// hire emp_01 and pharmacist_01 at pharmacy_01 using downcasting
		pharmacy_01.hire((Employee)aliens.get(3));
		pharmacy_01.hire((Employee)aliens.get(4));
		pharmacy_01.hire((Employee)aliens.get(5));
		pharmacy_01.hire((Employee)aliens.get(6));
		pharmacy_01.hire((Employee)aliens.get(7));
		
		// M2 HOMEWORK STATIC
		Pharmacist.displayAvailablePharmacistCount();
		
		// use new Employee ArrayList assignment from Pharmacy object to call Employee methods
		pharmacy_01.getEmployees().get(0).turnLightsOn();
		pharmacy_01.getEmployees().get(0).sweepFloor();
		pharmacy_01.getEmployees().get(0).emptyTrash();
		
		// get patients from ArrayList (requires downcasting)
		Patient patient_a = (Patient) aliens.get(0);
		Patient patient_b = (Patient) aliens.get(1);
		
		// have doctor diagnose patients (requires downcasting)
		Doctor doctor_a = (Doctor) aliens.get(2);
		doctor_a.diagnosePatient(patient_a, diseases.get(0));
		doctor_a.diagnosePatient(patient_b, diseases.get(1));
		doctor_a.diagnosePatient(patient_b, diseases.get(2));		

		// have doctor write prescriptions
		ArrayList<Medication> patient_a_meds = new ArrayList<Medication>();
		patient_a_meds.add(test_meds.get(0));
		Prescription PX_01 = doctor_a.writePx(patient_a, patient_a_meds);
		
		ArrayList<Medication> patient_b_meds = new ArrayList<Medication>();
		patient_b_meds.add(test_meds.get(1));
		patient_b_meds.add(test_meds.get(4));
		Prescription PX_02 = doctor_a.writePx(patient_b, patient_b_meds);
		
		// patients check in to pharmacy and get prescriptions filled
		patient_a.checkIn(pharmacy_01);
		// downcast to get Pharmacist from ArrayList
		Pharmacist pharmacist_alpha = (Pharmacist)aliens.get(4);
		pharmacist_alpha.verifyPxMeds(PX_01);
		pharmacist_alpha.fillPx(PX_01);
		PX_01.processPx(pharmacy_01, pharmacist_alpha);
		PX_01.calculateBill();
		patient_a.buyMedication(test_meds.get(0), 10);
		patient_a.takeMedication(test_meds.get(0));
		
		patient_b.checkIn(pharmacy_01);
		PX_02.processPx(pharmacy_01, pharmacist_alpha);
		pharmacist_alpha.verifyPxMeds(PX_01);
		pharmacist_alpha.fillPx(PX_01);
		patient_b.buyMedication(test_meds.get(4), 5);
		patient_b.takeMedication(test_meds.get(4));

		Fuzzies fuzz_a = (Fuzzies) test_meds.get(4);
		fuzz_a.causeAddiction();
		fuzz_a.causeOverdose();
		
		doctor_a.becomeBanned(test_meds.get(4));
		
		// M2 HOMEWORK COMPARABLE - note that Squirrel Juice was instantiated first but gets sorted by ID
		System.out.println(test_meds);
		Collections.sort(test_meds);
		System.out.println(test_meds);
		
		// M3 USING COMPARATOR - employee list is unsorted before but sorted by last name and then first name if last names match (ex: McGee)
		System.out.println(pharmacy_01.getEmployees());
		Collections.sort(pharmacy_01.getEmployees(), Employee.NAME_COMPARATOR);
		System.out.println(pharmacy_01.getEmployees());
	}

}
