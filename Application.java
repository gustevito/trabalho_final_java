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
                    System.out.println (novoLeitor);
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
            case "pesquisaleitor":
                System.out.println ("Informe o nome do leitor que deseja pesquisar: ");
                nome = input.nextLine();
                if(leitores.buscaLeitorPeloNome(nome) == null) {
                    System.out.println("leitor inesistente");
                } else {
                    System.out.println (leitores.buscaLeitorPeloNome(nome));
                }
                break;
            case "mostraleitores":
                System.out.println ("Leitores cadastrados na Biblioteca: ");
                leitores.mostraLeitores();
                break;
            case "novolivro":
                System.out.println ("Informe o nome do livro que deseja inserir: ");
                String nomeLivro = input.nextLine();
                System.out.println ("Informe a quantidade de exemplares que esse livro possui: ");
                int exemplares = input.nextInt();
                System.out.println ("Crie um código para o cadastro do livro: ");
                int codigo = input.nextInt();
                input.nextLine();
                Livro novoLivro = new Livro(codigo,exemplares,nomeLivro);
                if(livros.adicionaLivro(novoLivro)){
                    System.out.println("livro adicionado com sucesso");
                    System.out.println (novoLivro);
                } else{
                    System.out.println("não foi possível adicionar o livro");
                }
                break;
            case "apagalivro":
                System.out.println ("Informe o nome do livro que precisa ser apagado: ");
                nomeLivro = input.nextLine();
                if (livros.apagaLivro(nomeLivro)) {
                    System.out.println ("O livro cadastrado foi cancelado com sucesso!");
                } else {
                    System.out.println ("Erro ao cancelar o cadastro do livro.");
                }
                break;
            case "mostralivros":
                System.out.println ("Coleção de livros da Biblioteca: ");
                livros.mostraLivros();
            case "pesquisalivro":
                System.out.println ("Informe o nome do livro que deseja pesquisar: ");
                nomeLivro = input.nextLine();
                if(livros.buscaLivroPeloNome(nomeLivro) == null) {
                    System.out.println("O livro \"" + nomeLivro + "\" não foi encontrado no sistema.");
                } else {
                    System.out.println("O livro foi encontrado\n" + livros.buscaLivroPeloNome(nomeLivro));
                }
            case "retiralivro":
            case "colecao":
                System.out.println("A coleção da Biblioteca conta com cerca de " + livros.totalExemplares() + " livros.");
                break;
            default:
                System.out.println ("Erro ao encontrar opção, por favor, verifique se o que foi inserido está correto.");
        }
    }
    public static void options (String opcao, Scanner input, CadastroLivro livros, CadastroLeitor leitores) {
        Random matricula = new Random();
        switch (opcao) {
            case "help":
                System.out.println ("newReader = Create a new reader's account;");
                System.out.println ("deleteReader = Delete a reader's account;");
                System.out.println ("searchReader = Pesquisa uma conta de um leitor;");
                System.out.println ("showReaders = Show all the reader's acocunts in the Library's system;");
                System.out.println ("newBook = Register a new book in the Library's system;");
                System.out.println ("deleteBook = Delete a book from the Library's collection;");
                System.out.println ("searchBook = Search a book in the Library;");
                System.out.println ("showBooks= Show all the books in the Library's collection;");
                System.out.println ("getBook = Make a loan for a reader;");
                System.out.println ("giveBook = Receive a book from a loan;");
                System.out.println ("collection = Show how many books are available in the moment at the Library;");
                System.out.println ("exit = Shut the program down.");
                break;
            case "newreader":
                System.out.println ("Inform the new reader's name: ");
                String nome = input.nextLine();
                System.out.println ("Inform the new reader's email: ");
                String email = input.nextLine();
                int mat = matricula.nextInt(100);
                do {
                    mat = matricula.nextInt(100);
                } while (leitores.verificaMatricula(mat));
                Leitor novoLeitor = new Leitor (matricula.nextInt(100), nome, email);
                if (leitores.insereLeitor(novoLeitor)) {
                    System.out.println ("New account inserted succesfully!");
                    System.out.println (novoLeitor);
                } else {
                    System.out.println ("ERROR. Erro ao cadastrar o leitor.");
                }
                break;
            case "deletereader":
                System.out.println ("Informe o nome do leitor que precisa ser apagado: ");
                nome = input.nextLine();
                if (leitores.retiraLeitor(nome)) {
                    System.out.println ("Leitor cadastro cancelado com sucesso!");
                } else {
                    System.out.println ("Erro ao cancelar o cadastro do leitor.");
                }
                break;
            case "searchreader":
                System.out.println ("Informe o nome do leitor que deseja pesquisar: ");
                nome = input.nextLine();
                if(leitores.buscaLeitorPeloNome(nome) == null) {
                    System.out.println("Leitor não encontrado.");
                } else {
                    System.out.println (leitores.buscaLeitorPeloNome(nome).toString());
                }
                break;
            case "showreaders":
                System.out.println ("Leitores cadastrados na Biblioteca: ");
                leitores.mostraLeitores();
                break;
            case "newbook":
                System.out.println ("Informe o nome do livro que deseja inserir: ");
                String nomeLivro = input.nextLine();
                System.out.println ("Informe a quantidade de exemplares que esse livro possui: ");
                int exemplares = input.nextInt();
                System.out.println ("Crie um código para o cadastro do livro: ");
                int codigo = input.nextInt();
                input.nextLine();
                Livro novoLivro = new Livro(codigo,exemplares,nomeLivro);
                if(livros.adicionaLivro(novoLivro)){
                    System.out.println("livro adicionado com sucesso");
                    System.out.println (novoLivro);
                } else{
                    System.out.println("não foi possível adicionar o livro");
                }
                break;
            case "deletebook":
                System.out.println ("Informe o nome do livro que precisa ser apagado: ");
                nomeLivro = input.nextLine();
                if (livros.apagaLivro(nomeLivro)) {
                    System.out.println ("O livro cadastrado foi cancelado com sucesso!");
                } else {
                    System.out.println ("Erro ao cancelar o cadastro do livro.");
                }
                break;
            case "showbooks":
                System.out.println ("Coleção de livros da Biblioteca: ");
                livros.mostraLivros();
                break;
            case "searchbook":
                System.out.println ("Informe o nome do livro que deseja pesquisar: ");
                nomeLivro = input.nextLine();
                if(livros.buscaLivroPeloNome(nomeLivro) == null) {
                    System.out.println("O livro \"" + nomeLivro + "\" não foi encontrado no sistema.");
                } else {
                    System.out.println("O livro foi encontrado\n" + livros.buscaLivroPeloNome(nomeLivro));
                }
                break;
            case "getbook":
                break;
            case "givebook":
                break;
            case "collection":
                System.out.println("A coleção da Biblioteca conta com cerca de " + livros.totalExemplares() + " livros.");
                break;
            default:
                System.out.println ("Erro ao encontrar opção, por favor, verifique se o que foi inserido está correto.");
        }
    }
}
