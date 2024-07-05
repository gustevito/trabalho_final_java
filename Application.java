/**
 * Escreva uma descrição da classe Application aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;
import java.util.Random;
public class Application {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        CadastroLeitor leitores = new CadastroLeitor();
        CadastroLivro livros = new CadastroLivro();
        
        System.out.println ("\fIniciando sistema da Biblioteca Municipal, o que deseja fazer hoje?");
        System.out.println ("(Caso seja um novo funcionário, pode inserir 'help' para visualizar todas as opcoes disponíveis)");
        String opcao = input.nextLine().toLowerCase();
        while (!opcao.equalsIgnoreCase("exit")) {
            opcoes(opcao, input, livros, leitores);
            System.out.println ("O que deseja fazer agora?");
            opcao = input.nextLine();
        }
    }
    public static void opcoes (String opcao, Scanner input, CadastroLivro livros, CadastroLeitor leitores) {
        Random matricula = new Random();
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
                break;
            case "novoleitor":
                System.out.println ("Informe o nome do novo leitor: ");
                String nome = input.nextLine();
                System.out.println ("Informe o email do novo leitor: ");
                String email = input.nextLine();
                int mat = matricula.nextInt(100);
                do {
                    mat = matricula.nextInt(100);
                } while (leitores.verificaMatricula(mat));
                Leitor novoLeitor = new Leitor (matricula.nextInt(100), nome, email);
                if (leitores.insereLeitor(novoLeitor)) {
                    System.out.println ("Leitor inserido com sucesso!");
                } else {
                    System.out.println ("Erro ao cadastrar o leitor.");
                }
                break;
            case "apagaleitor":
                System.out.println ("Informe o nome do leitor que precisa ser apagado: ");
                nome = input.nextLine();
                if (leitores.retiraLeitor(nome)) {
                    System.out.println ("Leitor cadastro cancelado com sucesso!");
                } else {
                    System.out.println ("Erro ao cancelar o cadastro do leitor.");
                }
                break;
        }
    }
}