package demo.d4;

public class Tarkkuus {

    /**
     * Palauttaa -1, 0, 1 riippuen mille välille x kuuluu
     * @param x Tarkasteltava luku
     * @param esp Väli
     * @return -1, 0, 1
     */
    public static int etumerkki(double x, double esp) {
        if (esp < 0) {
            throw new IllegalArgumentException("Tarkkuus ei voi olla negatiivinen");
        }
        if (x < -esp) {
            return -1;
        } else if (-esp <= x && x <= esp) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        System.out.println("Syöte: 1, 1: " + etumerkki(1, 1) + " On 0");
        System.out.println("Syöte: 0, 1: " + etumerkki(0, 1) + " On 0");
        System.out.println("Syöte: -1, 1: " + etumerkki(-1, 1) + " On 0");
        System.out.println("Syöte: 10, 1: " + etumerkki(10, 1) + " On 1");
        System.out.println("Syöte: -10, 1: " + etumerkki(-10, 1) + " On -1");

    }
}
