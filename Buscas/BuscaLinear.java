package Buscas;

public class BuscaLinear<T> extends BuscaAbstract<T> {
  @Override
  public int buscar(T valor) {
      for (int i = 0; i < info.length; i++) {
          if (info[i].equals(valor)) return i;
      }
      return -1;
  }
}