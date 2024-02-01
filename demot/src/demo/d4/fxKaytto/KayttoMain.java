package demo.d4.fxKaytto;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author niko
 * @version 24.1.2024
 */
public class KayttoMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("KayttoGUIView.fxml"));
            final Pane root = ldr.load();
            //final KayttoGUIController kayttoCtrl = (KayttoGUIController)ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("kaytto.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Kaytto");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
        launch(args);
    }
}