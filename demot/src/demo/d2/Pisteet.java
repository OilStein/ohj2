package demo.d2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pisteet {

    public static double pisteet(String rivi) {
        if (rivi.trim().isEmpty()) return 0;
        String regex = "=.\\[T1-\\d+:\\d+(?:.|,)\\d+]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rivi);
        if (matcher.find()) {
            String pisteet = matcher.group();
            pisteet = pisteet.substring(pisteet.indexOf(":") + 1, pisteet.indexOf("]"));
            if (pisteet.contains(",")) {
                pisteet = pisteet.replace(",", ".");
                return Double.parseDouble(pisteet) - 0.5;
            }
            return Double.parseDouble(pisteet);
        }
        return 0;
    }

    public static double laskePisteet(String rivit) {
        String[] rivitaulu = rivit.split("\n");
        double pisteet = 0;
        for (String rivi : rivitaulu) {
            pisteet += pisteet(rivi);
        }
        return pisteet;
    }
    public static void main(String[] args) {
        String rivit = "teht1.txt = [T1-2:1.5]\n" +
                        "teht1.txt = [T1-2,1.5]\n" +
                        "teht1.txt = (T1-2:1.5)\n" +
                        "teht1.txt = [T1-2:1,5]\n" +
                        "teht1.txt = T1-2:1.5 \n" +
                        "teht1.txt   [T1-2:1.5]\n" +
                        "teht1.txt = [1-2:1.5]\n" +
                        "teht1.txt = [B1-2:1.5]";


        System.out.println(laskePisteet(rivit));
    }
}
