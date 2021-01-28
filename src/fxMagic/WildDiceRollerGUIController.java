package fxMagic;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.Dice;

/**
 * @author Niko Sihvo
 * @version 19.1.2021
 *
 */
public class WildDiceRollerGUIController implements ModalControllerInterface<String>{


	@FXML Button buttonRoll;
	@FXML TextField textRoll;
	@FXML StringGrid<String> rollLog;
	
	
	
	@FXML private void handleRoller() {
		
	}
	
	@FXML private void handleList() {
		rollLog.setOnMouseClicked(event -> {
			if(event.getClickCount() == 2) {
				//Dialogs.showMessageDialog("Can't handle this chaos!");
				
				
			}
		});
	}
	

// ModalControllers
//===============================================================	
	
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