package demo.d4;

import java.util.Scanner;

public class Automaatti {

    private char tila;


    /**
     * Alustetaan automaatti haluttuun tilaan
     * @param tila automaatin tila
     */
    public Automaatti(char tila) {
        this.tila = tila;
    }

    /**
     * Muuttaa automaatissa olevaa tilaa
     * @param merkki syötetty merkki
     */
    public void syota(char merkki) {
        switch (tila) {
            case 'A':
                if (merkki == '0') {
                    tila = 'B';
                }
                break;
            case 'B':
                if ( merkki == '0') {
                    tila = 'C';
                }
                break;
            case 'C':
                if ( merkki == '0') {
                    tila = 'A';
                }
                break;
        }
    }

    /**
     * @param a Automaatti
     * @param jono Merkkijono
     * @return true jos jono hyväksytään, muuten false
     */
    public static boolean tutkiJono(Automaatti a, String jono) {
        if (jono.isEmpty()) return true; // Tila on A edelleen
        for (int i = 0; i < jono.length(); i++) {
            a.syota(jono.charAt(i));
        }
        if (a.tila != 'A') {
            a.tila = 'A';
            return false;
        }
        return true;
    }

    /**
     * @return luetaan käyttäjältä merkkijono
     */
    public static String readInput() {
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        } catch (Exception e) {
            return "Failed to read input";
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Automaatti a = new Automaatti('A');
        System.out.println("Tutki jono: " + tutkiJono(a,"011")); // true
        System.out.println("Tutki jono: " + tutkiJono(a,"01001")); // true
        System.out.println("Tutki jono: " + tutkiJono(a,"01000")); // false

        if (args.length != 0) {
            System.out.println("Tutki jono: " + args[0] + " Hyväksyykö? " + tutkiJono(a,args[0]));
        }
    }


}
