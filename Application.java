
/**
 * Já pra deixar meio preparado o app.
 * 
 * @author (Carlos Eduardo Griebeler, Matheus, Gustavo) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;
public class Application {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        CadastroLeitor leitores = new CadastroLeitor();
        CadastroLivro livros = new CadastroLivro();
        
        System.out.println ("\fIniciando sistema da Biblioteca Municipal, o que deseja fazer hoje?");
        System.out.println ("(Caso seja um novo funcionário, pode inserir 'help' para visualizar todas as opcoes disponíveis)");
        String opcao = input.nextLine();
        while (opcao != "exit") {
            switch (opcao) {
                case "help":
                    System.out.println ("novoLeitor = Cria uma nova conta de leitor;");
                    System.out.println ("apagaLeitor = Cancela a conta de um leitor;");
                    System.out.println ("pesquisaLeitor = Pesquisa uma conta de um leitor;");
                    System.out.println ("mostraLeitores = Mostra todas as contas de leitores da Biblioteca;");
                    System.out.println ("novoLivro = Cadastra um novo livro na Biblioteca;");
                    System.out.println ("apagaLivro = Retira um livro da coleção da Biblioteca;");
                    System.out.println ("pesquisaLivro = Pesquisa um livro na Biblioteca;");
                    System.out.println ("mostraLivros = Mostra todos os livros da coleção da Biblioteca;");
                    System.out.println ("retiraLivro = Retira uma unidade de um livro para empréstimo;");
                    System.out.println ("devolveLivro = Retorna um livro de um empréstimo;");
                    System.out.println ("colecao = Mostra a quantidade total de livros disponíveis na Biblioteca;");
                    System.out.println ("exit = Desliga o programa");
                    

                    // teste
            }
            System.out.println ("O que deseja fazer agora?");
            opcao = input.nextLine();
        }
    }
}
