package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements Rahalaitos {

    private static Pankki instanssi;

    public static Pankki getInstance() {
        if (instanssi == null) {
            instanssi = new Pankki();
        }

        return instanssi;
    }
    
    @Autowired
    private Tapahtumaloki tapahtumaloki;

    public Pankki() {        
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        tapahtumaloki.lisaaTapahtuma("tilisiirto: tililtä " + tililta + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
