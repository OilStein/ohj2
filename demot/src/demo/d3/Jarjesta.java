package demo.d3;

import java.util.Scanner;

public class Jarjesta {

    public static String jarjesta1ja2(String s1) {
        String[] sanat = s1.split(" ");
        if (sanat.length < 2) {
            return "Liian vähän sanoja";
        }
        return jarjesta(sanat[0]) + " " + jarjesta(sanat[1]);
    }

    public static String jarjesta(String sana) {
        if (sana.isEmpty()) return "";
        char[] merkit = sana.toCharArray();
        for (int i = 0; i < merkit.length; i++) {
            for (int j = i + 1; j < merkit.length; j++) {
                if (merkit[i] > merkit[j]) {
                    char tmp = merkit[i];
                    merkit[i] = merkit[j];
                    merkit[j] = tmp;
                }
            }
        }
        return new String(merkit);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Anna merkkijono: ");
        String s1 = input.nextLine();

        System.out.println(jarjesta1ja2(s1));
    }

}
