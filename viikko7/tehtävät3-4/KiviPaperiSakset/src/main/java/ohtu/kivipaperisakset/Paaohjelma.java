package ohtu.kivipaperisakset;

public class Paaohjelma {

    private static final IO io = new KonsoliIO();

    public static void main(String[] args) {

        while (true) {
            io.tulostaRivinvaihdolla("\n Valitse pelataanko"
                        + "\n (a) ihmistä vastaan "
                        + "\n (b) tekoälyä vastaan"
                        + "\n (c) parannettua tekoälyä vastaan"
                        + "\n muilla valinnoilla lopetataan ");
    
            String vastaus = io.kysy();

            if (vastaus.endsWith("a")) {
                io.tulostaRivinvaihdolla("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KiviPaperiSakset peli = KiviPaperiSakset.kaksinpeli(io);
                peli.pelaa();
            } else if (vastaus.endsWith("b")) {
                io.tulostaRivinvaihdolla("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KiviPaperiSakset peli = KiviPaperiSakset.helppoTietokonevastustaja(io);
                peli.pelaa();
            } else if (vastaus.endsWith("c")) {
                io.tulostaRivinvaihdolla("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KiviPaperiSakset peli = KiviPaperiSakset.vaikeaTietokonevastustaja(io);
                peli.pelaa();
            } else {
                break;
            }

        }

    }
}
