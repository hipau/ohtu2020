package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Operaatio extends Komento {
    public Operaatio(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        int arvo = 0;        
        try {
            arvo = Integer.parseInt(tuloskentta.getText());
        } catch(Exception e) {
        }
        super.edellinen = arvo;
                
        laske();

        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
    
    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinen);
        syotekentta.setText("");
        tuloskentta.setText("" + super.edellinen);
    }
    
    protected abstract void laske();
    
    
}
