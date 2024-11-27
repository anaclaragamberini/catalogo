import java.util.Scanner;

public interface Gerenciavel {
    void adicionar(Scanner scanner);
    void editar(Scanner scanner);
    void remover(Scanner scanner);
    void listar();
}
