package magic;

import fi.jyu.mit.fxgui.StringGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author nikos
 * @version 19.1.2021
 *
 */
public class WildDiceRollerGUIController {

	@FXML Button buttonRoll;
	@FXML TextField textRoll;
	@FXML StringGrid<String> rollLog;
}