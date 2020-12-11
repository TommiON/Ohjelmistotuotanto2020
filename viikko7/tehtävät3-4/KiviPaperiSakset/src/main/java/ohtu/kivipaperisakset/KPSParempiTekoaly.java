package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

public class KPSParempiTekoaly extends KiviPaperiSakset {
    
    TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String pelaajaBsiirto(String vastustajanSiirto) {
        String siirto = tekoaly.annaSiirto();
        tekoaly.asetaSiirto(vastustajanSiirto);
        io.tulostaRivinvaihdolla("Tietokone valitsi: " + siirto);
        return siirto;
    }
}
