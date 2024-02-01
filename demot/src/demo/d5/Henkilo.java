package demo.d5;

import java.io.*;
import fi.jyu.mit.ohj2.*;

/**
 * Henkilo-luokka.  Henkilöllä on nimi ja syntymävuosi.
 * @author Vesa Lappalainen
 * @version 1.0, 07.02.2003
 */
public class Henkilo {
    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;


    public Henkilo(String etunimi, String sukunimi, int syntymavuosi) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi = syntymavuosi;
    }




    @Override
    public String toString() {
        return etunimi + "|" + sukunimi + "|" + syntymavuosi;
    }


    public String getNimi() {
        return (etunimi + " " + sukunimi).trim();
    }

    public int getSyntymavuosi() {
        return syntymavuosi;
    }


    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        out.println(etunimi + " " + sukunimi + " " + syntymavuosi);
    }

    /**
     * Tyhjä konstruktori
     */
    public Henkilo() {
        etunimi = "";
        sukunimi = "";
        syntymavuosi = 0;
    }

    /**
     * Kontruktoidaan henkilö merkkijonosta
     * @param rivi parsittava merkkijono
     */
    public Henkilo(String rivi) {
        parse(rivi);
    }

    /**
     * Parsitaan henkilön tiedot merkkijonosta
     * @param rivi parsittava merkkijono
     */
    public void parse(String rivi) {
        String[] palat = rivi.split("[|]");
        if (palat.length >= 2) {
            etunimi = palat[0];
            sukunimi = palat[1];
        }
        if (palat.length == 3) syntymavuosi = Integer.parseInt(palat[2]);
    }

    /**
     * Testataan henkilöluokkaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Henkilo hlo = new Henkilo();
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);
        System.out.println(hlo);
        hlo.parse("Sepe|Susi|1933");
        hlo.tulosta(System.out);
        aku.tulosta(System.out);
        Henkilo mikki = new Henkilo("Mikki|Hiiri");
        System.out.println(mikki);
    }
}



