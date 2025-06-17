package MapaDispersao;

public class NoMapa<T> {
  private int chave;
  private T valor;

  public NoMapa(int chave, T valor) {
    this.chave = chave;
    this.valor = valor;
  }

  public int getChave() {
    return chave;
  }

  public T getValor() {
    return valor;
  }

  public void setValor(T valor) {
    this.valor = valor;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    NoMapa<?> other = (NoMapa<?>) obj;
    return chave == other.chave;
  }
}
