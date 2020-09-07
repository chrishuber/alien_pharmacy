import java.util.*;

public class Prescription {
	private int id;
	private int pxId;
	private Date pxDate;
	private Doctor pxDoctor;
	private Patient pxPatient;
	private ArrayList<Medication> medications;
	
	public Prescription(int inPxId, Date inPxDate, Patient inPatient, Doctor inDoctor, ArrayList<Medication> inMedications) {
		pxId = inPxId;
		pxDate = inPxDate;
		pxPatient = inPatient;
		pxDoctor = inDoctor;
		medications = inMedications;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	public Date getPxDate() {
		return pxDate;
	}
	public void setPxDate(Date pxDate) {
		this.pxDate = pxDate;
	}
	public Patient getPxPatient() {
		return pxPatient;
	}
	public void setPxPatient_id(Patient pxPatient) {
		this.pxPatient = pxPatient;
	}
	public Doctor getPxDoctor() {
		return pxDoctor;
	}
	public void setPxDoctor(Doctor pxDoctor) {
		this.pxDoctor = pxDoctor;
	}
	public ArrayList<Medication> getMedications() {
		return medications;
	}
	public void setMedications(ArrayList<Medication> medications) {
		this.medications = medications;
	}
	
	@Override
	public String toString() {
		pxPatient = getPxPatient();
		pxDoctor = getPxDoctor();		
		
		return "Prescription number " + String.valueOf(getPxId()) + " was written by Dr. " + pxDoctor.getLastName() + " for Patient " + pxPatient.getLastName() + " on " + getPxDate();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Prescription) {
			Prescription otherPx = (Prescription) obj;
			return getPxId()==otherPx.getPxId() && getPxPatient() == otherPx.getPxPatient() && getPxDoctor() == otherPx.getPxDoctor();
		}
		else {
			return false;
		}
	}
	
	public void processPx(Pharmacy inPharmacy, Pharmacist inPharmacist) {
		System.out.println("Prescription " + getPxId() + " has been processed for Patient " + getPxPatient().getLastName() + " at " + inPharmacy.getLocalName() + " by Pharmacist " + inPharmacist.getFirstName() + " " + inPharmacist.getLastName());
	}
	
	public void rejectPx(int reasonCode) {
		// TO DO: make array so multiple reasons can output
		System.out.println("Prescription rejected due to: ");
		if (reasonCode == 1) {
			System.out.println("CONTRAINDICATIONS");
		}
		if (reasonCode == 2) {
			System.out.println("SPECIES INCOMPATIBLE");
		}
		if (reasonCode == 3) {
			System.out.println("DOCTOR BANNED");
		}
	}
	
	public void calculateBill() {
		// TO DO: calculate bill based on medication cost using insurance deductions if time allows
		System.out.println("The total cost for this prescription is 139 credits.");
	}
}
