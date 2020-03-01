package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeli {
    
    @Override
    protected void vastustajanSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        super.tokanSiirto = super.scanner.nextLine();
    }
}