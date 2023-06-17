import java.io.IOException;
import java.util.Scanner;

public class GerenciadorAlunos {
    // Vetor global para armazenar os alunos
    private static String[] alunos = new String[10];
    private static int countAlunos = 0;

    public static void main(String[] args) {
        exibirMenu();
    }

    // Função para exibir o menu
    private static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Limpar o console
            limparConsole();

            System.out.println("========== MENU ==========");
            System.out.println("1. Gerenciar alunos");
            System.out.println("2. Gerenciar chamadas");
            System.out.println("3. Sair do programa");
            System.out.print("Digite a opção desejada: ");

            int opcaoMenu = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcaoMenu) {
                case 1:
                    exibirMenuAlunos(scanner);
                    break;
                case 2:
                    exibirMenuChamadas(scanner);
                    break;
                case 3:
                    System.out.println("Programa encerrado.");
                    return;
                default:
                    System.out.println("Opção inválida. Digite novamente.\n");
                    break;
            }
        }
    }

    // Função para exibir o submenu de gerenciamento de alunos
    private static void exibirMenuAlunos(Scanner scanner) {
        while (true) {
            // Limpar o console
            limparConsole();

            System.out.println("\n----- Gerenciar alunos -----");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Editar aluno");
            System.out.println("3. Remover aluno");
            System.out.println("4. Voltar");
            System.out.print("Digite a opção desejada: ");

            int opcaoAlunos = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcaoAlunos) {
                case 1:
                    adicionarAluno(scanner);
                    break;
                case 2:
                    editarAluno(scanner);
                    break;
                case 3:
                    removerAluno(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Digite novamente.\n");
                    break;
            }
        }
    }

    // Função para adicionar um aluno
    private static void adicionarAluno(Scanner scanner) {
        if (countAlunos >= alunos.length) {
            System.out.println("Não é possível adicionar mais alunos.");
            return;
        }

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        alunos[countAlunos] = nome;
        countAlunos++;

        System.out.println("Aluno adicionado com sucesso!\n");
    }

    // Função para editar um aluno
    private static void editarAluno(Scanner scanner) {
        if (countAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.\n");
            return;
        }

        exibirAlunos();

        System.out.print("Digite o número do aluno que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (indice < 1 || indice > countAlunos) {
            System.out.println("Indice invalido.\n");
            return;
        }

        System.out.print("Digite o novo nome do aluno: ");
        String novoNome = scanner.nextLine();

        alunos[indice - 1] = novoNome;

        System.out.println("Aluno editado com sucesso!\n");
    }

    // Função para remover um aluno
    private static void removerAluno(Scanner scanner) {
        if (countAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.\n");
            return;
        }

        exibirAlunos();

        System.out.print("Digite o número do aluno que deseja remover: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (indice < 1 || indice > countAlunos) {
            System.out.println("Indice invalido.\n");
            return;
        }

        for (int i = indice - 1; i < countAlunos - 1; i++) {
            alunos[i] = alunos[i + 1];
        }

        countAlunos--;

        System.out.println("Aluno removido com sucesso!\n");
    }

    // Função para exibir a lista de alunos
    private static void exibirAlunos() {
        System.out.println("Lista de alunos:");
        for (int i = 0; i < countAlunos; i++) {
            System.out.println((i + 1) + ". " + alunos[i]);
        }
        System.out.println();
    }

    // Função para exibir o submenu de gerenciamento de chamadas
    private static void exibirMenuChamadas(Scanner scanner) {
        while (true) {
            // Limpar o console
            limparConsole();

            System.out.println("\n----- Gerenciar chamadas -----");
            System.out.println("1. Fazer chamada");
            System.out.println("2. Ver última chamada");
            System.out.println("3. Remover última chamada");
            System.out.println("4. Voltar");
            System.out.print("Digite a opção desejada: ");

            int opcaoChamadas = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcaoChamadas) {
                case 1:
                    fazerChamada();
                    break;
                case 2:
                    verUltimaChamada();
                    break;
                case 3:
                    removerUltimaChamada();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Digite novamente.\n");
                    break;
            }
        }
    }

    // Função para fazer uma chamada
    private static void fazerChamada() {
        System.out.println("Fazendo chamada...\n");
    }

    // Função para exibir a última chamada
    private static void verUltimaChamada() {
        System.out.println("Exibindo última chamada...\n");
    }

  

    // Função para limpar o console
    private static void limparConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}