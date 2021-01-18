package magic;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author Niko Sihvo
 * @version 18.1.2021
 *
 */
public class WildMagicMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("WildMagicGUIView.fxml"));
            final Pane root = ldr.load();
            //final WildMagicGUIController wildmagicCtrl = (WildMagicGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("wildmagic.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("WildMagic");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei k�yt�ss�
     */
    public static void main(String[] args) {
        launch(args);
    }
}