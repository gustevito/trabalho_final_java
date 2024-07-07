public class Livro{
    private int codigo;
    private int exemplares;
    private String nomeLivro;
    
    public Livro(int codigo, int exemplares, String nomeLivro){
        this.codigo = codigo;
        this.exemplares = exemplares;
        this.nomeLivro = nomeLivro;
    }
    
    // getters
    public int getCodigo(){
        return codigo;
    }
    
    public int getExemplares(){
        return exemplares;
    }
    
    public String getNomeLivro(){
        return nomeLivro;
    }
    
    // setters
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setExemplares(int exemplares){
        this.exemplares = exemplares;
    }
    
    public void setNomeLivro(String nomeLivro){
        this.nomeLivro = nomeLivro;
    }

    public boolean retirada () {
        if (this.exemplares > 0) {
            this.exemplares--;
            return true;
        }
        return false;
    }
    public void devolucao () {
        this.exemplares++;
    }
    
    // toString
    public String toString(){
        return "\nLivro" +
        "\nNome: " + nomeLivro +
        "\nCodigo: " + codigo +
        "\nExemplares: " + exemplares;
    } 
}