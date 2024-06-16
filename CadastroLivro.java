
// tem q arrumar saporra ta errado

public class CadastroLivro{
    private int index;
    private Livro livro[]; // variavel de referencia []

    public CadastroLivro(int tam){
        this.index = 0;
        this.livro = new Livro[tam]; // instancia de objeto de vetor de livros
    }
    
    public boolean insereLivro(Livro l1){
        if (livro.length < index){
            livro[index] = l1;
            index++;
            return true;
        } else{
            return false;
        }
    }
    
    
}