import ArvoreBinariaBusca.ArvoreBinaria;
public class QuestoesArvoreBusca {
  public static void main(String[] args) {
      System.out.println("Caso 1 - Insercao e toString:");
      ArvoreBinaria<Integer> arvore1 = new ArvoreBinaria<>();
      int[] dados1 = {50,30,70,40,25,75,65,35,60};
      for (int valor : dados1) {
          arvore1.inserir(valor);
      }
      System.out.println("Esperado: <50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>");
      System.out.println("Obtido:   " + arvore1.toString());

      System.out.println("\nCaso 2 - Remocao de folha (nó 40):");
      ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>();
      int[] dados2 = {50,30,25,40};
      for (int valor : dados2) {
          arvore2.inserir(valor);
      }
      arvore2.remover(40);
      System.out.println("Esperado: <50<30<25<><>><>>");
      System.out.println("Obtido:   " + arvore2.toString());

      System.out.println("\nCaso 3 - Remocao de nó com um filho (nó 71):");
      ArvoreBinaria<Integer> arvore3 = new ArvoreBinaria<>();
      int[] dados3 = {80,52,90,48,71,63,67};
      for (int valor : dados3) {
          arvore3.inserir(valor);
      }
      arvore3.remover(71);
      System.out.println("Esperado: <80<52<48<><>><63<><67<><>>>><90<><>>>");
      System.out.println("Obtido:   " + arvore3.toString());
  }
}
