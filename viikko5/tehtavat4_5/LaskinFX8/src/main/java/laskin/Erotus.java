package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;

public class Erotus extends Komento {
    private TextField syotekentta;
    private Sovelluslogiikka sovellus;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
    }
}