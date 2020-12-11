package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    @Override
    protected String pelaajaBsiirto(String vastustajanSiirto) {
        io.tulosta("Toisen pelaajan siirto: ");
        return io.kysy();
    }
}