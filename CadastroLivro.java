
// Alterei um pouco e coloquei mais um método aq

public class CadastroLivro{
    private int index;
    private Livro livro[]; // variavel de referencia []

    public CadastroLivro(int tam){
        this.index = 0;
        this.livro = new Livro[tam]; // instancia de objeto de vetor de livros
    }
    
    // Método para inserir um livro no vetor
    public boolean insereLivro(Livro l1){
        if (livro.length < index){
            livro[this.index] = l1;
            this.index++;
            return true;
        }
        return false;
    }

    // Método para retirar um livro do vetor
    public boolean retiraLivro (String nome) {
        int pos = 0;
        boolean achou = false;
        
        for (int i = 0; i < index; i++) {
            if (this.livro[i].getNomeLivro().equalsIgnoreCase(nome)) {
                pos = i;
                achou = true;
                break;
            }
        }
        if (achou) {
            for (int i = pos; i < livro.length-1; i++)
            {
                livro[i] = livro[i+1];
            }
            livro[livro.length-1] = null;
            index--;
            return true;
        }
        return false;
    }
}