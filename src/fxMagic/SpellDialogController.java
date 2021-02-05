package fxMagic;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.RadioButtonChooser;
import fi.jyu.mit.ohj2.Mjonot;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Spell;

/**
 * @author Niko Sihvo
 * @version 19.1.2021
 *
 */
public class SpellDialogController implements ModalControllerInterface<Spell>, Initializable {
	
	
	@FXML private GridPane gridSpell;
	@FXML private VBox vboxDesc; 
	
	
	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		format();
	}
	
	
	//================
	
	private Spell pointSpell;
	private static Spell helpSpell = new Spell();
	private TextField[] edits;
	private int f = 0;
	
	public static TextField[] createFields(GridPane gridSpell) {
		gridSpell.getChildren().clear();
		TextField[] edits = new TextField[helpSpell.getData()];
		
		for (int i = 0, f = helpSpell.firstField(); f < helpSpell.getData(); f++, i++) {
			TextField edit = new TextField();
			edits[f] = edit;
			edit.setId("e" + f);
			gridSpell.add(edit, 1, i);
		}
		return edits;
	}
	
	public static void wipe(TextField[] edits) {
		for (TextField edit : edits) {
			if (edit != null) {
				edit.setText("");
			}
		}
	}
	
	public static int getFieldId(Object obj, int def) {
		if ( !( obj instanceof Node)) {
			return def;
		}
		Node node = (Node)obj;
		return Mjonot.erotaInt(node.getId().substring(1), def);
	}
	
	protected void format() {
		for ( TextField edit : edits) {
			if(edit != null) {
				edit.setText("");
			}
		}
	}
	
	@Override
	public Spell getResult() {
		return pointSpell;
	}
	
	private void setField(int f) {
		this.f = f;
	}
	
	
	@Override
	public void setDefault(Spell def) {
		pointSpell = def;
		showSpell(edits, pointSpell);
	}
	
	protected void handleSpellEdit(TextField edit) {
		if (pointSpell == null) return;
		int f = getFieldId(edit, helpSpell.firstField());
		String s = edit.getText();
		pointSpell.set(f, s);
	}
	
	public static void showSpell(TextField[] edits, Spell spell) {
		if (spell == null) return;
		for(int f = spell.firstField(); f < spell.getData(); f++) {
			edits[f].setText(spell.get(f));
		}
	}
	
	
	public static Spell askSpell(Stage modalityStage, Spell def, int f) {
		return ModalController.<Spell, SpellDialogController>showModal(
				SpellDialogController.class.getResource("SpellDialogView.fxml"),
				"Spell",
				modalityStage, def,
				ctrl -> ctrl.setField(f));
				
	}
	
	// 			HANDLERS
	//====================================================
	
	@FXML public void handleSaveSpell() {
		Dialogs.showMessageDialog("Lost into chaos!");
	}
	
	
	@Override
	public void handleShown() {
		f = Math.max(helpSpell.firstField(), Math.min(f,  helpSpell.getData()-1));
		edits[f].requestFocus();
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



}