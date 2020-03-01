package ohtu.kivipaperisakset;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends PeliOperaatio {    
    private TekoalyParannettu tekoaly;
    
    public KPSParempiTekoaly() {
        tekoaly = new TekoalyParannettu(20);
    }
    
    @Override
    protected void vastustajanSiirto() {
        super.tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + super.tokanSiirto);
        tekoaly.asetaSiirto(super.ekanSiirto);
    }
}
