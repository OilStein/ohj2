package demo.d2;

public class Transitiivisuus {


    public static void main(String[] args) {
        String a1 = "Matti";
        String a2 = "Matti";
        String a3 = "Matti";
        boolean b = a1.equals(a2);


        if (a1.equals(a3)) {
            System.out.println("a1 == a3");
        }
    }

}
