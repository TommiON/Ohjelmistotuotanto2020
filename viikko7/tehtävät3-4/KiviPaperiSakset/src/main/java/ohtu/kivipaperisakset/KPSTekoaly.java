package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {

    Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String pelaajaBsiirto(String vastustajanSiirto) {
        String siirto = tekoaly.annaSiirto();
        io.tulostaRivinvaihdolla("Tietokone valitsi: " + siirto);
        return siirto;
    }
}