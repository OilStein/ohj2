package demo.d4.fxKaytto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author niko
 * @version 24.1.2024
 */
public class KayttoGUIController {

    @FXML private TextField fxTF;
    @FXML private Label fxResult;

    /**
     * Laskee iän vuosiluvusta ja päivittää käyttöliittymän fxResult labelin.
     */
    @FXML private void laske() {
        try {
            int vuosi = Integer.parseInt(fxTF.getText());
            fxResult.setText("Täytät tänä vuonna " + (2024 - vuosi) + " vuotta");
        } catch (Exception e) {
            fxResult.setText("Ei luku");
        }
    }
}