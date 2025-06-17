package Buscas;

public abstract class BuscaAbstract<T> {
  protected Object[] info;

  public Object[] getInfo() {
      return info;
  }

  public void setInfo(Object[] info) {
      this.info = info;
  }

  public abstract int buscar(T valor);
}
