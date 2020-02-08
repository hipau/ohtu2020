
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukonLuvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);        
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) return;
        joukonLuvut = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukonLuvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            kasvataTarvittaessa();
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukonLuvut[i]) return true;                
        }
        return false;
    }
    
    private int etsiLuvunIndeksi(int luku) {
        for(int i = 0; i < alkioidenLkm; i++) {
            if(luku == joukonLuvut[i])
                return i;
        }
        return -1;
    }

    public boolean poista(int luku) {
        int poistettavanIndeksi = etsiLuvunIndeksi(luku);
        if(poistettavanIndeksi >= 0) {
            for (int j = poistettavanIndeksi; j < alkioidenLkm - 1; j++) {
                joukonLuvut[j] = joukonLuvut[j + 1];
            }
            alkioidenLkm--;
            return true;
        }        
        return false;
    }
    
    private void kasvataTarvittaessa() {
        if (alkioidenLkm == joukonLuvut.length) {
            int[] uusiTaulukko = new int[alkioidenLkm + kasvatuskoko];
            System.arraycopy(joukonLuvut, 0, uusiTaulukko, 0, joukonLuvut.length);
            joukonLuvut = uusiTaulukko;
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {        
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += joukonLuvut[i];
            tuotos += ", ";
        }
        if(alkioidenLkm > 0) tuotos += joukonLuvut[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(joukonLuvut, 0, taulu, 0, alkioidenLkm);
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko(a.mahtavuus() + b.mahtavuus());
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdisteJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdisteJoukko.lisaa(bTaulu[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();        
        for (int i = 0; i < aTaulu.length; i++) {
            if(b.kuuluu(aTaulu[i])) leikkausJoukko.lisaa(aTaulu[i]);            
        }
        return leikkausJoukko;
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotusJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(bTaulu[i]);
        } 
        return erotusJoukko;
    }
        
}
