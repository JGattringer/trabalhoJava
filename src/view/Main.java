package view;
import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Biblioteca ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Adicionar Membro");
            System.out.println("4. Listar Membros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    // Adicionar livro
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Nome do Autor: ");
                    String nomeAutor = scanner.nextLine();
                    System.out.print("Nacionalidade do Autor: ");
                    String nacionalidade = scanner.nextLine();
                    System.out.print("Data de Nascimento do Autor: ");
                    String dataNascimento = scanner.nextLine();
                    Autor autor = new Autor(nomeAutor, nacionalidade, dataNascimento);

                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, isbn);
                    biblioteca.adicionarLivro(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    // Listar livros
                    biblioteca.listarLivros();
                    break;

                case 3:
                    // Adicionar membro
                    System.out.print("Nome do Membro: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID do Membro: ");
                    int idMembro = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha

                    System.out.println("Tipo de Membro: (1) Estudante, (2) Professor");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha

                    if (tipo == 1) {
                        System.out.print("Curso: ");
                        String curso = scanner.nextLine();
                        Estudante estudante = new Estudante(nome, idMembro, curso);
                        biblioteca.adicionarMembro(estudante);
                    } else if (tipo == 2) {
                        System.out.print("Departamento: ");
                        String departamento = scanner.nextLine();
                        Professor professor = new Professor(nome, idMembro, departamento);
                        biblioteca.adicionarMembro(professor);
                    }
                    System.out.println("Membro adicionado com sucesso!");
                    break;

                case 4:
                    // Listar membros
                    biblioteca.listarMembros();
                    break;

                case 5:
                    // Sair do sistema
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}

