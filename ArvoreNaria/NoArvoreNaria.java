package ArvoreNaria;

public class NoArvoreNaria<T> {
  private T info;
  private NoArvoreNaria<T> primeiro;
  private NoArvoreNaria<T> proximo;

  public NoArvoreNaria(T info) {
      this.info = info;
      this.primeiro = null;
      this.proximo = null;
  }

  public void inserirFilho(NoArvoreNaria<T> sa) {
      if (primeiro == null) {
          primeiro = sa;
      } else {
          NoArvoreNaria<T> atual = primeiro;
          while (atual.proximo != null) {
              atual = atual.proximo;
          }
          atual.proximo = sa;
      }
  }

  public T getInfo() {
      return info;
  }

  public void setInfo(T info) {
      this.info = info;
  }

  public NoArvoreNaria<T> getPrimeiro() {
      return primeiro;
  }

  public void setPrimeiro(NoArvoreNaria<T> no) {
      this.primeiro = no;
  }

  public NoArvoreNaria<T> getProximo() {
      return proximo;
  }

  public void setProximo(NoArvoreNaria<T> no) {
      this.proximo = no;
  }
}
