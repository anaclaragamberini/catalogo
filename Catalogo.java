import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo implements Gerenciavel {
    private List<Disco> discos;
    private List<Artista> artistas;

    public Catalogo() {
        this.discos = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }

    @Override
    public void adicionar(Scanner scanner) {
        Artista artista = criarArtista(scanner);
        Disco disco = criarDisco(scanner, artista);

        if (disco != null) {
            discos.add(disco);
            System.out.println("Disco adicionado: " + disco.getTitulo() + " de " + artista.getNome());
        }
    }

    private Artista criarArtista(Scanner scanner) {
        System.out.print("Digite o nome do artista: ");
        String nomeArtista = scanner.nextLine();

        System.out.print("Digite o gênero do artista (Rock, Pop, etc.): ");
        String generoArtista = scanner.nextLine();
        GeneroMusical genero = new GeneroMusical(generoArtista);

        return new Artista(nomeArtista, genero);
    }

    private Disco criarDisco(Scanner scanner, Artista artista) {
        System.out.print("Digite o título do disco: ");
        String tituloDisco = scanner.nextLine();

        System.out.print("Digite o ano de lançamento do disco: ");
        int anoDisco = scanner.nextInt();
        scanner.nextLine();  

        List<String> faixas = obterFaixas(scanner);
        
        if (faixas.isEmpty()) {
            System.out.println("O disco precisa ter ao menos uma faixa.");
            return null;
        }

        return new Disco(tituloDisco, anoDisco, faixas, artista);
    }

    private List<String> obterFaixas(Scanner scanner) {
        List<String> faixas = new ArrayList<>();
        String faixa;
        do {
            System.out.print("Digite uma faixa do disco (ou 'fim' para encerrar): ");
            faixa = scanner.nextLine();
            if (!faixa.equalsIgnoreCase("fim") && !faixa.isEmpty()) {
                faixas.add(faixa);
            }
        } while (!faixa.equalsIgnoreCase("fim"));
        return faixas;
    }

    @Override
    public void editar(Scanner scanner) {
        if (discos.isEmpty()) {
            System.out.println("Não há discos para editar.");
            return;
        }
        listarDiscos();  
        int indexDisco = escolherDisco(scanner);

        if (indexDisco >= 0 && indexDisco < discos.size()) {
            Disco disco = discos.get(indexDisco);
            editarDisco(scanner, disco);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private int escolherDisco(Scanner scanner) {
        System.out.print("Escolha o número do disco a ser editado: ");
        return scanner.nextInt() - 1;
    }

    private void editarDisco(Scanner scanner, Disco disco) {
        scanner.nextLine();  

        System.out.print("Digite o novo título do disco: ");
        String novoTitulo = scanner.nextLine();
        disco.setTitulo(novoTitulo);

        System.out.print("Digite o novo ano de lançamento do disco: ");
        int novoAno = scanner.nextInt();
        scanner.nextLine(); 
        disco.setAno(novoAno);

        System.out.print("Digite as novas faixas do disco (separadas por vírgula): ");
        String novasFaixasInput = scanner.nextLine();
        List<String> novasFaixas = new ArrayList<>();
        for (String faixa : novasFaixasInput.split(",\\s*")) {
            novasFaixas.add(faixa);
        }
        disco.setFaixas(novasFaixas);

        System.out.println("Disco editado: " + disco.getTitulo());
    }

    @Override
    public void remover(Scanner scanner) {
        if (discos.isEmpty()) {
            System.out.println("Não há discos para remover.");
            return;
        }
        listarDiscos(); 
        int indexDisco = escolherDisco(scanner);

        if (indexDisco >= 0 && indexDisco < discos.size()) {
            Disco disco = discos.remove(indexDisco);
            System.out.println("Disco removido: " + disco.getTitulo());
        } else {
            System.out.println("Índice inválido!");
        }
    }

    @Override
    public void listar() {
        listarDiscos();
        listarArtistas();
    }

    private void listarDiscos() {
        System.out.println("Discos cadastrados:");
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (Disco disco : discos) {
                System.out.println(disco);
            }
        }
    }

    private void listarArtistas() {
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
