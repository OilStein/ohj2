package demo.d2;
public class Etusuku {

    public static String vaihdaEtuSuku(String nimi) {
        if (nimi.trim().isEmpty()) return "";
        if (!nimi.contains(" ")) return nimi;
        String etunimi = nimi.substring(0, nimi.lastIndexOf(" "));
        String sukunimi = nimi.substring(nimi.lastIndexOf(" ") + 1);
        return sukunimi + " " + etunimi;
    }

    public static String vaihdaSukuEtu(String nimi)  {
        if (nimi.trim().isEmpty()) return "";
        if (!nimi.contains(" ")) return nimi;
        String sukunimi = nimi.substring(0, nimi.indexOf(" "));
        String etunimi = nimi.substring(nimi.indexOf(" ") + 1);
        return etunimi + " " + sukunimi;
    }

    public static void main(String[] args) {
        System.out.println(vaihdaEtuSuku("Matti Juha Meikäläinen"));
        System.out.println(vaihdaSukuEtu("Meikäläinen Matti Juha"));
        System.out.println(vaihdaSukuEtu("Palo Jukka Pekka"));
        System.out.println(vaihdaEtuSuku("Jukka Pekka Palo"));
    }
}
