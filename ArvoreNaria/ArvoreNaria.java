package ArvoreNaria;

public class ArvoreNaria<T> {
  private NoArvoreNaria<T> raiz;

  public ArvoreNaria() {
      raiz = null;
  }

  public NoArvoreNaria<T> getRaiz() {
      return raiz;
  }

  public void setRaiz(NoArvoreNaria<T> raiz) {
      this.raiz = raiz;
  }

  public String toString() {
      return obterRepresentacaoTextual(raiz);
  }

  private String obterRepresentacaoTextual(NoArvoreNaria<T> no) {
      if (no == null) {
          return "";
      }
      StringBuilder sb = new StringBuilder();
      sb.append(no.getInfo());
      sb.append("<");
      NoArvoreNaria<T> filho = no.getPrimeiro();
      while (filho != null) {
          sb.append(obterRepresentacaoTextual(filho));
          filho = filho.getProximo();
      }
      sb.append(">");
      return sb.toString();
  }

  public boolean pertence(T info) {
      return pertence(raiz, info);
  }

  private boolean pertence(NoArvoreNaria<T> no, T info) {
      if (no == null) {
          return false;
      }
      if (no.getInfo().equals(info)) {
          return true;
      }
      NoArvoreNaria<T> filho = no.getPrimeiro();
      while (filho != null) {
          if (pertence(filho, info)) {
              return true;
          }
          filho = filho.getProximo();
      }
      return false;
  }

  public int contarNos() {
      return contarNos(raiz);
  }

  private int contarNos(NoArvoreNaria<T> no) {
      if (no == null) {
          return 0;
      }
      int count = 1;
      NoArvoreNaria<T> filho = no.getPrimeiro();
      while (filho != null) {
          count += contarNos(filho);
          filho = filho.getProximo();
      }
      return count;
  }
}
