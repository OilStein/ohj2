package magic;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalControllerInterface;
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
public class WildDialogGUIController implements ModalControllerInterface<String> {
	
	// 			HANDLERS
	//====================================================
	
	@FXML public void handleSaveSpell() {
		Dialogs.showMessageDialog("Lost into chaos!");
	}
	
	
	
	// 			ITEMS
	//==================================================================
	
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
	
	
	// =================================================================================

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleShown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefault(String oletus) {
		// TODO Auto-generated method stub
		
	}
	
}