Aqui esta um documento especificando as ações realizda no codigo e a divisao dos trabalhos realizados 
Reorganizando e Estruturando Código


ALUNOS: ANA CLARA GAMBERINI E PEDRO RAFAEL DOS SANTOS PEREIRA



1. Escolha:
O projeto escolhido por nós foi do 4° bimestre ministrado pelo professor Tiago Ravache. Este projeto foi a criação de um catálogo de discos, onde o usuário poderia manipular as informações sobre discos, artistas e gêneros musicais, seu objetivo é criar uma aplicação organizada e que consiga armazenar as informações.. O propósito do projeto é melhorar a sua estrutura, deixando-o mais prático e mais organizado.



2. Melhorias:
Os pontos de melhoria encontrados foram:
Organização e estrutura do código: Alguns métodos, por exemplo, identificamos que poderiam ser mais claros, para facilitar a leitura e manutenção do projeto
Métodos muito longos: verificamos que alguns métodos estavam repetidos e consecutivamente aumentando o tamanho do código, o que deixava o código mais “sujo”
Excesso de responsabilidade: Um método estava realizando muitas funções, verificamos que seria melhor separar cada responsabilidade



3. Alterações realizadas:

A. Código antes (Classe Catálogo):

“@Override
public void adicionar(Scanner scanner) {
    System.out.print("Digite o nome do artista: ");
    String nomeArtista = scanner.nextLine();

    System.out.print("Digite o gênero do artista (Rock, Pop, etc.): ");
    String generoArtista = scanner.nextLine();
    GeneroMusical genero = new GeneroMusical(generoArtista);

    Artista artista = new Artista(nomeArtista, genero);
    artistas.add(artista);

    System.out.print("Digite o título do disco: ");
    String tituloDisco = scanner.nextLine();

    System.out.print("Digite o ano de lançamento do disco: ");
    int anoDisco = scanner.nextInt();
    scanner.nextLine();  

    List<String> faixas = new ArrayList<>();
    String faixa;
    do {
        System.out.print("Digite uma faixa do disco (ou 'fim' para encerrar): ");
        faixa = scanner.nextLine();
        if (!faixa.equalsIgnoreCase("fim") && !faixa.isEmpty()) {
            faixas.add(faixa);
        }
    } while (!faixa.equalsIgnoreCase("fim"));

    if (faixas.isEmpty()) {
        System.out.println("O disco precisa ter ao menos uma faixa.");
        return;  
    }

    Disco disco = new Disco(tituloDisco, anoDisco, faixas, artista);
    discos.add(disco);

    System.out.println("Disco adicionado: " + disco.getTitulo() + " de " + artista.getNome());
}


@Override
public void editar(Scanner scanner) {
    if (!discos.isEmpty()) {
        listar();  

        System.out.print("Escolha o número do disco a ser editado: ");
        int indexDisco = scanner.nextInt() - 1;
        scanner.nextLine();  

        if (indexDisco >= 0 && indexDisco < discos.size()) {
            Disco disco = discos.get(indexDisco);

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
        } else {
            System.out.println("Índice inválido!");
        }
    } else {
        System.out.println("Não há discos para editar.");
    }
}

@Override
public void remover(Scanner scanner) {
    if (!discos.isEmpty()) {
        listar();  

        System.out.print("Escolha o número do disco a ser removido: ");
        int indexDisco = scanner.nextInt() - 1;
        scanner.nextLine();  

        if (indexDisco >= 0 && indexDisco < discos.size()) {
            Disco disco = discos.remove(indexDisco);
            System.out.println("Disco removido: " + disco.getTitulo());
        } else {
            System.out.println("Índice inválido!");
        }
    } else {
        System.out.println("Não há discos para remover.");
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
}"


B. Código depois:

“@Override
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
}”


C. Alterações realizadas:
Os métodos ficaram menos repetidos, o método escolherDisco() agora é usado tanto em editar() quanto em remover(), o que elimina a repetição do código.
A lógica de listar discos foi movida para o método listarDiscos(), que é agora reutilizado tanto em listar(), editar() e remover(). Isso evita que a mesma lógica de listagem seja repetida em múltiplos lugares.
 A lógica de obter faixas foi centralizada no método obterFaixas(), agora é reutilizado em adicionar() e editar(), evitando repetição de código para coletar as faixas do usuário.

Agora o código está mais conciso e organizado, com menos repetições, o que facilita tanto a manutenção quanto a escalabilidade.
4. Papel de Cada integrante:
Pedro realizou as mudanças necessárias para melhoria do código diminuindo os métodos e dividindo suas responsabilidades. A Ana identificou os pontos de melhoria e organizou a especificação de cada método, deixando o código mais limpo e claro de identificar cada função.



5. Código Original

O código original pode ser encontrado no repositório (Classe Catálogo): https://github.com/anaclaragamberini/catalogo.git
