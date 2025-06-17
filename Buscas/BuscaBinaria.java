package Buscas;

public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract<T> {
  @Override
  public int buscar(T valor) {
      int inicio = 0;
      int fim = info.length - 1;

      while (inicio <= fim) {
          int meio = (inicio + fim) / 2;
          T atual = (T) info[meio];

          if (atual.equals(valor)) return meio;
          if (valor.compareTo(atual) < 0) fim = meio - 1;
          else inicio = meio + 1;
      }
      return -1;
  }
}