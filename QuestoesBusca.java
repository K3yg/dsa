import Buscas.BuscaBinaria;
import Buscas.BuscaLinear;
import Buscas.BuscaLinearVetorOrdenado;

public class QuestoesBusca {
    public static void main(String[] args) {
        Integer[] dados = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println("\nCaso 1 - Busca Linear");
        BuscaLinear<Integer> buscaLinear = new BuscaLinear<>();
        buscaLinear.setInfo(dados);
        System.out.println("Buscar 20 => Esperado: 2, Obtido: " + buscaLinear.buscar(20));

        System.out.println("\nCaso 2 - Busca Linear Vetor Ordenado");
        BuscaLinearVetorOrdenado<Integer> buscaLinearOrd = new BuscaLinearVetorOrdenado<>();
        buscaLinearOrd.setInfo(dados);
        System.out.println("Buscar 40 => Esperado: 4, Obtido: " + buscaLinearOrd.buscar(40));

        System.out.println("\nCaso 3 - Busca Binaria (valor presente)");
        BuscaBinaria<Integer> buscaBinaria = new BuscaBinaria<>();
        buscaBinaria.setInfo(dados);
        System.out.println("Buscar 70 => Esperado: 7, Obtido: " + buscaBinaria.buscar(70));

        System.out.println("\nCaso 4 - Busca Binaria (valor ausente)");
        buscaBinaria.setInfo(dados);
        System.out.println("Buscar 75 => Esperado: -1, Obtido: " + buscaBinaria.buscar(75));
    }
}
