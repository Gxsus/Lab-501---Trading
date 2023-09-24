import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Aggiungi qui una descrizione della classe contoCorrente
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class ContoCorrente
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private double saldo;
    private LinkedList<Titolo> titoli = new LinkedList<>();
    /**
     * Costruttore degli oggetti di classe  contoCorrente
     * * @param  importo  il saldo equivale all'importo
     */
    public ContoCorrente(double importo)
    {
        saldo=importo;
    }

    /**
     * Costruttore degli oggetti di classe  contoCorrente
     * * @param  importo  il saldo equivale all'importo
     */
    public ContoCorrente(int importo)
    {
        saldo=importo;
    }
    
    /**
     * Costruttore degli oggetti di classe  contoCorrente
     */
    public ContoCorrente()
    {
        this(0);
    }
    
    /**
     * Toglie l'importo dal saldo attuale, se si passa un importo negativo si somma
     * @param importo  importo da togliere al saldo
     * @return true se esegue l'operazione
     */
    public boolean preleva(double importo)
    {
        if(saldo-importo>=0){
            saldo-=importo;
            return true;
        }
        return false;
    }
    
    /**
     * Aggiunge l'importo dal saldo attuale
     * @param importo  importo da aggiungere al saldo
     * @return true se esegue l'operazione
     */
    public boolean deposita(double importo)
    {
        if(saldo+importo>=0){
            saldo+=importo;
            return true;
        }
        return false;
    }
    
    /**
     * Aggiunge l'importo dal saldo attuale, se si passa un importo negativo
     * si somma
     * @param importo  importo da togliere al saldo
     * @return true se esegue l'operazione
     */
    public boolean preleva(int importo)
    {
        return preleva((double)importo);
    }
    
    /**
     * Aggiunge l'importo dal saldo attuale
     * @param importo  importo da aggiungere al saldo
     * @return true se esegue l'operazione
     */
    public boolean deposita(int importo)
    {
        return deposita((double)importo);
    }
    
    /**
     * Chiude il conto mettendo il saldo pari a -1
     */
    public void chiudiConto()
    {
        saldo=-1;
    }
    
    /**
     * Restuisce il saldo di questo contoCorrente
     * @return il saldo di questo contoCorrente
     */
    public double getSaldo()
    {
        return saldo;
    }
}

