package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KonsoliIO implements IO {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void tulosta(String teksti) {
        System.out.print(teksti + "");
    }

    @Override
    public void tulostaRivinvaihdolla(String teksti) {
        System.out.println(teksti);
    }

    @Override
    public String kysy() {
        return scanner.nextLine();
    }
}