import java.util.ArrayList;
import java.util.List;

public class Catalogo implements Gerenciavel {
    private List<Disco> discos;
    private List<Artista> artistas;

    
    public Catalogo() {
        this.discos = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }

    @Override
    public void adicionar() {
        GeneroMusical rock = new GeneroMusical("Rock");
        GeneroMusical pop = new GeneroMusical("Pop");

        Artista artista1 = new Artista("Queen", rock);
        Artista artista2 = new Artista("Michael Jackson", pop);

        artistas.add(artista1);
        artistas.add(artista2);

        List<String> faixas1 = new ArrayList<>();
        faixas1.add("Bohemian Rhapsody");
        faixas1.add("We Will Rock You");

        List<String> faixas2 = new ArrayList<>();
        faixas2.add("Billie Jean");
        faixas2.add("Thriller");

        Disco disco1 = new Disco("A Night at the Opera", 1975, faixas1, artista1);
        Disco disco2 = new Disco("Thriller", 1982, faixas2, artista2);

        discos.add(disco1);
        discos.add(disco2);
    }

    @Override
    public void editar() {
        if (!discos.isEmpty()) {
            System.out.println("Antes da edição: " + discos.get(0));
            discos.get(0).setTitulo("A Night at the Opera - Remastered");  
        }

        if (!artistas.isEmpty()) {
            System.out.println("Antes da edição: " + artistas.get(0));
            artistas.get(0).setNome("Freddie Mercury (Remastered)");  
        }
    }

    @Override
    public void remover() {
        if (!discos.isEmpty()) {
            System.out.println("Removendo disco: " + discos.get(0).getTitulo());
            discos.remove(0);  
        }
        if (!artistas.isEmpty()) {
            System.out.println("Removendo artista: " + artistas.get(0).getNome());
            artistas.remove(0); 
        }
    }

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
