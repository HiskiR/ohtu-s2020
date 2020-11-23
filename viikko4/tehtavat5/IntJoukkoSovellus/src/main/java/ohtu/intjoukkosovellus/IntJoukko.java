
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5; // luotava uusi taulukko on
    // näin paljon isompi kuin vanha
    private int kasvatuskoko; // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono; // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLkm; // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm >= ljono.length) {
                kasvataTaulukkoa(ljono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                ljono[i] = 0;
                siirraAlkiot(i);
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    public void siirraAlkiot(int indeksi) {
        for (int i = indeksi; i < alkioidenLkm - 1; i++) {
            int poistettu = ljono[i];
            ljono[i] = ljono[i + 1];
            ljono[i + 1] = poistettu;
        }
    }

    private void kasvataTaulukkoa(int[] taulukko) {
        ljono = new int[taulukko.length + kasvatuskoko];
        for (int i = 0; i < taulukko.length; i++) {
            ljono[i] = taulukko[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += ljono[i];
            if (i < alkioidenLkm - 1) {
                tuotos += ", ";
            }
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        for (int aLuku : a.toIntArray()) {
            yhdiste.lisaa(aLuku);
        }
        for (int bLuku : b.toIntArray()) {
            yhdiste.lisaa(bLuku);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        for (int aLuku : a.toIntArray()) {
            for (int bLuku : b.toIntArray()) {
                if (aLuku == bLuku) {
                    leikkaus.lisaa(aLuku);
                }
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        for (int aLuku : a.toIntArray()) {
            erotus.lisaa(aLuku);
        }
        for (int bLuku : b.toIntArray()) {
            erotus.poista(bLuku);
        }
        return erotus;
    }

}
