package demo.d2;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lukumaara {



    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna rivi: ");
        String rivi = lukija.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(rivi);
        int lkm = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals("kissa")) {
                lkm++;
            }
        }
        System.out.println("Rivillä oli " + lkm + " \"kissa\"-sanaa.");
    }
}
