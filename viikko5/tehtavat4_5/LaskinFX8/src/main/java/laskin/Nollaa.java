package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;

public class Nollaa extends Komento {

    private Sovelluslogiikka sovellus;
    private int arvoEnnenNollausta;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.arvoEnnenNollausta = 0;
    }

    @Override
    public void suorita () {
        this.arvoEnnenNollausta = sovellus.tulos();
        sovellus.nollaa();
    }

    @Override
    public void peru() {
        sovellus.plus(this.arvoEnnenNollausta);
    }
}