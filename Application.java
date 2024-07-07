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
        System.out.println ("1 = Português\n2 = English");
        int lingua = input.nextInt();
        input.nextLine();
        while (lingua >= 3 || lingua <= 0) {
            System.out.println ("ERRO");
            System.out.println ("1 = Português\n2 = English");
            lingua = input.nextInt();
            input.nextLine();
        }
        switch (lingua) {
            case 1:
                System.out.println ("\fBem vindo!");
                System.out.println ("Iniciando sistema da Biblioteca Municipal, o que deseja fazer hoje?");
                System.out.println ("(Caso seja um novo funcionário, pode inserir 'help' para visualizar todas as opcoes disponíveis)");
                String opcao = input.nextLine().toLowerCase();
                while (!opcao.equalsIgnoreCase("exit")) {
                    opcoes(opcao, input, livros, leitores);
                    System.out.println ("O que deseja fazer agora?");
                    opcao = input.nextLine();
                }
                break;
            case 2:
                System.out.println ("\fWelcome");
                System.out.println ("Iniciating Municipal Library system, what do you want to do today?");
                System.out.println ("(If you are a new employee, you can insert 'help' to visualize all the options available)");
                opcao = input.nextLine().toLowerCase();
                while (!opcao.equalsIgnoreCase("exit")) {
                    options(opcao, input, livros, leitores);
                    System.out.println ("What do you want to do now?");
                    opcao = input.nextLine();
                }
                break;
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
                    System.out.println ("Nova conta criada com sucesso!");
                    System.out.println (novoLeitor);
                } else {
                    System.out.println ("Erro ao cadastrar o leitor.");
                }
                break;
            case "apagaleitor":
                System.out.println ("Informe o nome do leitor que precisa ser apagado: ");
                nome = input.nextLine();
                if (leitores.retiraLeitor(nome)) {
                    System.out.println ("Cadastro cancelado com sucesso.");
                } else {
                    System.out.println ("Erro ao cancelar o cadastro do leitor.");
                }
                break;
            case "pesquisaleitor":
                System.out.println ("Informe o nome do leitor que deseja pesquisar: ");
                nome = input.nextLine();
                if(leitores.buscaLeitorPeloNome(nome) == null) {
                    System.out.println("Leitor não encontrado.");
                } else {
                    System.out.println (leitores.buscaLeitorPeloNome(nome).toString());
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
                break;
            case "pesquisalivro":
                System.out.println ("Informe o nome do livro que deseja pesquisar: ");
                nomeLivro = input.nextLine();
                if(livros.buscaLivroPeloNome(nomeLivro) == null) {
                    System.out.println("O livro \"" + nomeLivro + "\" não foi encontrado no sistema.");
                } else {
                    System.out.println("O livro foi encontrado\n" + livros.buscaLivroPeloNome(nomeLivro));
                }
                break;
            case "retiralivro":
                System.out.println ("Informe o nome do leitor que deseja retirar um livro: ");
                nome = input.nextLine();
                System.out.println ("Informe o nome do livro que o leitor deseja retirar: ");
                nomeLivro = input.nextLine();
                if (leitores.buscaLeitorPeloNome(nome).getLivroRetirado() != null) {
                    System.out.println ("O leitor já tem um livro em empréstimo com a biblioteca.\nCaso ele deseja retirar outro livro, deve devolver o outro antes.");
                } else {
                    leitores.buscaLeitorPeloNome(nome).setLivroRetirado(livros.buscaLivroPeloNome(nomeLivro));
                    if (livros.buscaLivroPeloNome(nomeLivro).retirada()) {
                        System.out.println ("The book was successfully loaned!");
                    } else {
                        System.out.println ("The book doesn't have copies available.");
                    }
                }
                break;
            case "devolvelivro":
                System.out.println ("Informe o nome do leitor que deseja devolver um livro: ");
                nome = input.nextLine();
                if (leitores.buscaLeitorPeloNome(nome).getLivroRetirado() == null) {
                    System.out.println ("O leitor não tem nenhum empréstimo na Biblioteca.");
                } else {
                    livros.buscaLivroPeloNome(leitores.buscaLeitorPeloNome(nome).getLivroRetirado().getNomeLivro()).devolucao();
                    leitores.buscaLeitorPeloNome(nome).setLivroRetirado(null);
                    System.out.println ("O livro foi devolvido com sucesso!");
                }
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
                System.out.println ("searchReader = Search a reader's account by the name;");
                System.out.println ("showReaders = Show all the reader's acocunts in the Library's system;");
                System.out.println ("newBook = Register a new book in the Library's system;");
                System.out.println ("deleteBook = Delete a book from the Library's collection;");
                System.out.println ("searchBook = Search a book in the Library by the name;");
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
                    System.out.println ("New account inserted successfully!");
                    System.out.println (novoLeitor);
                } else {
                    System.out.println ("ERROR. System wasn't able to create a new account.");
                }
                break;
            case "deletereader":
                System.out.println ("Inform the name of the reader to delete: ");
                nome = input.nextLine();
                if (leitores.retiraLeitor(nome)) {
                    System.out.println ("Registration successfully cancelled!");
                } else {
                    System.out.println ("ERROR. System wasn't able to delete the account.");
                }
                break;
            case "searchreader":
                System.out.println ("Informe o nome do leitor que deseja pesquisar: ");
                nome = input.nextLine();
                if(leitores.buscaLeitorPeloNome(nome) == null) {
                    System.out.println("Reader not found.");
                } else {
                    System.out.println (leitores.buscaLeitorPeloNome(nome).toString());
                }
                break;
            case "showreaders":
                System.out.println ("Readers registered in the Library: ");
                leitores.mostraLeitores();
                break;
            case "newbook":
                System.out.println ("Inform the name of the new book: ");
                String nomeLivro = input.nextLine();
                System.out.println ("Inform how many copies this book have: ");
                int exemplares = input.nextInt();
                System.out.println ("Create a code for the book's registration: ");
                int codigo = input.nextInt();
                input.nextLine();
                Livro novoLivro = new Livro(codigo,exemplares,nomeLivro);
                if(livros.adicionaLivro(novoLivro)){
                    System.out.println("Book was successfully added.");
                    System.out.println (novoLivro);
                } else{
                    System.out.println("System was not able to add the book.");
                }
                break;
            case "deletebook":
                System.out.println ("Inform the book's name that needs to be deleted: ");
                nomeLivro = input.nextLine();
                if (livros.apagaLivro(nomeLivro)) {
                    System.out.println ("The book was successfully deleted.");
                } else {
                    System.out.println ("ERROR. System was not able to delete the book.");
                }
                break;
            case "showbooks":
                System.out.println ("Library's book colletion: ");
                livros.mostraLivros();
                break;
            case "searchbook":
                System.out.println ("Inform the name of the book that needs to be searched: ");
                nomeLivro = input.nextLine();
                if(livros.buscaLivroPeloNome(nomeLivro) == null) {
                    System.out.println("The book \"" + nomeLivro + "\" was not found in the system.");
                } else {
                    System.out.println("The book was found\n" + livros.buscaLivroPeloNome(nomeLivro));
                }
                break;
            case "getbook":
                System.out.println ("Inform the name of the reader that wants to get a book: ");
                nome = input.nextLine();
                System.out.println ("Inform the name of the book that the reader wants to get: ");
                nomeLivro = input.nextLine();
                if (leitores.buscaLeitorPeloNome(nome).getLivroRetirado() != null) {
                    System.out.println ("The reader already has a book of the Library.\nIf the reader wants to get another book, he needs to give back the other one.");
                } else {
                    leitores.buscaLeitorPeloNome(nome).setLivroRetirado(livros.buscaLivroPeloNome(nomeLivro));
                    if (livros.buscaLivroPeloNome(nomeLivro).retirada()) {
                        System.out.println ("The book was successfully loaned!");
                    } else {
                        System.out.println ("The book doesn't have copies available.");
                    }
                }
                break;
            case "givebook":
                System.out.println ("Inform the reader's name which wants to give back a book: ");
                nome = input.nextLine();
                if (leitores.buscaLeitorPeloNome(nome).getLivroRetirado() == null) {
                    System.out.println ("The reader hasn't got a loan at the Library.");
                } else {
                    livros.buscaLivroPeloNome(leitores.buscaLeitorPeloNome(nome).getLivroRetirado().getNomeLivro()).devolucao();
                    leitores.buscaLeitorPeloNome(nome).setLivroRetirado(null);
                    System.out.println ("The book was returned successfully!");
                }
            case "collection":
                System.out.println("The collection of the Library has " + livros.totalExemplares() + " books.");
                break;
            default:
                System.out.println ("ERROR. The system wasn't able to find an option, please verify if what was inserted is correct.");
        }
    }
}