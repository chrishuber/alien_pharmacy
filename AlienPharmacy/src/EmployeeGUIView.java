import java.util.Arrays;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class EmployeeGUIView {

	private TextField empFirstNameField, empLastNameField, empAddressField, empCityField, empSalaryField;
	private Text titleLabel, firstNameLabel, lastNameLabel, empTypeLabel, addressLabel, cityLabel, planetLabel, planetSelection, salaryLabel;
	private Label outputText;
	private Button infoButton, submitButton;
	private ToggleGroup empRadioGroup;
	private RadioButton empRadio, pharmRadio;
	private ComboBox planetComboBox;
	private String selectedPlanet;
	private VBox primaryBox;
	
	private final static Font font = Font.font("Tahoma", 18);
	
	// public enum PlanetEnum {
	//	Iferysia, AlSamik, Isika, Sturgos, Bastaron;
	// }
	
	public EmployeeGUIView() {
		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.TOP_LEFT);
		primaryBox.setSpacing(10);
		primaryBox.setPadding(new Insets(10, 10, 10, 10)); // use padding to format
		primaryBox.setStyle("-fx-background-color: #877bab;");
		
		titleLabel = new Text("Create Alien Employee");
		titleLabel.setFont(Font.font("Tahoma", 24));
		titleLabel.setFill(Color.BLACK);
		primaryBox.getChildren().add(titleLabel);
		
		firstNameLabel = new Text("First name: ");
		firstNameLabel.setFont(font);
		empFirstNameField = new TextField();
		HBox employeeFNBox = new HBox(firstNameLabel, empFirstNameField);
		primaryBox.getChildren().add(employeeFNBox);

		lastNameLabel = new Text("Last name: ");
		lastNameLabel.setFont(font);
		empLastNameField = new TextField();
		HBox employeeLNBox = new HBox(lastNameLabel, empLastNameField);
		primaryBox.getChildren().add(employeeLNBox);
		
		empTypeLabel = new Text("Employee type:");
		empTypeLabel.setFont(font);
		empRadioGroup = new ToggleGroup();
		empRadio = new RadioButton("Employee");
		empRadio.setToggleGroup(empRadioGroup);
		empRadio.setSelected(true);
		pharmRadio = new RadioButton("Pharmacist");
		pharmRadio.setToggleGroup(empRadioGroup);
		HBox radioButtonBox = new HBox(empRadio, pharmRadio);
		radioButtonBox.setSpacing(10);
		primaryBox.getChildren().add(radioButtonBox);

		addressLabel = new Text("Address: ");
		addressLabel.setFont(font);
		empAddressField = new TextField();
		HBox employeeAddressBox = new HBox(addressLabel, empAddressField);
		primaryBox.getChildren().add(employeeAddressBox);
		
		cityLabel = new Text("City: ");
		cityLabel.setFont(font);
		empCityField = new TextField();
		HBox employeeCityBox = new HBox(cityLabel, empCityField);
		primaryBox.getChildren().add(employeeCityBox);
		
		planetLabel = new Text("Planet: ");
		planetLabel.setFont(font);
				
		// ObservableList<PlanetEnum> options = FXCollections.observableArrayList(Arrays.asList(PlanetEnum.values()));
		// planetComboBox = new ComboBox(options);
		planetComboBox = new ComboBox<String>();
		planetComboBox.getItems().addAll("Iferysia", "Al'Samik", "Isika", "Sturgos", "Bastaron");
		planetComboBox.getSelectionModel().selectFirst();
		/* 
		 * I couldn't get this to correctly update the value of the ComboBox on change. Comments appreciated. 
		 * I also initially tried this with an Enum but bailed out.
		 */
		//planetComboBox.getSelectionModel().selectedItemProperty().addListener(this::selectPlanet);
		// planetSelection = new Text("Iferysia");
		selectedPlanet = (String) planetComboBox.getValue();
		
		HBox employeePlanetBox = new HBox(planetLabel, planetComboBox);
		primaryBox.getChildren().add(employeePlanetBox);
		
		infoButton = new Button("Get Info");
		submitButton = new Button("Submit");
		HBox buttonBox = new HBox(infoButton, submitButton);
		buttonBox.setAlignment(Pos.BASELINE_LEFT);
		buttonBox.setSpacing(10);
		primaryBox.getChildren().add(buttonBox);
		
		outputText = new Label("");
		outputText.setFont(font);
		outputText.setWrapText(true);
		HBox outputBox = new HBox(outputText);
		primaryBox.getChildren().add(outputBox);
	}
	
	public Parent getParent() {
		return primaryBox;
	}

	public String getEmpFirstName() {
		return empFirstNameField.getText();
	}

	public String getEmpLastName() {
		return empLastNameField.getText();
	}

	public String getEmpType() {
		RadioButton rb = (RadioButton) empRadioGroup.getSelectedToggle();
		return rb.getText();
	}
	
	public String getEmpAddress() {
		return empAddressField.getText();
	}
	
	public String getEmpCity() {
		return empCityField.getText();
	}
	
	public String getEmpPlanet() {
		return (String) selectedPlanet;
	}
	
	public void setOutputText(String inText) {
		outputText.setText(inText);
	}

	//public void selectPlanet(ObservableValue<? extends String> ov, String newVal) {
	//	planetSelection.setText(newVal);
	//}
	
	public void setOnAction(EventHandler<ActionEvent> handler) {
		/* I wasn't able to figure out how to make my Get Info button do a separate action */
		infoButton.setOnAction(handler);
		submitButton.setOnAction(handler);
	}
	
}
