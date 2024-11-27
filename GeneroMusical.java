public class GeneroMusical {
    private String nome;

    
    public GeneroMusical(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}