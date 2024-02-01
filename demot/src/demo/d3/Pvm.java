package demo.d3;

public class Pvm {

    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Pvm(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    public String toString() {
        return paiva + "." + kuukausi + "." + vuosi;
    }

    public static void main(String[] args) {
        Pvm p1 = new Pvm(21, 1,  2015);
        Pvm p2 = new Pvm(12, 12, 2012);
        Pvm p3 = new Pvm(19, 8,  1990);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

}
