package demo.d3;

public class Jokerimerkki {

    public static boolean onkoSamatKysymysmerkilla(String jono, String maski ) {
        if ( jono.length() != maski.length() ) return false;
        for (int i=0; i<jono.length(); i++) {
            if ( maski.charAt(i) != jono.charAt(i) && maski.charAt(i) != '?'  ) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String jono = "abba";
        String maski = "a??a";
        System.out.println(onkoSamatKysymysmerkilla(jono,maski));
    }
}
