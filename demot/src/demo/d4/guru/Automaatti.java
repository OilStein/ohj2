package demo.d4.guru;

public class Automaatti {

    private Solmu tila;

    /**
     * Luo uuden automaatin
     */
    public Automaatti() {
        tila = null;
    }

    /**
     * Asettaa tilan automaatissa
     * @param tila Solmu
     */
    public void setTila(Solmu tila) {
        this.tila = tila;
    }

    /**
     * Vaihtaa tilaa automaatissa seuraavaan solmuun
     */
    public void vaihdaTila() {
        this.tila = tila.getSeuraavaSolmu();
    }

    /**
     * Tutkii merkkijonon
     * @param jono Merkkijono
     * @return true, jos merkkijono hyväksytään
     */
    public boolean tutkiJono(String jono) {
        if (jono.isEmpty()) {
            return true;
        }
        for (int i = 0; i < jono.length(); i++) {
            if (jono.charAt(i) == '0') {
                vaihdaTila();
            }
        }
        return tila.isPaasolmu();
    }



    public static void main(String[] args) {
        Automaatti a = new Automaatti();
        Solmu s1 = new Solmu('A', true);
        Solmu s2 = new Solmu('B', false);
        Solmu s3 = new Solmu('C', false);
        s1.kytkeSeuraavaan(s2);
        s2.kytkeSeuraavaan(s3);
        s3.kytkeSeuraavaan(s1);
        a.setTila(s1); // Aloitus solmu


        System.out.println(a.tutkiJono("011")); // false
        a.setTila(s1);
        System.out.println(a.tutkiJono("00110")); // true
        a.setTila(s1);
        System.out.println(a.tutkiJono("001100")); // false
        a.setTila(s1);
        System.out.println(a.tutkiJono("0011000")); // false
        a.setTila(s1);
        System.out.println(a.tutkiJono("10010")); // true

        if (args.length != 0) {
            System.out.println("Tutki jono: " + args[0] + " Hyväksyykö? " + a.tutkiJono(args[0]));
        }
    }
}
