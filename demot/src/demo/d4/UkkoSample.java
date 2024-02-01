package demo.d4;

import java.awt.Color;
import fi.jyu.mit.graphics.*;


public class UkkoSample {

    /**
     * Ukko-luokka josta saadaa viite toiseen käteen
     * @author vesal
     */
    public static class Ukko extends DrawableCollection {
        private final Drawable kasiO;
        private final Drawable kasiV;

        private final Drawable jalkaO;
        private final Drawable jalkaV;


        /**
         * Alustetaan ukko haluttuun paikkaa
         * @param dx ukon pään keskipiste
         * @param dy ukon pään keskipiste
         */
        public Ukko(double dx, double dy) {
            super();
            move(dx, dy, 0.0);
            add(new Circle(0, 0, 20)); // pää
            add(new Line(0, 0, 0, 100)).move(0, 20, 0); // vartalo
            kasiO = add(new Line(0, 0, 0, 90)).move(0, 30, 0).rotate(Axis.Z, 30);
            kasiV = add(new Line(0, 0, 0, 90)).move(0, 30, 0).rotate(Axis.Z, -130);
            jalkaV = add(new Line(0, 0, 0, 100)).move(0, 120, 0).rotate(Axis.Z, 25);
            jalkaO = add(new Line(0, 0, 0, 100)).move(0, 120, 0).rotate(Axis.Z, -25);
        }


        /**
         * Alustetaan ukko haluttuun paikkaan ja kokoon
         * @param dx ukon pään keskipiste
         * @param dy ukon pään keskipiste
         * @param s  ukon skaalauskerroin
         * @param deg ukon kiertokulma Z-akselin suhteen
         * @param color ukon väri
         */
        public Ukko(double dx, double dy, double s, double deg, Color color) {
            this(dx, dy);
            if (s != 1) scale(s, s, s);
            if (deg != 0) rotate(Axis.Z, deg);
            if (color != null) setColor(color);
        }


        /**
         * @return palautetaan viite ukon oikeaan käteen
         */
        public Drawable getKasiO() {
            return kasiO;
        }

        /**
         * @return palautetaan viite ukon vasempaan käteen
         */
        public Drawable getKasiV() {
            return kasiV;
        }


        /**
         * @return palautetaan viite ukon oikeaan jalkaan
         */
        public Drawable getJalkaO() {
            return jalkaO;
        }

        /**
         * @return palautetaan viite ukon vasempaan jalkaan
         */
        public Drawable getJalkaV() {
            return jalkaV;
        }

    }

    /**
     * Pistää ukon raajan vispaan
     * @param ukko ukko-olio
     */
    public static void ukkoHeiluu(Ukko ukko) {
        new Rotator(ukko.getKasiO(), Axis.Z, 5, 230);
        new Rotator(ukko.getJalkaO(), Axis.Z, -5, 400);
        new Rotator(ukko.getKasiV(), Axis.Z, 5, 230);
        new Rotator(ukko.getJalkaV(), Axis.Z, -5, 270);
    }


    /**
     * @param args ei käytössä
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Window window = new Window();

        // window.add(new Ukko(60, 60));
        Ukko pukko = new Ukko(160, 60, 0.5, 0, Color.RED);
        window.add(pukko);
       // Drawable oukko = window.add(new Ukko(260, 60, 0.3, 0, Color.ORANGE));
        window.showWindow();
        //Ukko ukko = new Ukko(260, 180, 0.3, 0, null);
        //window.add(ukko);

        //new Rotator(ukko, Axis.Z, 3, 200);
       // new Rotator(ukko.getKasi(), Axis.Z, 5, 230);
       // new Mover(oukko, 2, 3, 0, 300);
       // new Rotator(oukko, Axis.Y, 10, 230);

        // window.scale(0.5,2, 1);

        // Esimerkki ukon siirtamisesta hiiren kohdalle.
        new MouseFollower(window.getPanel(), pukko, 0, 0, 0, true);

        // window.getPanel().setBackground(Color.CYAN);
        window.setTitle("Ukot heiluu");

        ukkoHeiluu(pukko);
    }

}