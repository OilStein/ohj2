package demo.d3.fxRPN;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;

/**
 * @author niko
 * @version 23.1.2024
 */
public class RPNGUIController {

    @FXML private TextArea fxTA;



    @FXML private void enter() {
        String s = fxTA.getText();
        if (s == null || s.isEmpty()) return;
        String[] lines = s.split("\n");
        fxTA.appendText("\n" + lines[lines.length-1]);
    }

    @FXML private void plus() {
        calculate('+');
    }

    @FXML private void minus() {
         calculate('-');
    }

    @FXML private void multiply() {
        calculate('*');
    }

    @FXML private void divide() {
        calculate('/');
    }

    public String[] getLines() {
        String s = fxTA.getText();
        if (s == null || s.isEmpty()) return new String[0];
        return s.split("\n");
    }


    public void calculate(char sign) {
        String[] lines = getLines();
        if (lines.length < 2) return;
        double d1 = Double.parseDouble(lines[lines.length-2]);
        double d2 = Double.parseDouble(lines[lines.length-1]);
        double result = switch (sign) {
            case '+' -> d1 + d2;
            case '-' -> d1 - d2;
            case '*' -> d1 * d2;
            case '/' -> divideRules(d1, d2);
            default -> 0;
        };
        setLinesBeforeResult(lines);
        setResult(result);
    }

    public double divideRules(double d1, double d2) {
        if (d2 == 0) {
            fxTA.appendText("\n" + "Error: division by zero");
        }
        return d1 / d2;
    }

    public void setLinesBeforeResult(String[] lines) {
        fxTA.clear();
        for (int i = 0; i < lines.length-2; i++) {
            fxTA.appendText(lines[i] + "\n");
        }
    }

    public void setResult(double d) {
        fxTA.appendText("" + d);
    }
}