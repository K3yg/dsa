import ArvoreNaria.ArvoreNaria;
import ArvoreNaria.NoArvoreNaria;

public class Main {
    public static void main(String[] args) {
        ArvoreNaria<Integer> arvore = new ArvoreNaria<>();

        System.out.println("=== Testando ArvoreNaria ===");

        // Testando se a árvore está vazia
        System.out.println("A árvore está vazia? " + (arvore.getRaiz() == null));

        // Criando nós para a árvore
        NoArvoreNaria<Integer> no1 = new NoArvoreNaria<>(1);
        NoArvoreNaria<Integer> no2 = new NoArvoreNaria<>(2);
        NoArvoreNaria<Integer> no3 = new NoArvoreNaria<>(3);
        NoArvoreNaria<Integer> no4 = new NoArvoreNaria<>(4);
        NoArvoreNaria<Integer> no5 = new NoArvoreNaria<>(5);

        // Montando a árvore
        no1.inserirFilho(no2);
        no1.inserirFilho(no3);
        no2.inserirFilho(no4);
        no2.inserirFilho(no5);

        // Definindo a raiz da árvore
        arvore.setRaiz(no1);

        // Testando se a árvore está vazia após adicionar nós
        System.out.println("A árvore está vazia? " + (arvore.getRaiz() == null));

        // Testando o método pertence
        System.out.println("O valor 3 pertence à árvore? " + arvore.pertence(3));
        System.out.println("O valor 6 pertence à árvore? " + arvore.pertence(6));

        // Testando o método toString
        System.out.println("Conteúdo da árvore: " + arvore);

        // Testando o método contarNos
        System.out.println("Número total de nós na árvore: " + arvore.contarNos());

        System.out.println("=== Fim dos testes ===");
    }
}
