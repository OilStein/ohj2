package magic;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author nikos
 * @version 19.1.2021
 *
 */
public class WildDiceRollerGUIController implements ModalControllerInterface<String>{


	@FXML Button buttonRoll;
	@FXML TextField textRoll;
	@FXML StringGrid<String> rollLog;
	
	@FXML private void handleRoller() {
		Dialogs.showMessageDialog("Not Rolling Yet");
	}

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