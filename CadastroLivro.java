
// Alterei um pouco e coloquei mais um método aq

public class CadastroLivro {
    private int index;
    private Livro livro[];

    // Método Constructor;
    public CadastroLivro() {
        this.index = 0;
        this.livro = new Livro[10];
    }
    // Método para inserir um livro no vetor;
    public boolean adicionaLivro (Livro livro) {
        if (this.index < this.livro.length) {
            this.livro[this.index] = livro;
            this.index++;
            return true;
        }
        return false;
    }
    // Método para buscar um livro pelo nome no vetor;
    public Livro buscaLivroPeloNome (String nome) {
        for (int i = 0; i < this.index; i++) {
            if (this.livro[i].getNomeLivro().equalsIgnoreCase(nome)) {
                return this.livro[i];
            }
        }
        return null;
    }
    // Método para o cálculo do total de exemplares disponíveis;
    public int totalExemplares () {
        int totalExemplares = 0;
        for (int i = 0; i < this.index; i++) {
            totalExemplares += this.livro[i].getExemplares();
        }
        return totalExemplares;
    }
    // Método para imprimir os dados do vetor/objeto livro;
    public void mostraLivros () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.livro[i]);
        }
    }
}