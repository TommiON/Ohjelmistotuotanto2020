package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Tilioiva {

    public void lisaaTapahtuma(String tapahtuma);

    public ArrayList<String> getTapahtumat();

}