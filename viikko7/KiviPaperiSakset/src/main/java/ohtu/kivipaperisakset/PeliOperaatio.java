package ohtu.kivipaperisakset;
import java.util.Scanner;


public abstract class PeliOperaatio {
    protected static final Scanner scanner = new Scanner(System.in);    
    private Tuomari tuomari;
    protected String ekanSiirto;
    protected String tokanSiirto;
    
    public PeliOperaatio() {
        this.tuomari = new Tuomari();        
    }
    
    public void pelaa() {        
        pelaajanSiirto();
        vastustajanSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomitse();
            pelaajanSiirto();
            vastustajanSiirto();
        }
        
        paataPeli();
    }   
    
    private void pelaajanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = scanner.nextLine();
    }
    
    protected abstract void vastustajanSiirto();
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    private void tuomitse() {
        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        System.out.println(tuomari);
        System.out.println();
    }
    
    private void paataPeli() {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}
