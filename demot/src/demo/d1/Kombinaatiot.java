package demo.d1;

import java.util.ArrayList;
import java.util.List;

public class Kombinaatiot {

    public static void main(String[] args) {
        int vareja = 3;
        int ekakoko = 4;
        int tokakoko = 2;

        List<Integer> varienJoukko = new ArrayList<>();
        for (int i=0; i<vareja; i++) varienJoukko.add(i);
        List<List<Integer>> kaikkiJoukot = etsiKombinaatiot(ekakoko+tokakoko,varienJoukko);
        for (List<Integer> kombi : kaikkiJoukot) {
            System.out.println(kombi);
        }


    }

    public static<T> List<List<T>> etsiKombinaatiot(int n, List<T> valinnat) {
        List<List<T>> tulos = new ArrayList<>();
        int[] indeksit = new int[n]; // alustettu 0:illa
        int m = valinnat.size();
        do {
            List<T> rivi = new ArrayList<>();
            for (int i : indeksit)
                rivi.add(valinnat.get(i));
            tulos.add(rivi);
        } while (kasvata(indeksit, m));
        return tulos;
    }

    public static boolean kasvata(int[] numerot, int m) {
        int n = numerot.length;
        for (int i=n-1; i>=0; i--) {
            numerot[i]++;
            if ( numerot[i] < m ) return true;
            numerot[i] = 0;
        }
        return numerot[0] != 0;
    }

}
