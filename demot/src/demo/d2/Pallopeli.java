package demo.d2;

import java.util.ArrayList;
import java.util.List;
import static demo.d1.Kombinaatiot.*;


public class Pallopeli {


    public static void main(String[] args) {
        int vareja = 3;
        int ekakoko = 4;
        int tokakoko = 2;
        List<Integer> varienJoukko = new ArrayList<Integer>();
        for (int i=0; i<vareja; i++) varienJoukko.add(i);
        List<List<Integer>> kaikkiJoukot = etsiKombinaatiot(ekakoko+tokakoko,varienJoukko);
        int n = kaikkiJoukot.size();
        List<List<Integer>> voittavatJoukot = etsiVoitot(tokakoko,kaikkiJoukot);
        int m = voittavatJoukot.size();
        System.out.printf("%d/%d = %7.5f",m,n,1.0*m/n);
    }


    public static<T> List<List<T>> etsiVoitot(int k,
                                              List<List<T>> kombit) {
        List<List<T>> tulos = new ArrayList<List<T>>();
        for (List<T> rivi:kombit)
            if ( voitto(k,rivi) )
                tulos.add(rivi);
        return tulos;
    }

    /**
     * Tutkii voittako rivillä rivi.  Rivillä voittaa jos
     * sen k ensimmäistä alkiota ovat lopuissa alkioissa mukana.
     * @param k monta alkiota rivin alusta otetaan
     * @param rivi tutkittava rivi
     * @return true jos voitto
     * @example
     * <pre name="test">
     * #import java.util.List;
     * #import java.util.Arrays;
     *   List<Integer> rivi = Arrays.asList(0,1,  1,0,1,2);
     *   voitto(1,rivi) === true;
     *   voitto(2,rivi) === true;
     *   voitto(3,rivi) === false;
     *   rivi = Arrays.asList( 1,1,  1,0,0,2);
     *   voitto(1,rivi) === true;
     *   voitto(2,rivi) === false;
     * </pre>
     */
    public static<T> boolean voitto(int k,List<T> rivi) {
        if ( k > rivi.size()/2 ) return false; // ei voi voittaa jos k on yli puolet
        // Otetaan kopio loppurivin palloista, niin tuota saa muokata rikkomatta riviä
        @SuppressWarnings("unused") // TODO: poista tämä rivin kun toteutat
        List<T> tutkittava = new ArrayList<T>(rivi.subList(k, rivi.size()));
        int n = 0;
        for (int i=0; i<k; i++) {
            for (int j=0; j<tutkittava.size(); j++) {
                if ( rivi.get(i).equals(tutkittava.get(j)) ) {
                    tutkittava.remove(j);
                    n++;
                    break;
                }
            }
        }

        return n == k;
    }

}

