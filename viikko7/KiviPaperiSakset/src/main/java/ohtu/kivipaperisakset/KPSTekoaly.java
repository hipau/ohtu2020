package ohtu.kivipaperisakset;
import java.util.Scanner;

public class KPSTekoaly extends PeliOperaatio {    
    private Tekoaly tekoaly;
    
    public KPSTekoaly() {
        tekoaly = new Tekoaly();
    }
    
    @Override
    protected void vastustajanSiirto() {
        super.tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + super.tokanSiirto);
        tekoaly.asetaSiirto(super.ekanSiirto);
    }    
}