package demo.d3.fxRPN;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author niko
 * @version 23.1.2024
 */
public class RPNMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("RPNGUIView.fxml"));
            final Pane root = ldr.load();
            //final RPNGUIController rpnCtrl = (RPNGUIController)ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("rpn.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("RPN");
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