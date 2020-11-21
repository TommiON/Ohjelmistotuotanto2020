package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class ConsoleIO implements IO {

    Scanner lukija = new Scanner(System.in);

    public String lueMerkkijono() {
        return lukija.nextLine();
    }

    public int lueKokonaisluku() {
        return lukija.nextInt();
    }

    public IntJoukko valitseJoukko(IntJoukko A, IntJoukko B, IntJoukko C) {
        String syote = lukija.nextLine();
        while (true) {
            if (syote.equals("A") || syote.equals("a")) {
                return A;
            } else if (syote.equals("B") || syote.equals("b")) {
                return B;
            } else if (syote.equals("C") || syote.equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + syote);
                System.out.print("Yritä uudelleen!");
                syote = lukija.nextLine();
            }
        }
    }
}