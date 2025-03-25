package Lista.ListaDupla;

public class ListaDupla<T> {
  private NoListaDupla<T> primeiro;

  public ListaDupla() {
    this.primeiro = null;
  }
   
  public NoListaDupla<T> getPrimeiro() {
    return this.primeiro;
  }

  public void inserir(T valor) {
    NoListaDupla<T> novoNoLista = new NoListaDupla<>();
    novoNoLista.setInfo(valor);
    novoNoLista.setProximo(this.primeiro);
    if (this.primeiro != null ) {
      this.primeiro.setAnterior(novoNoLista);
    }
    this.primeiro = novoNoLista;
  }

  public NoListaDupla<T> buscar(T valor){
    NoListaDupla<T> p = this.primeiro;
    while (p != null){
      if (p.getInfo() == valor) {
        return p;
      }
      p = p.getProximo();
    }
    return null;
  }

  public void retirar(T valor) {
    NoListaDupla<T> p = buscar(valor);
    if (p != null) {
      if (p.equals(this.primeiro)) {
        this.primeiro = p.getProximo();
      } else {
        p.getAnterior().setProximo(p.getProximo());
      }
      if (p.getProximo() != null) {
        p.getProximo().setAnterior(p);
      }
    }
  }

  public void exibirOrdemInversa() {
    ListaDupla<T> invertida = new ListaDupla<>();
    NoListaDupla<T> p = this.primeiro;
    while (p != null) {
      invertida.inserir(p.getInfo());
      p = p.getProximo();
    }
    p = invertida.getPrimeiro();
    while (p != null) {
      System.out.println(p.getInfo());
      p = p.getProximo();
    }
  }

  public void liberar() {
    NoListaDupla<T> p = this.primeiro.getProximo();
    while (p != null) {
      p.getAnterior().setProximo(null);
      p.setAnterior(null);
      p = p.getProximo();
    }

    this.primeiro = null;

  }

  public String toString() {
    String str = "";
    NoListaDupla<T> p = this.primeiro;
    while (p != null) {
      str += p.getInfo() + " ";
      p = p.getProximo();
    }
    return str;
  }  
}
