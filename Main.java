import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Disco");
            System.out.println("2. Listar Discos");
            System.out.println("3. Editar Disco");
            System.out.println("4. Remover Disco");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    catalogo.adicionar(scanner);  
                    break;
                case 2:
                    catalogo.listar();  
                    break;
                case 3:
                    catalogo.editar(scanner);  
                    break;
                case 4:
                    catalogo.remover(scanner);  
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 5); 
    }
}
