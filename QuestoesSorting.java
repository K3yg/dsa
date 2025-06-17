import Sorting.OrdenacaoBolha;
import Sorting.OrdenacaoBolhaOtimizada;
import Sorting.OrdenacaoMergeSort;
import Sorting.OrdenacaoQuickSort;

public class QuestoesSorting {
  public static void main(String[] args) {
      Integer[] dados = {70, 2, 88, 15, 90, 30};

      System.out.println("Questao 1 - Ordenacao Bolha");
      OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
      bolha.setInfo(dados.clone());
      bolha.ordenar();
      System.out.print("Resultado da ordenacao (Bolha): ");
      imprimir(bolha.getInfo());

      System.out.println("\nQuestao 2 - Ordenacao Bolha Otimizada");
      OrdenacaoBolhaOtimizada<Integer> bolhaOtimizada = new OrdenacaoBolhaOtimizada<>();
      bolhaOtimizada.setInfo(dados.clone());
      bolhaOtimizada.ordenar();
      System.out.print("Resultado da ordenacao (Bolha Otimizada): ");
      imprimir(bolhaOtimizada.getInfo());

      System.out.println("\nQuestao 3 - Ordenacao QuickSort");
      OrdenacaoQuickSort<Integer> quickSort = new OrdenacaoQuickSort<>();
      quickSort.setInfo(dados.clone());
      quickSort.ordenar();
      System.out.print("Resultado da ordenacao (QuickSort): ");
      imprimir(quickSort.getInfo());

      System.out.println("\nQuestao 4 - Ordenacao MergeSort");
      OrdenacaoMergeSort<Integer> mergeSort = new OrdenacaoMergeSort<>();
      mergeSort.setInfo(dados.clone());
      mergeSort.ordenar();
      System.out.print("Resultado da ordenacao (MergeSort): ");
      imprimir(mergeSort.getInfo());
  }

  private static void imprimir(Integer[] vetor) {
      for (Integer i : vetor) {
          System.out.print(i + " ");
      }
      System.out.println();
  }
}
