package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.HashMap;
import java.util.Map;

public class Summa extends Komento {
    private TextField syotekentta;
    private Sovelluslogiikka sovellus;
    private int viimeisinMuutos;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
        this.viimeisinMuutos = 0;
    }
    
    @Override
    public void suorita() {
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        this.viimeisinMuutos = Integer.parseInt(syotekentta.getText());
    }

    @Override
    public void peru() {
        sovellus.miinus(this.viimeisinMuutos);
    }
}