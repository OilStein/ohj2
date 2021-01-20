package magic;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * @author Niko Sihvo
 * @version 18.1.2021
 *
 */
public class WildMagicGUIController {
	
	
	
	
	/**
	 * 					FXML ITEMS
	 * ------------------------------------------------------
	 */
	
	// File items
	@FXML MenuItem saveMenufx;
	@FXML MenuItem closeMenufx;
	
	// Edit items
	@FXML MenuItem addMenufx;
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
	
}