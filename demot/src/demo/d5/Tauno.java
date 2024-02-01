package demo.d5;

import java.util.Arrays;

public class Tauno {


        public static void main(String[] args)  {
            int[] t = { 23, 45, 12, 9, 3, 7 };
            System.out.println("Aluksi : " + Arrays.toString(t));
            KasitteleTaulukko(t);
            System.out.println("Lopuksi: " + Arrays.toString(t));


            System.out.println("Aluksi : " + Arrays.toString(t));
            KasitteleTaulukko1(t);
            System.out.println("Lopuksi: " + Arrays.toString(t));
        }


        /**
         * Kääntää taulukon sisällön
         * @param t käsiteltävä taulukko
         */
        public static void KasitteleTaulukko(int[] t) {
            int i = 0;
            int j = t.length - 1;
            while (i < j) {
                int apu = t[i];
                t[i] = t[j];
                t[j] = apu;
                i++;
                j--;
            }
        }




    /**
     * Kääntää taulukossa vierekkäiset alkiot
     * @param t käsiteltävä taulukko
     */
    static void KasitteleTaulukko1(int[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            int apu = t[i];
            t[i] = t[i + 1];
            t[i + 1] = apu;
            i++;
        }
    }
}
