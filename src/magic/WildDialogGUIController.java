package magic;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.RadioButtonChooser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * @author Niko Sihvo
 * @version 19.1.2021
 *
 */
public class WildDialogGUIController {
	
	// Base information
	@FXML TextField textName;
	@FXML ComboBoxChooser<String> cbcSchool;
	@FXML ComboBoxChooser<String> cbcLvl;
	@FXML ComboBoxChooser<String> cbcCast;
	@FXML ComboBoxChooser<String> cbcRange;
	@FXML ComboBoxChooser<String> cbcDuration;
	@FXML TextArea textDesc;
	
	// Component radiobuttons
	@FXML RadioButtonChooser<Boolean> dotVerbal;
	@FXML RadioButtonChooser<Boolean> dotSomatic;
	@FXML RadioButtonChooser<Boolean> dotMaterial;
	@FXML TextField textMaterials;
	
	
	// Class radiobuttons
	@FXML RadioButtonChooser<Boolean> dotArtificer;
	@FXML RadioButtonChooser<Boolean> dotBard;
	@FXML RadioButtonChooser<Boolean> dotCleric;
	@FXML RadioButtonChooser<Boolean> dotDruid;
	@FXML RadioButtonChooser<Boolean> dotPaladin;
	@FXML RadioButtonChooser<Boolean> dotRanger;
	@FXML RadioButtonChooser<Boolean> dotSorcerer;
	@FXML RadioButtonChooser<Boolean> dotWarlock;
	@FXML RadioButtonChooser<Boolean> dotWizard;
	
	// Save Button
	@FXML Button buttonSave;
	
}