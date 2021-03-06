package ohtu.verkkokauppa;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements Rahalaitos {

    private Tilioiva kirjanpito;

    public Pankki(Tilioiva kirj) {
        kirjanpito = kirj;
    }

    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
