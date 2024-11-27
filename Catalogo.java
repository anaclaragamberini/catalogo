import java.util.ArrayList;
import java.util.List;

public class Catalogo implements Gerenciavel {
    private List<Disco> discos;
    private List<Artista> artistas;

    // Construtor
    public Catalogo() {
        // Inicializando as listas
        this.discos = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }

    // Adiciona um novo disco ao catálogo
    @Override
    public void adicionar() {
        // Criando gêneros musicais
        GeneroMusical rock = new GeneroMusical("Rock");
        GeneroMusical pop = new GeneroMusical("Pop");

        // Criando artistas
        Artista artista1 = new Artista("Queen", rock);
        Artista artista2 = new Artista("Michael Jackson", pop);

        // Adicionando artistas à lista
        artistas.add(artista1);
        artistas.add(artista2);

        // Criando discos (agora com ArrayList de faixas, que é mutável)
        List<String> faixas1 = new ArrayList<>();
        faixas1.add("Bohemian Rhapsody");
        faixas1.add("We Will Rock You");

        List<String> faixas2 = new ArrayList<>();
        faixas2.add("Billie Jean");
        faixas2.add("Thriller");

        Disco disco1 = new Disco("A Night at the Opera", 1975, faixas1, artista1);
        Disco disco2 = new Disco("Thriller", 1982, faixas2, artista2);

        // Adicionando discos à lista
        discos.add(disco1);
        discos.add(disco2);
    }

    // Edita as informações de um disco ou artista
    @Override
    public void editar() {
        // Para fins de exemplo, vamos editar o título de um disco e o nome de um artista
        if (!discos.isEmpty()) {
            System.out.println("Antes da edição: " + discos.get(0));
            discos.get(0).setTitulo("A Night at the Opera - Remastered");  // Edita o título do disco
        }

        if (!artistas.isEmpty()) {
            System.out.println("Antes da edição: " + artistas.get(0));
            artistas.get(0).setNome("Freddie Mercury (Remastered)");  // Edita o nome do artista
        }
    }

    // Remove um disco ou artista do catálogo
    @Override
    public void remover() {
        if (!discos.isEmpty()) {
            System.out.println("Removendo disco: " + discos.get(0).getTitulo());
            discos.remove(0);  // Remove o primeiro disco
        }
        if (!artistas.isEmpty()) {
            System.out.println("Removendo artista: " + artistas.get(0).getNome());
            artistas.remove(0);  // Remove o primeiro artista
        }
    }

    // Lista todos os discos e artistas do catálogo
    @Override
    public void listar() {
        System.out.println("Discos cadastrados:");
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (Disco disco : discos) {
                System.out.println(disco);
            }
        }

        System.out.println("\nArtistas cadastrados:");
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
        } else {
            for (Artista artista : artistas) {
                System.out.println(artista);
            }
        }
    }
}
