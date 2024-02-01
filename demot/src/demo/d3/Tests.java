package demo.d3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static demo.d3.Esiintymat.poistaEsiintymat;
import static demo.d3.Jarjesta.jarjesta1ja2;
import static demo.d3.Jokerimerkki.onkoSamatKysymysmerkilla;
import static demo.d3.Etusuku.vaihdaAlkuLoppu;
import static demo.d3.Jarjesta.jarjesta;

@DisplayName("Demo 3 testit")
public class Tests {
    @Test
    void JokerimerkkiTests() {
        String jono = "abba";
        String maski = "a??a";
        String maski2 = "a?ba";
        String maski3 = "a?b?";
        String maski4 = "";
        assert onkoSamatKysymysmerkilla(jono,maski);
        assert onkoSamatKysymysmerkilla(jono,maski2);
        assert onkoSamatKysymysmerkilla(jono,maski3);
        assert !onkoSamatKysymysmerkilla(jono,maski4);
        assert onkoSamatKysymysmerkilla(jono, jono);
        assert onkoSamatKysymysmerkilla(maski4,maski4);
    }

    @Test
    void EsiintymatTests() {
        String jono = "paatti";
        String poistettava = "at";
        assert poistaEsiintymat(jono, poistettava).equals("pi");
        assert poistaEsiintymat("kissa", "ss").equals("kia");
        assert poistaEsiintymat("catcat", "at").equals("cc");
        assert poistaEsiintymat("paatti", "at").equals("pi");
        assert poistaEsiintymat("paatti", "paatti").isEmpty();
        assert poistaEsiintymat("paatti", "").equals("paatti");

    }

    @Test
    void PvmTests() {
        Pvm p1 = new Pvm(21, 1,  2015);
        Pvm p2 = new Pvm(12, 12, 2012);
        Pvm p3 = new Pvm(19, 8,  1990);
        assert p1.toString().equals("21.1.2015");
        assert p2.toString().equals("12.12.2012");
        assert p3.toString().equals("19.8.1990");
        assert !p1.toString().equals("21.1.2016");
        assert !p2.toString().equals("12.12.2013");
    }

    @Test
    void EtusukuTests() {
        String nimi = "Matti Meikäläinen";
        String nimi2 = "Meikäläinen Matti";
        String nimi3 = "Matti";
        String nimi4 = "Matti Juhani Meikäläinen";
        String nimi5 = "Meikäläinen Matti Juhani";

        assert vaihdaAlkuLoppu(nimi, true).equals("Meikäläinen Matti");
        assert vaihdaAlkuLoppu(nimi2, false).equals("Matti Meikäläinen");

        assert vaihdaAlkuLoppu(nimi3, false).equals("Matti");
        assert vaihdaAlkuLoppu(nimi3, true).equals("Matti");

        assert vaihdaAlkuLoppu(nimi4, true).equals("Meikäläinen Matti Juhani");

        assert vaihdaAlkuLoppu(nimi5, false).equals("Matti Juhani Meikäläinen");

        assert vaihdaAlkuLoppu("", false).isEmpty();
        assert vaihdaAlkuLoppu("", true).isEmpty();

    }

    @Test
    void JarjestaTests() {
        assert jarjesta("abba").equals("aabb");
        assert jarjesta("kissa").equals("aikss");
        assert jarjesta("catcat").equals("aacctt");
        assert jarjesta("").isEmpty();
        assert jarjesta("a").equals("a");

        assert jarjesta1ja2("abba kissa").equals("aabb aikss");
        assert jarjesta1ja2("kissa").equals("Liian vähän sanoja");
        assert jarjesta1ja2("").equals("Liian vähän sanoja");
        assert jarjesta1ja2("abba kissa catcat").equals("aabb aikss");

    }
}
