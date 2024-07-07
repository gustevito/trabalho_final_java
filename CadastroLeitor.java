
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
    public boolean retiraLeitor (String nome) {
        int pos = 0;
        boolean achou = false;
        
        for (int i = 0; i < this.index; i++) {
            if (this.leitor[i].getNome().equalsIgnoreCase(nome)) {
                pos = i;
                achou = true;
                break;
            }
        }
        if (achou) {
            for (int i = pos; i < this.leitor.length-1; i++) {
                this.leitor[i] = this.leitor[i+1];
            }
            this.leitor[this.leitor.length-1] = null;
            index--;
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
    public void showReaders () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.leitor[i].toStringENG());
        }
    }
    public boolean verificaMatricula (int matricula) {
        for (int i = 0; i < this.index; i++) {
            if (leitor[i].getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }
}