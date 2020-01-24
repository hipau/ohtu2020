package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Tapahtumaloki {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
