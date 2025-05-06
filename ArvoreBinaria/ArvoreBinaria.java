package ArvoreBinaria;

public class ArvoreBinaria<T> {
  private NoArvoreBinaria<T> raiz;

  public ArvoreBinaria() {
    this.raiz = null;
  }

  public void setRaiz(NoArvoreBinaria<T> raiz) {
    this.raiz = raiz;
  }

  public boolean estaVazia() {
    return this.raiz == null;
  }

  public boolean pertence(T info) {
    return pertence(this.raiz, info);
  }

  private boolean pertence(NoArvoreBinaria<T> no, T info) {
    if (no == null) {
      return false;
    }
    if (no.getInfo().equals(info)) {
      return true;
    }
    return pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
  }

  public String toString() {
    return toString(this.raiz);
  }

  private String toString(NoArvoreBinaria<T> no) {
    if (no == null) {
        return "<>";
    }
    return "<" + no.getInfo() + toString(no.getEsquerda()) + toString(no.getDireita()) + ">";
  }

  public int contarNos() {
    return contarNos(this.raiz);
  }

  private int contarNos(NoArvoreBinaria<T> no) {
    if (no == null) {
      return 0;
    }
    return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
  }
}
