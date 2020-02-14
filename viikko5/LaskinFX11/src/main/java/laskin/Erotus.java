package laskin;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Operaatio {    
    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void laske() {
        int arvo = 0;        
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch(Exception e) {
        }        
        sovellus.miinus(arvo);
    }    
}
