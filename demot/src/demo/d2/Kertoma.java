package demo.d2;
public class Kertoma {

    public int powerDoWhile(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int result = 1;
        int help = n;
        do {
            result *= help;
            help--;
        } while (help > 0);
        return result;
    }

    public int powerWhile(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int result = 1;
        int help = n;
        while (help > 0) {
            result *= help;
            help--;
        }
        return result;
    }

    public static void main(String[] args) {
        Kertoma k = new Kertoma();
        System.out.println(k.powerDoWhile(6));
        System.out.println(k.powerWhile(5));
    }

}
