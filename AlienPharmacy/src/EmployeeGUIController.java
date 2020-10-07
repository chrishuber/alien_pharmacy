import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class EmployeeGUIController extends Application {
	
	private Employee employee;
	private EmployeeGUIView employeeView;
	
	public EmployeeGUIController() {
		employeeView = new EmployeeGUIView();
		employeeView.setOnAction(this::infoButton);
		employeeView.setOnAction(this::submitButton);
	}

	private void infoButton(ActionEvent event) {
		employeeView.setOutputText("The Employee class consists of {int id; String firstName; String lastName; String address; String city; Planet planet; int salary; Pharmacy pharmacy}. The Pharmacist class extends this adding {int authorizationLevel}.");
	}
	
	private void submitButton(ActionEvent event) {
		String empFirstName = employeeView.getEmpFirstName();
		String empLastName = employeeView.getEmpLastName();
		String empType = employeeView.getEmpType();
		String empAddress = employeeView.getEmpAddress();
		String empCity = employeeView.getEmpCity();
		String empPlanet = employeeView.getEmpPlanet();
		
		Planet planet_01 = new Planet(1, "Iferysia", "A hot desert world populated with sandworms and rock creatures.", Planet.PlanetMass.NORMAL, Planet.Terraform.VOLCANIC);
		Planet planet_02 = new Planet(2, "Al'Samik", "An aquatic world teeming with hundreds of species and many cross-species diseases.", Planet.PlanetMass.DENSE, Planet.Terraform.AQUATIC);
		Planet planet_03 = new Planet(3, "Isika", "An ethereal planet home to many flying and spirit creatures.", Planet.PlanetMass.LOOSE, Planet.Terraform.ETHEREAL);
		Planet planet_04 = new Planet(4, "Sturgos", "An arboreal world that is the source of many curative plants.", Planet.PlanetMass.NORMAL, Planet.Terraform.ARBOREAL);
		Planet planet_05 = new Planet(5, "Bastaron", "A naxxous sphere home to nightworld creatures. Source of most restricted medications.", Planet.PlanetMass.DENSE, Planet.Terraform.NAXXOUS);

		Planet newPlanet = planet_01;
		if (empPlanet == "Iferysia")
			newPlanet = planet_01;
		else if (empPlanet == "Al'Samik")
			newPlanet = planet_02;
		else if (empPlanet == "Isika")
			newPlanet = planet_03;
		else if (empPlanet == "Sturgos")
			newPlanet = planet_04;
		else if (empPlanet == "Bastaron")
			newPlanet = planet_05;
		
		String outputText = "";
		if (empType == "Pharmacist") {
			Pharmacist newPharm = new Pharmacist(5234, empFirstName, empLastName, empAddress, empCity, newPlanet, 10000, null, 5);
			outputText += "Pharmacist " + empFirstName + " " + empLastName + " at " + empAddress + ", " + empCity + " on Planet " + newPlanet.getName() + " was successfully created.";  
		}
		else {
			Employee newEmp = new Employee(1234, empFirstName, empLastName, empAddress, empCity, newPlanet);
			outputText += "Employee " + empFirstName + " " + empLastName + " at " + empAddress + ", " + empCity + " on Planet " + newPlanet.getName() + " was successfully created.";  
		}
		
		employeeView.setOutputText(outputText);
	}
	
	@Override
	public void start(Stage primaryStage) {
		EmployeeGUIController controller = new EmployeeGUIController();
		
		Scene scene = new Scene(controller.employeeView.getParent(), 600, 400);
		primaryStage.setTitle("Alien Employee Generator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

