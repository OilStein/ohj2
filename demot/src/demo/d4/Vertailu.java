package demo.d4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vertailu {

    public static boolean onkoSamat(String merkkijono, String maski) {
        String regex = maski.replace("*", ".*");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(merkkijono);

        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(onkoSamat("Kissa", "K*a"));      // true
        System.out.println(onkoSamat("Kissa", "Kassa"));    // false
        System.out.println(onkoSamat("Joutsen", "Jo*sen")); // true
        System.out.println(onkoSamat("Kissa", "K*i"));      // false
        System.out.println(onkoSamat("Kissa", "K*"));       // true
        System.out.println(onkoSamat("Lintu", "K*"));       // false
    }
}
