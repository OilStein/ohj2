package demo.d3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tiedosto {

    public static String removeHTML(String s) {
        return s.replaceAll("<[^>]*>", "");
    }

    public static String readFile(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        StringBuilder sb = new StringBuilder();
        while (input.hasNextLine()) {
            String line = removeHTML(input.nextLine());
            if (line.isEmpty()) continue;
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            String s = "/Users/niko/Documents/java/ohj2/ohj2/demot/src/demo/d3/users.html";
            String s2 = readFile(s);
            System.out.println(s2);
        }
        catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy");
        }
    }
}
