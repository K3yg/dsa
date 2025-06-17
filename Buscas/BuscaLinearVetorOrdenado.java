package Buscas;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract<T> {
  @Override
  public int buscar(T valor) {
      for (int i = 0; i < info.length; i++) {
          T atual = (T) info[i];
          if (atual.equals(valor)) return i;
          if (atual.compareTo(valor) > 0) break;
      }
      return -1;
  }
}
