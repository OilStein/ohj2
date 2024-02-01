package demo.d4;

public class Henkilo {

    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;

    /**
     * Konstruktori
     * @param etunimi henkilön etunimi
     * @param sukunimi henkilön sukunimi
     * @param syntymavuosi henkilön syntymävuosi
     */
    public Henkilo(String etunimi, String sukunimi, int syntymavuosi) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi = syntymavuosi;
    }

    /**
     * Palauttaa henkilön nimen
     * @return henkilön nimi
     */
    public String getNimi() {
        return etunimi + " " + sukunimi;
    }

    /**
     * Palauttaa henkilön syntymävuoden
     * @return henkilön syntymävuosi
     */
    public int getSyntymavuosi() {
        return syntymavuosi;
    }

    /**
     * Palauttaa henkilön tiedot merkkijonona
     * @return henkilön tiedot
     */
    @Override
    public String toString() {
        return etunimi + "|" + sukunimi + "|" + syntymavuosi;
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);
        System.out.println(aku.getNimi());  // tulostaa Aku Ankka
        System.out.println(aku.getSyntymavuosi());  // tulostaa 1934
        System.out.println(aku.toString()); // tulostaa Aku|Ankka|1934
    }
}
