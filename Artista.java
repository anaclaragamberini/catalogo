public class Artista {
    private String nome;
    private GeneroMusical generoMusical;

    public Artista(String nome, GeneroMusical generoMusical) {
        this.nome = nome;
        this.generoMusical = generoMusical;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    @Override
    public String toString() {
        return nome + " (" + generoMusical.getNome() + ")";
    }
}
