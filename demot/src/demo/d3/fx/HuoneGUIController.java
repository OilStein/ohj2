package demo.d3.fx;

import javafx.fxml.FXML;
import javafx.scene.control.*;


/**
 * @author niko
 * @version 23.1.2024
 */
public class HuoneGUIController {
    public Button fxLaske;
    @FXML
    private TextField fxKorkeus;
    @FXML
    private TextField fxLeveys;
    @FXML
    private TextField fxPituus;
    @FXML
    private TextField fxPinta;
    @FXML
    private TextField fxTilavuus;


    public static double haeLuku(TextField kentta) {
        String jono = kentta.getText();
        if (jono.isEmpty()) return 0;
        return Double.parseDouble(jono);
    }

    public static void laitaTulos(TextField kentta, double arvo) {
        kentta.setText(String.format("%.2f", arvo));
    }


    @FXML
    private void onEnter() {
        laske();
    }


    public void laske() {
        double korkeus = haeLuku(fxKorkeus);
        double leveys = haeLuku(fxLeveys);
        double pituus = haeLuku(fxPituus);
        double pinta = leveys * pituus;
        double tilavuus = pinta * korkeus * pituus;
        laitaTulos(fxPinta, pinta);
        laitaTulos(fxTilavuus, tilavuus);
    }
}