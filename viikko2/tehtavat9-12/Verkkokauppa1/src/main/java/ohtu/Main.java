package ohtu;

import ohtu.verkkokauppa.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Viitegeneraattori viitteet = ctx.getBean(Viitegeneraattori.class);
        Kirjanpito kirjanpito = ctx.getBean(Kirjanpito.class);
        Varasto varasto = ctx.getBean(Varasto.class);
        Pankki pankki = ctx.getBean(Pankki.class);
        Kauppa kauppa = ctx.getBean(Kauppa.class);

        // Kauppa kauppa = new Kauppa(varasto, pankki, viitteet);
    
        // Kauppa kauppa = new Kauppa();

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
