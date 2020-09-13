import java.util.ArrayList;

/*
 * Chris Huber <chuber2@mail.ccsf.edu>
 * CS211S, Jessica Masters
 * 09/13/2020
 * Discussion Three: Design Patterns
 */


public class DiseaseFactory {

	public static Disease newDisease(int inId, String inName, String inDescription, ArrayList<Species> inAffectedSpecies) {
		Disease newDisease;
		
		newDisease = new Disease(inId, inName, inDescription, inAffectedSpecies);
		return newDisease;
	}
}
