package ohtu.verkkokauppa;

public class Kauppa {

    private Sailytystila sailytystila;
    private Rahalaitos rahalaitos;
    private Ostoskori ostoskori;
    private Numerogeneraattori numerogeneraattori;
    private String kaupanTili;

    public Kauppa(Sailytystila sailytystila, Rahalaitos rahalaitos, Numerogeneraattori numerogeneraattori) {
        this.sailytystila = sailytystila;
        this.rahalaitos = rahalaitos;
        this.numerogeneraattori = numerogeneraattori;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = sailytystila.haeTuote(id); 
        sailytystila.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (sailytystila.saldo(id)>0) {
            Tuote t = sailytystila.haeTuote(id);             
            ostoskori.lisaa(t);
            sailytystila.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = numerogeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return rahalaitos.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
