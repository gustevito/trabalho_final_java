
/**
 * Escreva uma descrição da classe CadastroLeitor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class CadastroLeitor
{
    private int index;
    private Leitor leitor[];
    
    // Métodos construtor
    public CadastroLeitor (int tam) {
        this.index = 0;
        this.leitor = new Leitor[tam];
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
        for (int i = 0; i < leitor.length; i++) {
            if (leitor[i].getNome().equalsIgnoreCase(nome)) {
                this.index--;
                leitor[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public void mostraLeitor () {
        for (Leitor l1 : leitor) {
            System.out.println (l1);
        }
    }
}
