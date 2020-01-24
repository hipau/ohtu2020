package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {
    
    @Autowired
    private Sailytystila sailytystila;
    @Autowired
    private Rahalaitos rahalaitos;
    @Autowired
    private Kori kori;
    @Autowired
    private Numerogeneraattori numerogeneraattori;
    private String kaupanTili;

    public Kauppa() {
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {        
    }

    public void poistaKorista(int id) {
        Tuote t = sailytystila.haeTuote(id); 
        sailytystila.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (sailytystila.saldo(id)>0) {
            Tuote t = sailytystila.haeTuote(id);             
            kori.lisaa(t);
            sailytystila.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = numerogeneraattori.uusi();
        int summa = kori.hinta();
        
        return rahalaitos.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
