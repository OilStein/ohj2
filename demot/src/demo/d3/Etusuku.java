package demo.d3;

public class Etusuku {

    public static String erota(StringBuilder jono, char merkki, boolean etsitakaperin) {
        int p;
        if (!etsitakaperin)
            p = jono.indexOf("" + merkki); // NOPMD
        else
            p = jono.lastIndexOf("" + merkki);
        String alku;
        if (p < 0) {
            alku = jono.toString();
            jono.delete(0, jono.length());
            return alku;
        }
        alku = jono.substring(0, p);
        jono.delete(0, p + 1);
        return alku;
    }

    /**
     *
     * @param nimi nimi
     * @param katko true jos etunimi, false jos sukunimi
     * @return nimi jossa etu- ja sukunimi vaihdettu keskenään
     */
    public static String vaihdaAlkuLoppu(String nimi, boolean katko) {
        StringBuilder sukunimi = new StringBuilder(nimi);
        String etunimet = erota(sukunimi, ' ', katko);
        if ( sukunimi.isEmpty()) return etunimet;
        return sukunimi + " " + etunimet;
    }

    public static void main(String[] args) {
        String nimi = "Matti Meikäläinen";
        System.out.println(vaihdaAlkuLoppu(nimi, true));
        String nimi2 = "Meikäläinen Matti";
        System.out.println(vaihdaAlkuLoppu(nimi2, false));
        String nimi3 = "Matti";
        System.out.println(vaihdaAlkuLoppu(nimi3, true));
        String nimi4 = "Matti Juhani Meikäläinen";
        System.out.println(vaihdaAlkuLoppu(nimi4, true));
        String nimi5 = "Meikäläinen Matti Juhani ";
        System.out.println(vaihdaAlkuLoppu(nimi5, false));

    }
}
