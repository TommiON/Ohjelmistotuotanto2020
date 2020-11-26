package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;

public class Nollaa extends Komento {

    private Sovelluslogiikka sovellus;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
    }

    @Override
    public void suorita () {
        sovellus.nollaa();
    }
}