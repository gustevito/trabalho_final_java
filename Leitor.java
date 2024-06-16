public class Leitor{
    private int matricula;
    private String nome;
    private String email;
    Livro livroRetirado;;
    
    public Leitor(int matricula, String nome, String email){
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.livroRetirado = null;
    }
    
    // getters
    public int getMatricula(){
        return matricula;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public Livro getLivroRetirado(){
        return livroRetirado;
    }
    
    // setters
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEmail(String email){
        this.email = email;    
    }
    
    public void setLivroRetirado (Livro livroRetirado){
        this.livroRetirado = livroRetirado;
    }
    
    // toString
    public String toString(){
        return "Leitor" + 
        "\nMatricula: " + matricula +
        "\nNome: " + nome +
        "\nE-mail: " + email +
        "\nLivro Retirado: " + livroRetirado;
    }
}