public class Titolo {
    private double prezzoAttuale;
    private String nome;

    public Titolo(String nome, double prezzoAttuale){
        this.nome = nome;
        this.prezzoAttuale = prezzoAttuale;
    }
    public Titolo(String nome, int prezzoAttuale){ this(nome, (double)prezzoAttuale); }

    public double getPrezzoAttuale() {
        return prezzoAttuale;
    }

    public String getNome() {
        return nome;
    }

    public void setPrezzoAttuale(double prezzoAttuale) {
        this.prezzoAttuale = prezzoAttuale;
    }
    //aggiorna prezzo chiederà al sito della borsa il valore dell'azione
    public void aggiornaPrezzo(){
        return;
    }
}
