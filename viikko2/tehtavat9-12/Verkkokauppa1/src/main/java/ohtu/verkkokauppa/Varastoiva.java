package ohtu.verkkokauppa;

public interface Varastoiva {
    
    public Tuote haeTuote(int id);

    public int saldo(int id);

    public void otaVarastosta(Tuote t);

    public void palautaVarastoon(Tuote t);

}