package fxMagic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import logic.Spell;

/**
 * @author Niko Sihvo
 * @version 18.1.2021
 *
 */
public class WildMagicGUIController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	}
	
	
	// HANDLERS
	//======================================================
	
	// Handle buttons
	
	@FXML private void handleAddSpell() {
		ModalController.showModal(WildMagicGUIController.class.getResource("WildDialogGUIView.fxml"), "Spell Adder", null, "");
	}
	
	@FXML private void handleRollDice() {
		ModalController.showModal(WildMagicGUIController.class.getResource("WildDiceRollerGUIView.fxml"), "RollerMobster", null, "");
	}
	
	@FXML private void handleWildMagic() {
		Dialogs.showMessageDialog("Cant handle this yet");
	}
	
	// Menu : File
	
	@FXML private void handleCloseMenu() {
		canClose();
		Platform.exit();
	}
	
	// Menu : Edit
	
	@FXML private void handleAddMenu() {
		ModalController.showModal(WildMagicGUIController.class.getResource("WildDialogGUIView.fxml"), "Spell Adder", null, "");
	}
	
	@FXML private void handleEditMenu() {
		ModalController.showModal(WildMagicGUIController.class.getResource("WildDialogGUIView.fxml"), "Spell Adder", null, "");
	}
	
	@FXML private void handleDeleteMenu() {
		Dialogs.showMessageDialog("Not working yet");
	}
	
	@FXML private void handleHelpMenu() {
		help();
	}
	
	@FXML private void handleAboutMenu() {
		Dialogs.showMessageDialog("Author: Niko Sihvo\r\nVersion: 1.2");
	}
	
	// Click spell and print spell handler
	
	@FXML private void handleDescription() {
		// Dialogs.showMessageDialog("Not working yet");
		spellGrid.setOnMouseClicked(event -> {
			if(event.getClickCount() == 2) {
				//Dialogs.showMessageDialog("Can't handle this chaos!");
				
				
			}
		});
	}
	
	// Searchbar handlers
	
	@FXML private void handleSearch() {
		Dialogs.showMessageDialog("Not working yet");
	}
	
	@FXML private void handleClassSelect() {
		Dialogs.showMessageDialog("Not working yet");
	}
	
	

	//				FXML ITEMS
	//=====================================================
	
	// File items
	@FXML MenuItem closeMenufx;
	
	// Edit items
	@FXML MenuItem addMenufx;
	@FXML MenuItem editMenufx;
	@FXML MenuItem deleteMenufx;
	
	// Help items
	@FXML MenuItem helpMenufx;
	@FXML MenuItem aboutMenufx;
	
	// Main grid
	@FXML StringGrid<String> spellGrid;
	
	// Searchbar and cropping option
	@FXML TextField textSearch;
	@FXML ComboBoxChooser<String> cbcClassSelect;
	
	// Buttons
	@FXML Button buttonAdd;
	@FXML Button buttonRoll;
	@FXML Button buttonWild;
	
	
	
	//		CODE
	//==========================================================
	
	public boolean canClose() {
		Dialogs.showMessageDialog("Wild Magic is Closing");
		return true;
	}
	
	private void help() {
		try {
		File file = new File("README.md");
		Desktop desktop = Desktop.getDesktop();
		if(file.exists()) {
			desktop.open(file);
		}
		else {
			URI uri = new URI("https://tim.jyu.fi/view/kurssit/tie/ohj2/2021k/ht/nimisihv");
			desktop.browse(uri);
		}
		
		}catch (IOException e) {
			return;
		}catch (URISyntaxException e) {
			return;
		}
	}
	
	
	protected void newSpell() {
		try {
			Spell newSpell = new Spell();
			//newSpell.register();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
}