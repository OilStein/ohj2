package demo.d3;

public class Esiintymat {

    public static String poistaEsiintymat(String jono, String poistettava) {
        if (jono == null || poistettava == null || poistettava.isEmpty() || jono.isEmpty()) {
            return jono;
        }
        while (jono.contains(poistettava)) {
            jono = jono.replace(poistettava, "");
        }
        return jono;
    }

    public static void main(String[] args) {
        String jono = "paatti";
        String poistettava = "at";
        System.out.println(poistaEsiintymat(jono, poistettava));
        System.out.println(poistaEsiintymat("kissa", "ss"));
        System.out.println(poistaEsiintymat("catcat", "at"));
    }
}
