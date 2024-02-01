package demo.d4;

public class Demo {

    /**
     * @param pisteet Tehdyt demo pisteet
     * @param maksimi Demojen maksimipisteet
     * @return Demopisteiden hyvityspisteet
     */
    public static int demohyvitys(int pisteet, int maksimi) {
        if (pisteet < 0 || maksimi < 0)
            throw new IllegalArgumentException("Pisteet tai maksimi ei voi olla negatiivinen tai nolla.");
        double prosentit = (double) pisteet / maksimi;
        if (prosentit >= 0.9)
            return 6;
        else if (prosentit >= 0.8) {
            return 5;
        } else if (prosentit >= 0.7) {
            return 4;
        } else if (prosentit >= 0.6) {
            return 3;
        } else if (prosentit >= 0.5) {
            return 2;
        } else if (prosentit >= 0.4) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
        System.out.println("Demopisteet: " + demohyvitys(5, 5));
    }
}
