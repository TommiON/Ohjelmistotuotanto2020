package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset {
    protected static IO io;
    
    public static KiviPaperiSakset kaksinpeli(IO iioo) {
        io = iioo;
        return new KPSPelaajaVsPelaaja();
    }

    public static KiviPaperiSakset helppoTietokonevastustaja(IO iioo) {
        io = iioo;
        return new KPSTekoaly();
    }

    public static KiviPaperiSakset vaikeaTietokonevastustaja(IO iioo) {
        io = iioo;
        return new KPSTekoaly();
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        String siirtoA = pelaajaAsiirto();
        String siirtoB = pelaajaBsiirto(siirtoA);

        while(laillinenSiirto(siirtoA) && laillinenSiirto(siirtoB)) {
            tuomari.kirjaaSiirto(siirtoA, siirtoB);
            io.tulostaRivinvaihdolla(tuomari.toString());
            siirtoA = pelaajaAsiirto();
            siirtoB = pelaajaBsiirto(siirtoA);
        }

        io.tulostaRivinvaihdolla("Kiitos!");
        io.tulostaRivinvaihdolla(tuomari.toString());
    }

    protected String pelaajaAsiirto() {
        io.tulosta("Ensimmäisen pelaajan siirto:");
        return io.kysy();
    }

    abstract protected String pelaajaBsiirto(String siirtoA);

    protected static boolean laillinenSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}