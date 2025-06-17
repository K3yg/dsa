import java.util.Arrays;

import Sorting.OrdenacaoAbstract;
import Sorting.OrdenacaoBolha;
import Sorting.OrdenacaoBolhaOtimizada;
import Sorting.OrdenacaoMergeSort;
import Sorting.OrdenacaoQuickSort;

public class TesteOrdenacao {
    public static void main(String[] args) {
        // Teste com números inteiros
        Integer[] vetor = {70, 2, 88, 15, 90, 30};
        
        System.out.println("Teste OrdenacaoBolha:");
        testarOrdenacao(new OrdenacaoBolha<>(), vetor.clone());
        
        System.out.println("\nTeste OrdenacaoBolhaOtimizada:");
        testarOrdenacao(new OrdenacaoBolhaOtimizada<>(), vetor.clone());
        
        System.out.println("\nTeste OrdenacaoQuickSort:");
        testarOrdenacao(new OrdenacaoQuickSort<>(), vetor.clone());
        
        System.out.println("\nTeste OrdenacaoMergeSort:");
        testarOrdenacao(new OrdenacaoMergeSort<>(), vetor.clone());
    }
    
    private static void testarOrdenacao(OrdenacaoAbstract<Integer> ordenacao, Integer[] vetor) {
        ordenacao.setInfo(vetor);
        System.out.println("Antes: " + Arrays.toString(ordenacao.getInfo()));
        ordenacao.ordenar();
        System.out.println("Depois: " + Arrays.toString(ordenacao.getInfo()));
    }
}