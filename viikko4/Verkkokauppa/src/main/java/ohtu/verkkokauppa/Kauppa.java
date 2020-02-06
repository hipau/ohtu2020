package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    private VarastoInterface varasto;
    private PankkiInterface pankki;
    private Ostoskori ostoskori;
    private ViitegeneraattoriInterface viitegeneraattori;
    private String kaupanTili;

    @Autowired
    public Kauppa(VarastoInterface varasto, PankkiInterface pankki, ViitegeneraattoriInterface viitegeneraattori) {
        this.varasto = varasto;
        this.pankki = pankki;
        this.viitegeneraattori = viitegeneraattori;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        // Oletan että metodin saa korjata, eihän tässä poistamisessa muuten ole järkeä.
        // Jos ostoskori.poista() palauttaisi tiedon onnistuiko poisto (remove-metodin
        // paluuarvo!) voisi tämän toteuttaa elegantimminkin, kun ei tarvitsisi muuta
        // kuin tarkistaa paluuarvo jotta tietää voiko varastoon palauttaa.      
        Tuote t = varasto.haeTuote(id);
                
        for(Tuote ostoskorinTuote : ostoskori.tuotteet) {
            if(t.equals(ostoskorinTuote)) {
                ostoskori.poista(t);
                varasto.palautaVarastoon(t);
                break;
            }
        }
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
