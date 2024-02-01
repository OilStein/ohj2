package demo.d4.guru;

public class Solmu {
    private final char nimi;
    // Jos on pääsolmu, automaatti hyväksyy merkkijonon, jos ollaan tässä solmussa
    private final boolean paasolmu;
    private Solmu seuraavaSolmu;

    public Solmu(char nimi, boolean paasolmu) {
        this.nimi = nimi;
        this.paasolmu = paasolmu;
        this.seuraavaSolmu = null;
    }

    public void kytkeSeuraavaan(Solmu solmu) {
        this.seuraavaSolmu = solmu;
    }

    public Solmu getSeuraavaSolmu() {
        return seuraavaSolmu;
    }

    public boolean isPaasolmu() {
        return paasolmu;
    }
}
