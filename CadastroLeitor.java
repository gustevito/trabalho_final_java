
/**
 * Escreva uma descrição da classe CadastroLeitor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class CadastroLeitor {
    private int index;
    private Leitor leitor[];
    
    // Métodos construtor
    public CadastroLeitor () {
        this.index = 0;
        this.leitor = new Leitor[10];
    }
    
    public boolean insereLeitor (Leitor leitor) {
        if (this.index < this.leitor.length) {
            this.leitor[this.index] = leitor;
            this.index++;
            return true;
        }
        return false;
    }
    public Leitor buscaLeitorPeloNome (String nome) {
        for (int i = 0; i < this.index; i++) {
            if (this.leitor[i].getNome().equalsIgnoreCase(nome)) {
                return this.leitor[i];
            }
        }
        return null;
    }
    public void mostraLeitores () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.leitor[i]);
        }
    }
}