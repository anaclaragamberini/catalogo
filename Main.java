public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        catalogo.adicionar();

        catalogo.listar();

        catalogo.editar();

        System.out.println("\nApós edição:");
        catalogo.listar();

        catalogo.remover();

        System.out.println("\nApós remoção:");
        catalogo.listar();
    }
}