package demo.d4.fxRPN;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * @author niko
 * @version 23.1.2024
 */
public class RPNGUIController {

    @FXML private TextArea fxTA;


    /**
     * Lisää duplikaatin viimeisestä rivistä
     */
    @FXML private void enter() {
        String s = fxTA.getText();
        if (s == null || s.isEmpty()) return;
        String[] lines = s.split("\n");
        fxTA.appendText("\n" + lines[lines.length-1]);
    }

    /**
     * Summaa kaksi viimeistä lukua
     */
    @FXML private void plus() {
        calculate('+');
    }

    /**
     * Vähentää kaksi viimeistä lukua
     */
    @FXML private void minus() {
         calculate('-');
    }

    /**
     * Kertoo kaksi viimeistä lukua
     */
    @FXML private void multiply() {
        calculate('*');
    }

    /**
     * Jakaa kaksi viimeistä lukua
     */
    @FXML private void divide() {
        calculate('/');
    }

    /**
     * Kertoo viimeisen luvun itsellään
     */
    @FXML private void square() {
        String[] lines = getLines();
        if (lines.length < 1) return;
        double d = Double.parseDouble(lines[lines.length-1]);
        double result = d * d;
        fxTA.clear();
        for (int i = 0; i < lines.length-1; i++) {
            fxTA.appendText(lines[i] + "\n");
        }
        setResult(result);
    }

    /**
     * Vaihtaa kaksi viimeistä lukua keskenään
     */
    @FXML private void swap() {
        String[] lines = getLines();
        if (lines.length < 2) return;
        fxTA.clear();
        fxTA.appendText(lines[lines.length-1] + "\n");
        fxTA.appendText(lines[lines.length-2] + "\n");
    }

    /**
     * Vaihtaa viimeisen luvun merkin
     */
    @FXML private void chs() {
        String[] lines = getLines();
        if (lines.length < 1) return;
        double d = Double.parseDouble(lines[lines.length-1]);
        double result = -d;
        fxTA.clear();
        for (int i = 0; i < lines.length-1; i++) {
            fxTA.appendText(lines[i] + "\n");
        }
        setResult(result);
    }

    /**
     * Hakee kaikki rivit
     */
    public String[] getLines() {
        String s = fxTA.getText();
        if (s == null || s.isEmpty()) return new String[0];
        return s.split("\n");
    }


    /**
     * Laskee kaksi viimeistä lukua
     * @param sign operaattori
     */
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

    /**
     * Jakaa kaksi lukua
     * @param d1 jaettava
     * @param d2 jakaja
     * @return jakolaskun tulos
     */
    public double divideRules(double d1, double d2) {
        if (d2 == 0) {
            fxTA.appendText("\n" + "Error: division by zero");
        }
        return d1 / d2;
    }

    /**
     * Asettaa rivit ennen tulosta
     * @param lines rivit
     */
    public void setLinesBeforeResult(String[] lines) {
        fxTA.clear();
        for (int i = 0; i < lines.length-2; i++) {
            fxTA.appendText(lines[i] + "\n");
        }
    }

    /**
     * Asettaa tuloksen
     * @param d tulos
     */
    public void setResult(double d) {
        fxTA.appendText(d + "");
    }
}