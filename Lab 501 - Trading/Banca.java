public class Banca{
    private String nomeBanca;
    private int filiale;
    private ContoCorrente[] conti;
    private int numConti;
    private String[] intestatari;
    /**
     * Costruttore degli oggetti di classe Banca
     * @param  nome il nome della banca
     * @param  numAgenzia il saldo equivale all'importo
     * @param  maxConti i conti che può tenere
     */
    public Banca(String nome, int numAgenzia, int maxConti){
        nomeBanca = nome;
        filiale = numAgenzia;
        conti = new ContoCorrente[maxConti];
        intestatari = new String[maxConti];
        numConti = 0;
    }
    /**
     * Costruttore degli oggetti di classe Banca
     * @param  nome il nome della banca
     * @param  numAgenzia il saldo equivale all'importo
     */
    public Banca(String nome, int numAgenzia){
        this(nome, numAgenzia, 100);
    }
    /** apre un conto corrente presso la banca,
     * @param nome nome dell’intestatario del conto
     * @param importoIniziale saldo all’apertura del conto
     * @return il numero del contoCorrente (numero di 6 cifre con zeri iniziali)  
     */
    public String apriConto(String nome,  double importoIniziale){
        conti[numConti] =  new ContoCorrente(importoIniziale);
        intestatari[numConti] = nome;
        numConti ++;  
        return String.format("%06d", numConti);
    }
    /** apre un conto corrente presso la banca,
     * @param nome nome dell’intestatario del conto
     * @return il numero del contoCorrente (numero di 6 cifre con zeri iniziali)  
     */
    public String apriConto(String nome){
        return apriConto(nome, 0);
    }
    public static void main(String[] args){
        Banca mia;
        mia = new Banca("Calvino Spa", 1, 200);
        String cc = mia.apriConto("Enzo", 8000);
        String cc2 = mia.apriConto("Ciccio");
        mia.versamento(cc, 500);
        mia.chiudiConto("000002");
        System.out.println(mia.toString());
    }
    /** versa un importo in un conto
     * @param conto il conto
     * @param importo l'importo che verso nel conto
     */
    public void versamento(String conto, double importo){
        conti[Integer.parseInt(conto)-1].deposita(importo);
    }
    /** preleva un importo da un conto
     * @param conto il conto
     * @param importo l'importo che prelevo dal conto
     * @return true se esegue il prelievo, false altrimenti
     */
    public boolean prelievo(String conto, double importo){
        if(conti[Integer.parseInt(conto)-1].getSaldo()<importo)
            return false;
        conti[Integer.parseInt(conto)-1].preleva(importo);
        return true;
    } 
    /** restituisce importo che era depositato su un conto e lo chiude
     * @param conto il conto da chiudere
     * @return l'importo che c'era depositato
     */
    public double chiudiConto(String conto){
        int pos = Integer.parseInt(conto)-1;
        double ret = conti[pos].getSaldo();
        conti[pos].chiudiConto();
        return ret;
    }   
    /** aggiunge a ogni conto un importo percentuale in base al saldo attuale (nella realtà non è così)
     * @param tasso percentuale con la quale aumento il conto
     */
    public void addInteressi(double tasso){
        double saldo;
        for(int i=0; i<numConti; i++){
            saldo= conti[i].getSaldo();
            if(saldo!=-1)
                conti[i].deposita((saldo/100)*tasso);
        }
    }
    /** toglie le spese da ciascuno dei conti correnti presenti
     * @param importo percentuale con la quale aumento il conto
     */
    public void addSpese(double importo){
        addSpese(importo, importo+1);    
    }
    /** toglie le spese da ciascuno dei conti correnti che ha un importo depositato inferiore alla soglia
     * @param importo l'mporto da togliere
     * @param soglia la soglia che l'importo non può superare
     */
    public void addSpese(double importo, double soglia){
        if(importo>soglia)
            return;
        double saldo;
        for(int i=0; i<numConti; i++){
            saldo= conti[i].getSaldo();
            if(saldo!=-1)
                conti[i].preleva(importo);
        }
    }
    /** sposta i soldi da un conto all'altro (se possibile)
     * @param dalConto da che conto si rimuove l'importo
     * @param alConto a che conto si aggiunge l'importo
     * @param importo l'importo da togliere
     */
    public void giroconto(String dalConto, String alConto, double importo){
        int pos1 = Integer.parseInt(dalConto)-1;
        int pos2 = Integer.parseInt(alConto)-1;
        if(conti[pos1].preleva(importo))
            conti[pos2].deposita(importo);
    } 
    @Override 
    public String toString(){
        String ris="Banca "+nomeBanca+", agenzia "+filiale+" \n";
        double saldo;
        for(int i=0; i<numConti; i++){
            saldo= conti[i].getSaldo();
            ris+=String.format("cc %06d: ", i+1);
            if(saldo==-1)
                ris+="CONTO CHIUSO\n";
            else
                ris+=String.format("%-20s%,3.2f Euro\n", intestatari[i], saldo);       
        }
        return ris;
    }     
}

