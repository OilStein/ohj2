package demo.d4;

public class Kolmio {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        System.out.println("Kolmio");
        System.out.println("Ala: " + kolmionAla(3, 4));
        System.out.println("Hypotenuusa: " + hypotenuusa(3, 4));
    }

    /**
     * Laskee kolmion pinta-alan
     * @param pituus Kolmian sivun pituus
     * @param korkeus Kolmion korkeus
     * @return Kolmion pinta-ala
     */
    public static double kolmionAla(double pituus, double korkeus){
        return (pituus * korkeus) / 2;
    }


    /**
     * Laskee kolmion hypotenuusan
     * @param pituus Kolmion sivun pituus
     * @param korkeus Kolmion sivun korkeus
     * @return Kolmion hypotenuusa
     */
    public static double hypotenuusa(double pituus, double korkeus){
        return Math.sqrt((pituus * pituus) + (korkeus * korkeus));
    }
}